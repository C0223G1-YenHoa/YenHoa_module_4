package com.example.excercise_1.service;

import com.example.excercise_1.model.Blog;
import com.example.excercise_1.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findAllCategory();
    List<Category> getCategories();
    void create(Category category);
    void update(Category category);
    void delete(int id);
    List<Category> search(String name);
    Category findById(int id);
}
