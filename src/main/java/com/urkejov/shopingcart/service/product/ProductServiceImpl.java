package com.urkejov.shopingcart.service.product;

import com.urkejov.shopingcart.dto.ImageDto;
import com.urkejov.shopingcart.dto.ProductDto;
import com.urkejov.shopingcart.exceptions.ResourceNotFoundException;
import com.urkejov.shopingcart.model.Category;
import com.urkejov.shopingcart.model.Image;
import com.urkejov.shopingcart.model.Product;
import com.urkejov.shopingcart.repository.CategoryRepository;
import com.urkejov.shopingcart.repository.ImageRepository;
import com.urkejov.shopingcart.repository.ProductRepository;
import com.urkejov.shopingcart.request.AddProductRequest;
import com.urkejov.shopingcart.request.UpdateProductRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ImageRepository imageRepository;

    @Override
    public Product addProduct(AddProductRequest addProductRequest) {

        Category category = Optional.ofNullable(categoryRepository.findByName(addProductRequest.getCategory().getName()))
                .orElseGet(() -> {
                    Category newCategory = new Category(addProductRequest.getCategory().getName());
                    return categoryRepository.save(newCategory);
                });
        addProductRequest.setCategory(category);
        return productRepository.save(createProduct(addProductRequest, category));

    }

    private Product createProduct(AddProductRequest addProductRequest, Category category) {
        return new Product(
                addProductRequest.getName(),
                addProductRequest.getBrand(),
                addProductRequest.getPrice(),
                addProductRequest.getInventory(),
                addProductRequest.getDescription(),
                category
        );
    }

    @Override
    public Product getProductById(String productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public void deleteProductById(String productId) {
        productRepository.findById(productId)
                .ifPresentOrElse(productRepository::delete, () -> {
                    throw new ResourceNotFoundException("Product not found");
                });
    }

    @Override
    public Product updateProduct(UpdateProductRequest updateProductRequest, String productId) {

        return productRepository.findById(productId)
                .map(existingProduct -> updateExistingProduct(existingProduct, updateProductRequest))
                .map(productRepository::save)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

    }

    private Product updateExistingProduct(Product existingProduct, UpdateProductRequest updateProductRequest) {
        existingProduct.setName(updateProductRequest.getName());
        existingProduct.setBrand(updateProductRequest.getBrand());
        existingProduct.setPrice(updateProductRequest.getPrice());
        existingProduct.setInventory(updateProductRequest.getInventory());
        existingProduct.setDescription(updateProductRequest.getDescription());

        Category category = categoryRepository.findByName(updateProductRequest.getCategory().getName());
        existingProduct.setCategory(category);
        return existingProduct;
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

    @Override
    public ProductDto convertToDto(Product product) {
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        List<Image> images = imageRepository.findByProductId(product.getId());
        List<ImageDto> imageDtos = images.stream()
                .map(image -> modelMapper.map(image, ImageDto.class)).toList();
        productDto.setImages(imageDtos);
        return productDto;
    }
}
