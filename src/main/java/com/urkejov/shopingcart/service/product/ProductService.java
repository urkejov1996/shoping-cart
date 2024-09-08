package com.urkejov.shopingcart.service.product;

import com.urkejov.shopingcart.model.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(String productId);

    void deleteProductById(String productId);

    void updateProduct(Product product, String productId);

}
