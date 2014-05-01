package com.mydog.core.events.Orders;

import com.mydog.core.events.UpdatedEvent;

import java.util.UUID;

/**
 * Created by Lin on 21.04.14.
 */
public class OrderUpdatedEvent extends UpdatedEvent {

    private UUID key;
    private OrderDetails orderDetails;

    public OrderUpdatedEvent(UUID key, OrderDetails orderDetails) {
        this.key = key;
        this.orderDetails = orderDetails;
    }

    public UUID getKey() {
        return key;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }
}
