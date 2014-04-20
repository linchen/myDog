package com.mydog.web.domain;

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

    private Map<String, ProductItem> items = new HashMap<>();

    public Basket() {

    }

    public Basket(Map<String, ProductItem> items) {
        this.items = items;
    }


    public ProductItem add(ProductItem item) {
        items.put(item.getId(), item);
        return item;
    }

    public void delete(String key) {
        items.remove(key);
    }

    public ProductItem findById(String key) {
        for(ProductItem item: items.values()) {
            if(item.getId().equals(key)) {
                return item;
            }
        }
        return null;
    }

    public List<ProductItem> findAll() {
        return new ArrayList<>(items.values());
    }

    public List<ProductItem> getItems() {
        return findAll();
    }

    public int getSize() {
        return items.size();
    }
}
