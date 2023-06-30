package com.example.excercise_1.service;

import com.example.excercise_1.model.Blog;
import com.example.excercise_1.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> getBlogs();
    void create(Blog blog);
    void update(Blog blog);
    void delete(int id);
    List<Blog> search(String name);
    Blog findById(int id);
}
