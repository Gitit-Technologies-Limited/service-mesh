package com.gitittech.auth.controllers;

import com.gitittech.auth.exceptions.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.gitittech.common.models.Error;

/**
 *
 * @author Ambrose Ariagiegbe
 */
@ControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Error> handleAuthException(Exception ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new Error(6001, "Authentication failed"));
    }

    public void handleNotFoundException() {
    }
}
