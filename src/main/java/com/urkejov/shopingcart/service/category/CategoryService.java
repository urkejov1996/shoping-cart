package com.urkejov.shopingcart.service.category;

import com.urkejov.shopingcart.model.Category;
import com.urkejov.shopingcart.request.AddCategoryRequest;

import java.util.List;

public interface CategoryService {

    Category getCategoryById(String categoryId);
    Category getCategoryByName(String name);
    List<Category> getAllCategories();
    Category addCategory(Category category);
    Category updateCategory(Category category, String categoryId);
    void deleteCategoryById(String categoryId);
}
