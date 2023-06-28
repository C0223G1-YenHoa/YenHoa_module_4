package com.example.borrow_books.service.impl;

import com.example.borrow_books.model.BorrowBooks;
import com.example.borrow_books.repository.IBorrowBooksRepo;
import com.example.borrow_books.service.IBorrowBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowBooksService implements IBorrowBooksService {
    @Autowired
    IBorrowBooksRepo borrowBooksRepo;

    @Override
    public List<BorrowBooks> getBorrowBooks() {
        return this.borrowBooksRepo.findAllByIsFlagFalse();
    }

    @Override
    public void create(BorrowBooks borrowBooks) {
    this.borrowBooksRepo.save(borrowBooks);
    }

    @Override
    public void update(BorrowBooks borrowBooks) {
    this.borrowBooksRepo.save(borrowBooks);
    }

    @Override
    public void delete(int code) {
        this.borrowBooksRepo.save(findByCode(code));
    }

    @Override
    public BorrowBooks findByCode(int code) {
        try{
            return this.borrowBooksRepo.findByBorrowCode(code);
        }catch (IllegalArgumentException e){
            return null;
        }
    }

}
