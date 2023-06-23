package com.example.excercise_1.service;

import com.example.excercise_1.model.Blog;
import com.example.excercise_1.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findAllCategory();
    Page<Category> getCategories(Pageable pageable);
    void create(Category category);
    void update(Category category);
    void delete(int id);
    Page<Category> search(String name,Pageable pageable);
    Category findById(int id);
}
