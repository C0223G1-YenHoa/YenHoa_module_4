package com.example.excercise_1.service;

import com.example.excercise_1.model.Blog;
import com.example.excercise_1.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> getBlogs(Pageable pageable);
    void create(Blog blog);
    void update(Blog blog);
    void delete(int id);
    Page<Blog> search(Category category, String name, Pageable pageable);
    Blog findById(int id);
}
