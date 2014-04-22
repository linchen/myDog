package com.mydog.core.domain;

import com.mydog.core.events.product.ProductDetails;

import java.math.BigDecimal;

/**
 * Created by Lin on 21.04.14.
 */
public class Product {

    private String id;
    private String name;
    private String description;

    private BigDecimal cost;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public static Product fromProductDetails(ProductDetails productDetails) {
        Product product = new Product();
        product.cost = productDetails.getCost();
        product.id  =productDetails.getId();
        product.description = productDetails.getDescription();
        product.name = productDetails.getName();
        return product;
    }

    public ProductDetails toProductDetails() {
        return new ProductDetails(id, name, description, cost);
    }
}
