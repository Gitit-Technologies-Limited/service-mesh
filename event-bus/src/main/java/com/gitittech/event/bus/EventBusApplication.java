

package com.gitittech.event.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author HP
 */
@SpringBootApplication
@ComponentScan("com.gitittech.event.bus.services")
public class EventBusApplication {
    public static void main(String[] args) {
        SpringApplication.run(EventBusApplication.class, args);
    }
}
