package com.example.excercise_1.controller;

import com.example.excercise_1.model.Blog;
import com.example.excercise_1.model.Category;
import com.example.excercise_1.service.IBlogService;
import com.example.excercise_1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String blog(@PageableDefault(size = 2, sort = "date") Pageable pageable, Model model) {
        model.addAttribute("blogs", blogService.getBlogs(pageable));
        return "display";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("category", this.categoryService.findAllCategory());
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
            model.addAttribute("category", this.categoryService.findAllCategory());
            return "/update";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        if (blogService.findById(blog.getId()) == null) {
            redirectAttributes.addFlashAttribute("msg", "This blog not found!");
        } else {
            blogService.update(blog);
            redirectAttributes.addFlashAttribute("msg", "Update Successful!");
        }
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (blogService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "This blog not found!");
        } else {
            blogService.findById(id).setFlag(true);
            blogService.delete(id);
        }
        return "redirect:/blog";
    }

    @GetMapping("/search")
    public String search(@RequestParam String title, @RequestParam Category category, @PageableDefault(size = 2, sort = "date") Pageable pageable, Model model) {
        model.addAttribute("blogs", blogService.search(category,title,pageable));
        return "display";
    }
}
