package com.example.borrow_books.controller;

import com.example.borrow_books.model.Book;
import com.example.borrow_books.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String book(Model model){
        model.addAttribute("books", bookService.getBooks());
        return "display_books";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("book",new Book());
        return "/create_book";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Book book, RedirectAttributes redirectAttributes){
        bookService.create(book);
        redirectAttributes.addFlashAttribute("msg","Create new book successfully");
        return "redirect:/book";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,RedirectAttributes redirectAttributes){
        if(bookService.findById(id)==null){
            redirectAttributes.addFlashAttribute("msg","Not found");
        }else{
            bookService.findById(id).setFlag(true);
            bookService.delete(id);
            redirectAttributes.addFlashAttribute("msg","Delete successfully");
        }
        return "redirect:/book";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id,Model model){
        model.addAttribute("book",bookService.findById(id));
        return "/update_book";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Book book,RedirectAttributes redirectAttributes){
        bookService.update(book);
        redirectAttributes.addFlashAttribute("msg","Update Successfully");
        return "redirect:/book";
    }
}
