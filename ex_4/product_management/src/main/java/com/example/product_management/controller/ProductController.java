package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String product(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "/display";
    }

    @GetMapping("/showCreateForm")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String create(Product product) {
        productService.create(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        productService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id,Model model){
        model.addAttribute("product_detail",productService.findByID(id));
        return "/detail";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findByID(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(Product product){
        productService.update(product);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam String search_name, Model model){
        model.addAttribute("products",productService.search(search_name));
        return "/display";
    }

}
