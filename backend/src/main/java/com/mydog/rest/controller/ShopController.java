package com.mydog.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mydog.core.domain.Phone;
import com.mydog.core.domain.Product;
import com.mydog.core.events.product.AllProductsEvent;
import com.mydog.core.events.product.ProductDetails;
import com.mydog.core.events.product.ProductDetailsEvent;
import com.mydog.core.events.product.RequestAllProductsEvent;
import com.mydog.core.events.product.RequestProductDetailsEvent;
import com.mydog.core.services.ProductService;
import com.mydog.rest.domain.Basket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lin on 21.04.14.
 */

@Controller
@RequestMapping("/products")
public class ShopController {

    private static final Logger LOG = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private Basket basket;

    @RequestMapping
    @ResponseBody
    public List<Phone> phones() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String url = "/Users/lchen/TUI-develop/workspace/tutorial/myDog/frontend/app/phones/phones.json";
        List<Phone> phones = mapper.readValue(new File(url), List.class);
        return phones;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Product> getProducts() {
        return getProducts(productService.requestAllProducts(new RequestAllProductsEvent()));
    }

    private List<Product> getProducts(AllProductsEvent allProductsEvent) {
        List<Product> products = new ArrayList<>();
      for(ProductDetails productDetails:  allProductsEvent.getProductDetails()){
          products.add(Product.fromProductDetails(productDetails));
      }
        return products;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        ProductDetailsEvent details = productService.requestProductDetails(new RequestProductDetailsEvent(id));
        if (!details.isEntityFound()) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        Product order = Product.fromProductDetails(details.getProductDetails());
        return new ResponseEntity<Product>(order, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/basket")
    public ResponseEntity<Basket> getBasket() {
        return new ResponseEntity<Basket>(basket, HttpStatus.OK);
    }
}
