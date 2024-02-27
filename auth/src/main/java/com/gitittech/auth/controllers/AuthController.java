/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gitittech.auth.controllers;

import com.gitittech.auth.dtos.DtoAuthUser;
import com.gitittech.auth.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ambrose Ariagiegbe
 */
@RestController
@RequestMapping("auth")
public class AuthController {
  
    private final AuthService authService;
    
    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }
    
    public ResponseEntity signin(DtoAuthUser user) throws Throwable{
        this.authService.signIn(user);
        return ResponseEntity.noContent().build();
    }
}
