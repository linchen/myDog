package com.mydog.core.events.Orders;

import com.mydog.core.events.CreatedEvent;

import java.util.UUID;

/**
 * Created by Lin on 21.04.14.
 */
public class OrderCreatedEvent extends CreatedEvent {

    private final UUID newOrderKey;
    private final OrderDetails details;

    public OrderCreatedEvent(UUID newOrderKey, OrderDetails details) {
        this.newOrderKey = newOrderKey;
        this.details = details;
    }

    public UUID getNewOrderKey() {
        return newOrderKey;
    }

    public OrderDetails getDetails() {
        return details;
    }
}
