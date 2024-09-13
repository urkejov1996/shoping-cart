package com.urkejov.shopingcart.service.product;

import com.urkejov.shopingcart.model.Product;
import com.urkejov.shopingcart.request.ProductRequest;

import java.util.List;

public interface ProductService {

    Product addProduct(ProductRequest productRequest);

    Product getProductById(String productId);

    void deleteProductById(String productId);

    void updateProduct(Product product, String productId);

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByBrand(String brand);

    List<Product> getProductsByCategoryAndBrand(String category, String brand);

    List<Product> getProductsByName(String name);

    List<Product> getProductsByBrandAndName(String brand, String name);

    Long countProductsByBrandAndName(String brand, String Name);
}
