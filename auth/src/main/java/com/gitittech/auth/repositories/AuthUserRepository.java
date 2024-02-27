/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gitittech.auth.repositories;

import com.gitittech.auth.models.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ambrose Ariagiegbe
 */
@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, String>{
    
    public AuthUser findByUsername(String username);        
       
}
