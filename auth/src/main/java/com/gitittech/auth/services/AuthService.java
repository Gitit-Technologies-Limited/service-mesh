package com.gitittech.auth.services;

import com.gitittech.auth.dtos.DtoAuthUser;
import com.gitittech.auth.dtos.DtoUserWithToken;
import com.gitittech.auth.exceptions.AuthenticationException;
import com.gitittech.auth.models.AuthUser;
import com.gitittech.auth.repositories.AuthUserRepository;
import com.gitittech.common.exceptions.NotFoundException;
import com.gitittech.common.models.Event;
import com.gitittech.common.utils.BearerTokenMaker;
import com.gitittech.common.utils.Encoder;
import com.gitittech.common.utils.JwtTokenUtil;
import com.google.gson.Gson;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Ambrose Ariagiegbe
 */
public class AuthService implements IAuthService {

    private final AuthUserRepository repository;
    private final JwtTokenUtil jwtTokenUtil;
    private final RestTemplate restTemplate;

    @Autowired
    public AuthService(AuthUserRepository repository, JwtTokenUtil jwtTokenUtil, RestTemplate restTemplate) {
        this.repository = repository;
        this.jwtTokenUtil = jwtTokenUtil;
        this.restTemplate = restTemplate;
    }

    @Override
    public DtoUserWithToken signIn(DtoAuthUser user) throws Throwable {
        String encryptedPassword = Encoder.hashIt(user.password());
        final var foundUser = repository.findByUsername(user.username());
        if (Objects.nonNull(foundUser) && foundUser.getPassword().equals(encryptedPassword)) {
            AtomicReference<DtoUserWithToken> userNode = new AtomicReference<>();
            if (!foundUser.isEnabled()) {
                final var authToken = jwtTokenUtil.generateToken(foundUser.getUsername());
                final var userWithToken = new DtoUserWithToken(foundUser.getId(),
                        foundUser.getUsername(),
                        BearerTokenMaker.create(authToken));
                userNode.set(userWithToken);
                notifyListeners(foundUser);
            } else {
                throw new NotFoundException("This account has been disabled.");
            }
            return userNode.get();
        } else {
            throw new AuthenticationException("Invalid login credentials");
        }
    }

    private void notifyListeners(AuthUser foundUser) {  
        final var event = new Event();
        event.setType("SignIn");
        event.setPayload(new Gson().toJson(foundUser));
        
        restTemplate.postForLocation("https://event-bus/producer", event);       
    }

}
