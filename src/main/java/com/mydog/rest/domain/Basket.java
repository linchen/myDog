package com.mydog.rest.domain;

import com.mydog.core.domain.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Basket {

    private Map<String, Product> products = new HashMap<>();

    public Basket() {
    }

    public Basket(Map<String, Product> products) {
        this.products = products;
    }


    public Product add(Product product) {
        products.put(product.getId(), product);
        return product;
    }

    public void delete(String key) {
        products.remove(key);
    }

    public Product findById(String key) {
        for(Product product: products.values()) {
            if(product.getId().equals(key)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public List<Product> getProducts() {
        return findAll();
    }

    public int getSize() {
        return products.size();
    }
}
