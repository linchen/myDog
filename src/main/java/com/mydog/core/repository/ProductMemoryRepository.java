package com.mydog.core.repository;

import com.mydog.core.domain.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lin on 21.04.14.
 */
public class ProductMemoryRepository implements ProductRepository {

    private Map<String, Product> products = new HashMap<>();

    public ProductMemoryRepository() {
    }

    public ProductMemoryRepository(Map<String, Product> products) {
        this.products = products;
    }

    @Override
    public Product save(Product product) {
        products.put(product.getId(), product);
        return product;
    }

    @Override
    public void delete(String key) {
        products.remove(key);
    }

    @Override
    public Product findById(String key) {
        for(Product product: products.values()) {
            if(product.getId().equals(key)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Iterable<Product> findAll() {
        return new ArrayList<>(products.values());
    }
}
