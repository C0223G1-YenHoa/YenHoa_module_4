package com.example.excercise_1.controller;

import com.example.excercise_1.model.Blog;
import com.example.excercise_1.model.Category;
import com.example.excercise_1.service.IBlogService;
import com.example.excercise_1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping()
    public ResponseEntity<List<Blog>> blog() {
        return new ResponseEntity<>(this.blogService.getBlogs(), HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<Blog> create(@RequestBody Blog blog) {
        LocalDate localDate = LocalDate.now();
        blog.setDate(localDate);
        this.blogService.create(blog);
        return new ResponseEntity<>(blog, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> detail(@PathVariable int id) {
        return new ResponseEntity<>(this.blogService.findById(id), HttpStatus.OK);
    }


    @PutMapping("{id}")
    public ResponseEntity<Blog> update(@RequestBody Blog blog, @PathVariable int id) {
        if (blogService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            blog.setId(id);
            this.blogService.update(blog);
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (blogService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            blogService.findById(id).setFlag(true);
            this.blogService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Blog>> search(@PathVariable String name) {
        return new ResponseEntity<>(this.blogService.search(name), HttpStatus.OK);
    }
}
