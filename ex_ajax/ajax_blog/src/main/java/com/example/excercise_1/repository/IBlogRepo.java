package com.example.excercise_1.repository;

import com.example.excercise_1.model.Blog;
import com.example.excercise_1.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IBlogRepo extends JpaRepository<Blog,Integer> {

//    @Query(value="UPDATE blog as b set b.date = :date,b.title = :title,b.content= :content where b.id = :#{#blog.id}",nativeQuery = true)
//    void update(@Param(value="blog")Blog blog);

    List<Blog> findBlogByCategoryNameContainsIgnoreCaseAndTitleContainsIgnoreCase(String name,String title);

    @Query(value = "select * from blog where is_flag=false limit :limited",nativeQuery = true)
    List<Blog> page(@Param("limited") int limited);
}
