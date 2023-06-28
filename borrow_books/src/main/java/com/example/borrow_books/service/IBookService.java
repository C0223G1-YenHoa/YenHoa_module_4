package com.example.borrow_books.service;

import com.example.borrow_books.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getBooks();
    void create(Book book);
    void update(Book book);
    void delete(int id);
    Book findById(int id);
}
