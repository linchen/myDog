package com.mydog.rest.controller.fixture;

import com.mydog.core.events.Orders.OrderCreatedEvent;
import com.mydog.core.events.Orders.OrderDeletedEvent;
import com.mydog.core.events.Orders.OrderDetailsEvent;
import com.mydog.core.events.Orders.OrderStatusDetails;
import com.mydog.core.events.Orders.OrderStatusEvent;

import java.util.Date;
import java.util.UUID;

import static com.mydog.rest.controller.fixture.RestDataFixture.customKeyOrderDetails;
import static com.mydog.rest.controller.fixture.RestDataFixture.standardOrderDetails;


public class RestEventFixtures {

    public static OrderStatusEvent orderStatusNotFound(UUID key) {
        return OrderStatusEvent.notFound(key);
    }

    public static OrderStatusEvent orderStatus(UUID key, String status) {
        return new OrderStatusEvent(key, new OrderStatusDetails(new Date(), status));
    }

    public static OrderDetailsEvent orderDetailsNotFound(UUID key) {
        return OrderDetailsEvent.notFound(key);
    }
    public static OrderDetailsEvent orderDetailsEvent(UUID key) {
        return new OrderDetailsEvent(key, customKeyOrderDetails(key));
    }
    public static OrderCreatedEvent orderCreated(UUID key) {
        return new OrderCreatedEvent(key, customKeyOrderDetails(key));
    }
    public static OrderDeletedEvent orderDeleted(UUID key) {
        return new OrderDeletedEvent(key, standardOrderDetails());
    }
    public static OrderDeletedEvent orderDeletedFailed(UUID key) {
        return OrderDeletedEvent.deletionForbidden(key, standardOrderDetails());
    }
    public static OrderDeletedEvent orderDeletedNotFound(UUID key) {
        return OrderDeletedEvent.notFound(key);
    }
}
