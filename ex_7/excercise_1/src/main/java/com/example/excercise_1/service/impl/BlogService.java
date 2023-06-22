package com.example.excercise_1.service.impl;

import com.example.excercise_1.model.Blog;
import com.example.excercise_1.repository.IBlogRepo;
import com.example.excercise_1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class BlogService implements IBlogService{
    @Autowired
    IBlogRepo blogRepo;

    @Override
    public List<Blog>  getBlogs(){
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
        this.blogRepo.deleteById(id);
    }

    @Override
    public List<Blog> search(String name,LocalDate date) {
        return this.blogRepo.findByTitleContainingAndDateContains(name,date);
    }

    @Override
    public Blog findById(int id) {
        try{
          return   this.blogRepo.findById(id).get();
        }catch (IllegalArgumentException e){
            return null;
        }
    }
}
