package com.urkejov.shopingcart.repository;

import com.urkejov.shopingcart.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    @Query("select c from Category c where c.name = ?1")
    Category findByName(String name);
}
