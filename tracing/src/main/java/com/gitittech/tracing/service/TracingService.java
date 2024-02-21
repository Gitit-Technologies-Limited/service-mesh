/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.gitittech.tracing.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author HP
 */
//@EnableZipkinStreamServer
@SpringBootApplication
public class TracingService {

    public static void main(String[] args) {
        SpringApplication.run(TracingService.class, args);
    }
}
