/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gitittech.auth.models;

import com.gitittech.common.models.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Objects;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ambrose Ariagiegbe
 */
@Entity
@Table(name="auth_user")
public class AuthUser extends BaseEntity{  
    @NotNull(message="Username must be set")
    @Column(name="username")
    private String username;
    @NotNull(message="Password must be set")
    @Column(name="password")
    private String password;
    @NotNull(message="Client must be set")
    @Column(name="client")
    private String client;
    @Column(name="mfa_enabled")
    private boolean mfaEnabled = false;
    @Column(name="enabled")
    private boolean enabled = false;    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public boolean isMfaEnabled() {
        return mfaEnabled;
    }

    public void setMfaEnabled(boolean mfaEnabled) {
        this.mfaEnabled = mfaEnabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
 

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AuthUser other = (AuthUser) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "AuthUser{" + "id=" + id + ", username=" + username + '}';
    }        
    
}
