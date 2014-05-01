package com.mydog.core.events.Orders;

import com.mydog.core.events.ReadEvent;

import java.util.List;


public class AllOrdersEvent extends ReadEvent {

    private final List<OrderDetails> orderDetails;

    public AllOrdersEvent(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }
}
