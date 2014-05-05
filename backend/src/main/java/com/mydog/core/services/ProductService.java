package com.mydog.core.services;

import com.mydog.core.events.product.*;

/**
 * Created by Lin on 21.04.14.
 */
public interface ProductService {

    AllProductsEvent requestAllProducts(RequestAllProductsEvent requestAllProductsEvent);
    ProductDetailsEvent requestProductDetails(RequestProductDetailsEvent requestProductDetailsEvent);
    ProductDetailsEvent createProduct(CreateProductEvent createProductEvent);
}
