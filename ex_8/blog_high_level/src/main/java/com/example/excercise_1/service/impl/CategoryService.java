package com.example.excercise_1.service.impl;

import com.example.excercise_1.model.Blog;
import com.example.excercise_1.model.Category;
import com.example.excercise_1.repository.ICategoryRepo;
import com.example.excercise_1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepo categoryRepo;

    public List<Category> findAllCategory(){
       return this.categoryRepo.findAll();
    }


    @Override
    public Page<Category> getCategories(Pageable pageable) {
        return this.categoryRepo.findAll(pageable);
    }
    @Override
    public void create(Category category) {
        this.categoryRepo.save(category);
    }


    @Override
    public void update(Category category) {
        this.categoryRepo.save(category);
    }

    @Override
    public void delete(int id) {
        this.categoryRepo.save(findById(id));
    }

    @Override
    public  Page<Category> search(String name,Pageable pageable) {
        return this.categoryRepo.findCategoryByNameContains(name,pageable);
    }

    @Override
    public Category findById(int id) {
        try {
            return this.categoryRepo.findById(id).get();
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
