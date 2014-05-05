package com.mydog.core.events.Orders;

import com.mydog.core.events.CreateEvent;

/**
 * Created by Lin on 21.04.14.
 */
public class CreateOrderEvent extends CreateEvent{
    private OrderDetails details;

    public CreateOrderEvent(OrderDetails details) {
        this.details = details;
    }

    public OrderDetails getDetails() {
        return details;
    }
}
