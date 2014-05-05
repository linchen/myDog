package com.mydog.core.events.Orders;

import com.mydog.core.events.ReadEvent;

import java.util.UUID;

public class OrderStatusEvent extends ReadEvent{

    private UUID key;
    private OrderStatusDetails orderStatus;

    public OrderStatusEvent(UUID key) {
        this.key = key;
    }

    public OrderStatusEvent(UUID key, OrderStatusDetails orderStatus) {
        this.key = key;
        this.orderStatus = orderStatus;
    }

    public UUID getKey() {
        return key;
    }

    public OrderStatusDetails getOrderStatus() {
        return orderStatus;
    }

    public static OrderStatusEvent notFound(UUID key) {
        OrderStatusEvent ev = new OrderStatusEvent(key);
        ev.entityFound = false;
        return ev;
    }
}
