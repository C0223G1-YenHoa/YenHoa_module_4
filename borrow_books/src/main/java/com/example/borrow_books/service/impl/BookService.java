package com.example.borrow_books.service.impl;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.repository.IBookRepo;
import com.example.borrow_books.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepo bookRepo;
    @Override
    public List<Book> getBooks() {
        return this.bookRepo.findAllByIsFlagFalse();
    }

    @Override
    public void create(Book book) {
    this.bookRepo.save(book);
    }

    @Override
    public void update(Book book) {
        this.bookRepo.save(book);
    }

    @Override
    public void delete(int id) {
        this.bookRepo.save(findById(id));
    }

    @Override
    public Book findById(int id) {
        try {
            return this.bookRepo.findById(id).get();
        }catch (IllegalArgumentException e){
            return null;
        }
    }
}
