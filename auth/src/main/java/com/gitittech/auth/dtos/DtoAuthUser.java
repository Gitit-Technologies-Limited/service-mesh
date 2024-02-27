/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gitittech.auth.dtos;

import javax.validation.constraints.NotNull;

/*
 *
 * @author Ambrose Ariagiegbe
 */
public record DtoAuthUser ( @NotNull(message="Username must be set") String username, 
        @NotNull(message="Password must be set")String password, 
        @NotNull(message="Client must be set")String client){
    
}
