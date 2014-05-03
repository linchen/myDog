package com.mydog.content;

import com.mydog.core.domain.Product;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = ElasticsearchDocument.INDEX, type = ElasticsearchDocument.TYPE)
public class ElasticsearchDocument  implements Serializable{
    public static final String INDEX = "mydog_content_index";

    public static final String TYPE = "mydogContentDocument";

    private String productId;
    private Product product;

    public ElasticsearchDocument() {
    }

    public ElasticsearchDocument(Product product) {
        this.productId = product.getId();
        this.product = product;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        if(productId == null){
            productId = product.getId();
        }
    }

    @Override
    public String toString() {
        return "ElasticsearchDocument [id=" + productId + ", content=" + product + "]";
    }
}
