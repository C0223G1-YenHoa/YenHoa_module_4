package com.example.borrow_books.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class BorrowBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int borrowCode;
    private LocalDate borrowDay;
    private LocalDate returnDate;
    private boolean isFlag;

    @ManyToOne
    @JoinColumn(name = "book_id",nullable = false)
    private Book book;

    public BorrowBooks() {
    }

    public BorrowBooks(int id, int borrowCode, LocalDate borrowDay, boolean isFlag, Book book) {
        this.id = id;
        this.borrowCode = borrowCode;
        this.borrowDay = borrowDay;
        this.isFlag = isFlag;
        this.book = book;
    }

    public BorrowBooks(int borrowCode, LocalDate borrowDay, Book book) {
        this.borrowCode = borrowCode;
        this.borrowDay = borrowDay;
        this.book = book;
    }

    public BorrowBooks(int id, int borrowCode, LocalDate borrowDay, LocalDate returnDate, boolean isFlag, Book book) {
        this.id = id;
        this.borrowCode = borrowCode;
        this.borrowDay = borrowDay;
        this.returnDate = returnDate;
        this.isFlag = isFlag;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(int borrowCode) {
        this.borrowCode = borrowCode;
    }

    public LocalDate getBorrowDay() {
        return borrowDay;
    }

    public void setBorrowDay(LocalDate borrowDay) {
        this.borrowDay = borrowDay;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isFlag() {
        return isFlag;
    }

    public void setFlag(boolean flag) {
        isFlag = flag;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
