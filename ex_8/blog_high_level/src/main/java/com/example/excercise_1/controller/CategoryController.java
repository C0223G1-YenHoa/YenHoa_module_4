package com.example.excercise_1.controller;


import com.example.excercise_1.model.Category;
import com.example.excercise_1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String category(@PageableDefault(size = 2) Pageable pageable, Model model) {
        model.addAttribute("categories", categoryService.getCategories(pageable));
        return "display_category";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("category",new Category());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.create(category);
        redirectAttributes.addFlashAttribute("msg", "create successfully");
        return "redirect:/category";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (categoryService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "This category not found!");
            return "redirect:/category";
        } else
            model.addAttribute("category", categoryService.findById(id));
        return "/detail";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (categoryService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "This category not found!");
            return "redirect:/category";
        } else {
            model.addAttribute("category", categoryService.findById(id));
            return "/update";
        }
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        if (categoryService.findById(category.getId()) == null) {
            redirectAttributes.addFlashAttribute("msg", "This category not found!");
        } else {
            categoryService.update(category);
            redirectAttributes.addFlashAttribute("msg", "Update Successful!");
        }
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (categoryService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "This category not found!");
        } else {
            categoryService.findById(id).setFlag(true);
            categoryService.delete(id);
        }
        return "redirect:/category";
    }

    @GetMapping("/search")
    public String search(@RequestParam String name,@PageableDefault(size = 2) Pageable pageable, Model model) {
        model.addAttribute("categories", categoryService.search(name,pageable));
        return "display_category";
    }
}
