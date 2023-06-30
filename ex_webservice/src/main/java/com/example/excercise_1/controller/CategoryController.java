package com.example.excercise_1.controller;


import com.example.excercise_1.model.Category;
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

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<Category>>  category() {
        return new ResponseEntity<>(this.categoryService.getCategories(),HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody Category category) {
        this.categoryService.create(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> detail(@PathVariable int id) {
        if (categoryService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.categoryService.findById(id);
            return new ResponseEntity<>(categoryService.findById(id),HttpStatus.OK);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable int id,@RequestBody Category category) {
        if (categoryService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            categoryService.update(category);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (categoryService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            categoryService.findById(id).setFlag(true);
            categoryService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
