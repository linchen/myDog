package com.mydog.core.events.product;

import com.mydog.core.events.CreatedEvent;

/**
 * Created by Lin on 21.04.14.
 */
public class CreateProductEvent extends CreatedEvent{

    private ProductDetails details;

    public CreateProductEvent(ProductDetails details) {
        this.details = details;
    }

    public ProductDetails getDetails() {
        return details;
    }
}

