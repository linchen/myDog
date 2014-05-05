package com.mydog.core.events.product;

import com.mydog.core.events.RequestReadEvent;

/**
 * Created by Lin on 21.04.14.
 */
public class RequestProductDetailsEvent extends RequestReadEvent {

    private String id;

    public RequestProductDetailsEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
