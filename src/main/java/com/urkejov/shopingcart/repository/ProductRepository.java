package com.urkejov.shopingcart.repository;

import com.urkejov.shopingcart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("select p from Product p where p.category.name = ?1")
    List<Product> findByCategoryName(String category);

    @Query("select p from Product p where p.brand = ?1")
    List<Product> findByBrand(String brand);
}
