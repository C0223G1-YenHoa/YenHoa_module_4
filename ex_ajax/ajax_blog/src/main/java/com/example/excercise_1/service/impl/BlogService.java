package com.example.excercise_1.service.impl;

import com.example.excercise_1.model.Blog;
import com.example.excercise_1.model.Category;
import com.example.excercise_1.repository.IBlogRepo;
import com.example.excercise_1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepo blogRepo;

    @Override
    public List<Blog> getBlogs() {
        return this.blogRepo.findAll();
    }

    @Override
    public void create(Blog blog) {
        this.blogRepo.save(blog);
    }


    @Override
    public void update(Blog blog) {
        this.blogRepo.save(blog);
    }

    @Override
    public void delete(int id) {
        this.blogRepo.save(findById(id));
    }

    @Override
    public  List<Blog> search(String name,String title) {
        return this.blogRepo.findBlogByCategoryNameContainsIgnoreCaseAndTitleContainsIgnoreCase(name,title);
    }

    @Override
    public Blog findById(int id) {
        try {
            return this.blogRepo.findById(id).get();
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public List<Blog> page(int limited) {
        return this.blogRepo.page(limited);
    }
}
