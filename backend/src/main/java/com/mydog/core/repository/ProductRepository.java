package com.mydog.core.repository;

import com.mydog.core.domain.Product;

/**
 * Created by Lin on 21.04.14.
 */
public interface ProductRepository {


    Product save(Product product);

    void delete(String key);

    Product findById(String key);

    Iterable<Product> findAll();
}
