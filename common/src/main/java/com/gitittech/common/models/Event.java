/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gitittech.common.models;

import jakarta.validation.constraints.NotNull;
import java.util.Objects;

/**
 *
 * @author Ambrose Ariagiegbe
 */
public class Event {

    private Long id;
    @NotNull(message="type muse be set")
    private String type;
    @NotNull(message="payload cannot be blank")
    private String payload;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Event other = (Event) obj;
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
    
    
}
