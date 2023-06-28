package com.example.borrow_books.repository;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.model.BorrowBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBorrowBooksRepo extends JpaRepository<BorrowBooks,Integer> {
    @Query(value = "select * from borrow_books where is_flag=false",nativeQuery = true)
    List<BorrowBooks> findAllByIsFlagFalse();
    BorrowBooks findByBorrowCode(int code);
}
