package com.example.excercise_1.repository;

import com.example.excercise_1.model.Blog;
import com.example.excercise_1.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category,Integer> {
    Page<Category> findCategoryByNameContains(String title, Pageable pageable);
}
