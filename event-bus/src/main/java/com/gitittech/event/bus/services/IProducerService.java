/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gitittech.event.bus.services;

import com.gitittech.event.bus.models.Event;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ambrose Ariagiegbe
 */
@Service
public interface IProducerService {
    void sendEvent(Event msg);
}
