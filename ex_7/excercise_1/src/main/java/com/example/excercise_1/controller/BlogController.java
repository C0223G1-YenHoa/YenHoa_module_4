package com.example.excercise_1.controller;

import com.example.excercise_1.model.Blog;
import com.example.excercise_1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String blog(Model model) {
        model.addAttribute("blogs", blogService.getBlogs());
        return "display";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        LocalDate localDate = LocalDate.now();
        blog.setDate(localDate);
        blogService.create(blog);
        redirectAttributes.addFlashAttribute("msg", "create successfully");
        return "redirect:/blog";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (blogService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "This blog not found!");
            return "redirect:/blog";
        } else
            model.addAttribute("blog", blogService.findById(id));
        return "/detail";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (blogService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "This blog not found!");
            return "redirect:/blog";
        } else {
            model.addAttribute("blog", blogService.findById(id));
            return "/update";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("msg", "Update Successful!");
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (blogService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "This blog not found!");
        } else {
            blogService.delete(id);
        }
        return "redirect:/blog";
    }
}
