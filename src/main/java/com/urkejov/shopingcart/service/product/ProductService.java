package com.urkejov.shopingcart.service.product;

import com.urkejov.shopingcart.model.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);
    Product getProductById(String productId);
    void deleteProductById(String productId);
    void updateProduct(Product product, String productId);
    List<Product> getAllProducts();
    List<Product> getProductsByCategoryId(String categoryId);

}
