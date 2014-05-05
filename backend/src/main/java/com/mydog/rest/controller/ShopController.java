package com.mydog.rest.controller;

import com.mydog.core.domain.Product;
import com.mydog.core.events.product.*;
import com.mydog.core.services.ProductService;
import com.mydog.rest.domain.Basket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lin on 21.04.14.
 */

@Controller
@RequestMapping("/shop")
public class ShopController {

    private static final Logger LOG = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private Basket basket;

    @RequestMapping(method = RequestMethod.GET)
    public String getProducts(Model model) {
        LOG.debug("productDetails to shop view");
        List<Product> proucts = getProducts(productService.requestAllProducts(new RequestAllProductsEvent()));
        model.addAttribute("products", proucts);
        return "/shop";
    }

    private List<Product> getProducts(AllProductsEvent allProductsEvent) {
        List<Product> products = new ArrayList<>();

      for(ProductDetails productDetails:  allProductsEvent.getProductDetails()){
          products.add(Product.fromProductDetails(productDetails));
      }
        return products;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/showProduct/{id}")
    public String getProduct(@PathVariable String id, Model model) {
        ProductDetailsEvent productDetailsEvent = productService.requestProductDetails(new RequestProductDetailsEvent(id));
        model.addAttribute("product", Product.fromProductDetails(productDetailsEvent.getProductDetails()));
        return "/showProduct";
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
//    public ResponseEntity<Product> getProduct(@PathVariable String id) {
//        ProductDetailsEvent details = productService.requestProductDetails(new RequestProductDetailsEvent(id)));
//        if (!details.isEntityFound()) {
//            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
//        }
//
//        Product order = Product.fromProductDetails(details.getProductDetails());
//
//        return new ResponseEntity<Product>(order, HttpStatus.OK);
//    }

    @ModelAttribute("basket")
    private Basket getBasket() {
        return basket;
    }
}
