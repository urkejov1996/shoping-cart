package com.urkejov.shopingcart.service.product;

import com.urkejov.shopingcart.exceptions.ProductNotFoundException;
import com.urkejov.shopingcart.model.Category;
import com.urkejov.shopingcart.model.Product;
import com.urkejov.shopingcart.repository.ProductRepository;
import com.urkejov.shopingcart.request.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product addProduct(ProductRequest productRequest) {


        return null;

    }

    private Product createProduct(ProductRequest productRequest, Category category){
        return new Product(
                productRequest.getName(),
                productRequest.getBrand(),
                productRequest.getPrice(),
                productRequest.getInventory(),
                productRequest.getDescription(),
                category
        );
    }

    @Override
    public Product getProductById(String productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    @Override
    public void deleteProductById(String productId) {
        productRepository.findById(productId)
                .ifPresentOrElse(productRepository::delete, () -> {
                    throw new ProductNotFoundException("Product not found");
                });
    }

    @Override
    public void updateProduct(Product product, String productId) {

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategoryName(category);
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> getProductsByCategoryAndBrand(String category, String brand) {
        return productRepository.findByCategoryNameAndBrand(category, brand);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductsByBrandAndName(String brand, String name) {
        return productRepository.findByBrandAndName(brand, name);
    }

    @Override
    public Long countProductsByBrandAndName(String brand, String name) {
        return productRepository.countByBrandAndName(brand, name);
    }
}
