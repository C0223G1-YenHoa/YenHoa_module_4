package com.example.borrow_books.repository;

import com.example.borrow_books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBookRepo extends JpaRepository<Book,Integer> {
    @Query(value = "select * from book where is_flag=false",nativeQuery = true)
    List<Book> findAllByIsFlagFalse();
}
