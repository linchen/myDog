package com.mydog.core.events.Orders;

import com.mydog.core.events.DeleteEvent;

import java.util.UUID;

/**
 * Created by Lin on 21.04.14.
 */
public class DeleteOrderEvent  extends DeleteEvent{

    private final UUID key;

    public DeleteOrderEvent(UUID key) {
        this.key = key;
    }

    public UUID getKey() {
        return key;
    }
}
