package com.urkejov.shopingcart.service.category;

import com.urkejov.shopingcart.model.Category;
import com.urkejov.shopingcart.request.AddCategoryRequest;

import java.util.List;

public interface CategoryService {

    Category getCategoryById(String categoryId);
    Category getCategoryByName(String name);
    List<Category> getAllCategories();
    Category addCategory(AddCategoryRequest addCategoryRequest);
    Category updateCategory(Category category);
    void deleteCategoryById(String categoryId);
}
