package com.gitittech.event.bus.services;

import com.gitittech.common.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cloud.stream.function.StreamBridge;

/**
 *
 * @author Ambrose Ariaiegbe
 */
@Service
class ProducerService implements IProducerService {

    private static long id = 0l;

    @Autowired
    private StreamBridge bridge;

    @Override
    public void sendEvent(Event msg) {
        msg.setId(++id);
        this.bridge.send(msg.getType(), msg);
    }
}
