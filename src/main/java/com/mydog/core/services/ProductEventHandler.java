package com.mydog.core.services;

import com.mydog.core.domain.Product;
import com.mydog.core.events.product.*;
import com.mydog.core.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lin on 21.04.14.
 */
public class ProductEventHandler implements ProductService {

    private ProductRepository productRepository;


    public ProductEventHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public AllProductsEvent requestAllProducts(RequestAllProductsEvent requestAllProductsEvent) {
        List<ProductDetails> generatedDetails = new ArrayList<ProductDetails>();
        for (Product product : productRepository.findAll()) {
            generatedDetails.add(product.toProductDetails());
        }
        return new AllProductsEvent(generatedDetails);
    }

    @Override
    public ProductDetailsEvent requestProductDetails(RequestProductDetailsEvent requestProductDetailsEvent) {
        Product product = productRepository.findById(requestProductDetailsEvent.getId());

        if (product == null) {
            return ProductDetailsEvent.notFound(requestProductDetailsEvent.getId());
        }

        return new ProductDetailsEvent(
                requestProductDetailsEvent.getId(),
                product.toProductDetails());
    }

    @Override
    public ProductDetailsEvent createProduct(CreateProductEvent createProductEvent) {
        ProductDetails details = createProductEvent.getDetails();
        Product product = Product.fromProductDetails(details);
         productRepository.save(product);
        return new ProductDetailsEvent(product.getId(), product.toProductDetails());


    }
}
