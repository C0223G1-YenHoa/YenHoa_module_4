package com.example.borrow_books.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    private String bookName;
    private int amount;
    private boolean isFlag;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<BorrowBooks> borrowBooks;

    public Book() {
    }

    public Book(int bookId, String bookName, int amount, boolean isFlag, List<BorrowBooks> borrowBooks) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.amount = amount;
        this.isFlag = isFlag;
        this.borrowBooks = borrowBooks;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isFlag() {
        return isFlag;
    }

    public void setFlag(boolean flag) {
        isFlag = flag;
    }

    public List<BorrowBooks> getBorrowBooks() {
        return borrowBooks;
    }

    public void setBorrowBooks(List<BorrowBooks> borrowBooks) {
        this.borrowBooks = borrowBooks;
    }
}
