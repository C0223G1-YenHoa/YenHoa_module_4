package com.example.excercise_1.repository;

import com.example.excercise_1.model.Blog;
import com.example.excercise_1.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IBlogRepo extends JpaRepository<Blog,Integer> {

//    @Query(value="UPDATE blog as b set b.date = :date,b.title = :title,b.content= :content where b.id = :#{#blog.id}",nativeQuery = true)
//    void update(@Param(value="blog")Blog blog);

    Page<Blog> findBlogByTitleContainsAndCategory_Name(Category category, String title, Pageable pageable);
}
