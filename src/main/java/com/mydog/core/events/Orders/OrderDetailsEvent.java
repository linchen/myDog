package com.mydog.core.events.Orders;

import com.mydog.core.events.ReadEvent;

import java.util.UUID;

/**
 * Created by Lin on 21.04.14.
 */
public class OrderDetailsEvent extends ReadEvent {
    private UUID key;
    private OrderDetails orderDetails;

    public OrderDetailsEvent(UUID key) {
        this.key = key;
    }

    public OrderDetailsEvent(UUID key, OrderDetails orderDetails) {
        this.key = key;
        this.orderDetails = orderDetails;
    }

    public UUID getKey() {
        return key;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public static OrderDetailsEvent notFound(UUID key) {
        OrderDetailsEvent ev = new OrderDetailsEvent(key);
        ev.entityFound = false;
        return ev;
    }
}
