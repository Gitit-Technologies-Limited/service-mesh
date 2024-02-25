/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gitittech.event.bus.controllers;

import com.gitittech.event.bus.models.Event;
import com.gitittech.event.bus.services.IProducerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("producer")
public class ProducerController {
    
    @Autowired
    private IProducerService service;
    
    @PostMapping("send")
    public void send(@RequestBody @Valid Event msg){
        this.service.sendEvent(msg);
    }
}
