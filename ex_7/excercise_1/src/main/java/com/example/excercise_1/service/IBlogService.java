package com.example.excercise_1.service;

import com.example.excercise_1.model.Blog;

import java.time.LocalDate;
import java.util.List;

public interface IBlogService {
    List<Blog> getBlogs();
    void create(Blog blog);
    void update(Blog blog);
    void delete(int id);
    List<Blog> search(String name,LocalDate date);
    Blog findById(int id);
}
