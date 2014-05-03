package com.mydog.content.fixture;

import com.mydog.core.domain.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductDataFixture {


    public static Map createProduct() {
        Map<String, Product> products = new HashMap<>();
        products.put("h1", product("h1", new BigDecimal("48.00"), "Collar Black", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        products.put("h2", product("h2", new BigDecimal("25.00"), "Leash Black","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        products.put("h3", product("h3", new BigDecimal("44.00"), "Lead Black","Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        return products;
    }

    private static Product product(String id, BigDecimal cost, String name, String description) {
        Product pro = new Product();
        pro.setId(id);
        pro.setCost(cost);
        pro.setDescription(description);
        pro.setName(name);
        return pro;
    }
}
