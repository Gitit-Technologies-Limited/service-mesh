/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gitittech.auth.services;

import com.gitittech.auth.dtos.DtoAuthUser;
import com.gitittech.auth.dtos.DtoUserWithToken;

/**
 *
 * @author Ambrose Ariagiegbe
 */
public interface IAuthService {    
    DtoUserWithToken signIn(DtoAuthUser user) throws Throwable;
}
