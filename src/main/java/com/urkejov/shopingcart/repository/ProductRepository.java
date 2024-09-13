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

    @Query("select p from Product p where p.category.name = ?1 and p.brand = ?2")
    List<Product> findByCategoryNameAndBrand(String category, String brand);

    @Query("select p from Product p where p.name = ?1")
    List<Product> findByName(String name);

    @Query("select p from Product p where p.brand = ?1 and p.name = ?2")
    List<Product> findByBrandAndName(String brand, String name);

    @Query("select count(p) from Product p where p.brand = ?1 and p.name = ?2")
    Long countByBrandAndName(String brand, String name);
}
