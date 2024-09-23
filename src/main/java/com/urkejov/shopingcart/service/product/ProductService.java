package com.urkejov.shopingcart.service.product;

import com.urkejov.shopingcart.dto.ProductDto;
import com.urkejov.shopingcart.model.Product;
import com.urkejov.shopingcart.request.AddProductRequest;
import com.urkejov.shopingcart.request.UpdateProductRequest;

import java.util.List;

public interface ProductService {

    Product addProduct(AddProductRequest addProductRequest);

    Product getProductById(String productId);

    void deleteProductById(String productId);

    Product updateProduct(UpdateProductRequest updateProductRequest, String productId);

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByBrand(String brand);

    List<Product> getProductsByCategoryAndBrand(String category, String brand);

    List<Product> getProductsByName(String name);

    List<Product> getProductsByBrandAndName(String brand, String name);

    Long countProductsByBrandAndName(String brand, String Name);

    ProductDto convertToDto(Product product);
}
