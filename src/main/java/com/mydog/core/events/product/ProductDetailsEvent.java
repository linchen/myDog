package com.mydog.core.events.product;

import com.mydog.core.events.ReadEvent;

/**
 * Created by Lin on 21.04.14.
 */
public class ProductDetailsEvent extends ReadEvent {

    private String key;
    private ProductDetails productDetails;

    private ProductDetailsEvent() {
    }

    public ProductDetailsEvent(String key, ProductDetails productDetails) {
        this.key = key;
        this.productDetails = productDetails;
    }

    public String getKey() {
        return key;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public static ProductDetailsEvent notFound(String key) {
        ProductDetailsEvent ev = new ProductDetailsEvent();
        ev.key = key;
        ev.entityFound = false;
        return ev;
    }
}
