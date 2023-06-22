package com.example.excercise_1.repository;

import com.example.excercise_1.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface IBlogRepo extends JpaRepository<Blog,Integer> {

    @Query(value="UPDATE blog as b set b.date = :date,b.title = :title,b.content= :content where b.id = :#{#blog.id}",nativeQuery = true)
    void update(@Param(value="blog")Blog blog);

    List<Blog> findByTitleContainingAndDateContains(String title, LocalDate date);
}
