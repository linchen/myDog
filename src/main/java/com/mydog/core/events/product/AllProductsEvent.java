package com.mydog.core.events.product;

import com.mydog.core.events.ReadEvent;

import java.util.List;

/**
 * Created by Lin on 21.04.14.
 */
public class AllProductsEvent extends ReadEvent{

    private List<ProductDetails> productDetails;

    public AllProductsEvent(List<ProductDetails> productDetails) {
        this.productDetails = productDetails;
    }

    public List<ProductDetails> getProductDetails() {
        return productDetails;
    }
}
