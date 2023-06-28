package com.example.borrow_books.service;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.model.BorrowBooks;

import java.util.List;

public interface IBorrowBooksService {
    List<BorrowBooks> getBorrowBooks();
    void create(BorrowBooks borrowBooks);
    void update(BorrowBooks borrowBooks);

    void delete(int code);
    BorrowBooks findByCode(int code);
}
