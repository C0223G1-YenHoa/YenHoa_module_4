package com.example.borrow_books.controller;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.model.BorrowBooks;
import com.example.borrow_books.service.IBookService;
import com.example.borrow_books.service.IBorrowBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/borrow")
public class BorrowBooksController {
    @Autowired
    private IBorrowBooksService borrowBooksService;

    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String borrowing(Model model) {
        model.addAttribute("borrowingBooks", borrowBooksService.getBorrowBooks());
        return "display_borrowing_book";
    }

    @GetMapping("/create/{id}")
    public String create(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        long count = Math.round(((Math.random() + 1) * 99999));
        if (borrowBooksService.findByCode((int) count) != null) {
            count = Math.round(((Math.random() + 1) * 99999));
        }
        if(bookService.findById(id).getAmount()==0){
            redirectAttributes.addFlashAttribute("msg", "This book is temporarily out of stock");
        }else {
            LocalDate localDate = LocalDate.now();
            Book book = bookService.findById(id);
            book.setAmount(book.getAmount() - 1);
            borrowBooksService.create(new BorrowBooks((int) count, localDate, book));
            redirectAttributes.addFlashAttribute("msg", "Borrow successfully, your borrowing code is " + count);
        }
        return "redirect:/book";
    }

    @GetMapping("/return")
    public String returns(@RequestParam int code, RedirectAttributes redirectAttributes) {
        BorrowBooks borrowBooks = borrowBooksService.findByCode(code);
        if (borrowBooksService.findByCode(code) == null) {
            redirectAttributes.addFlashAttribute("msg", "Borrowing code wrong!");
        }else if(borrowBooks.getReturnDate()!=null){
            redirectAttributes.addFlashAttribute("msg", "Not found");
        }else {
            Book book = bookService.findById(borrowBooks.getBook().getBookId());
            book.setAmount(book.getAmount()+1);
            LocalDate localDate = LocalDate.now();
            borrowBooks.setReturnDate(localDate);
            borrowBooksService.update(borrowBooks);
            redirectAttributes.addFlashAttribute("msg", "Return successfully!");
        }
        return "redirect:/book";
    }
}
