package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/products")
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
    public String create(@ModelAttribute Product product,RedirectAttributes redirectAttributes) {
        productService.create(product);
        redirectAttributes.addFlashAttribute("msg", "Create Successful!");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if(productService.findByID(id)==null){
            redirectAttributes.addFlashAttribute("msg","Delete Failed!");
        }else {
            productService.delete(id);
            redirectAttributes.addFlashAttribute("msg", "Delete Successful!");
        }
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id,Model model,RedirectAttributes redirectAttributes){
        if(productService.findByID(id)==null){
            redirectAttributes.addFlashAttribute("msg","This product not found!");
            return "redirect:/";
        }else {
            model.addAttribute("product_detail", productService.findByID(id));
            return "/detail";
        }
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findByID(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product,RedirectAttributes redirectAttributes){
        if(productService.findByID(product.getId())==null){
            redirectAttributes.addFlashAttribute("msg","This product not found!");
        }else {
            productService.update(product);
            redirectAttributes.addFlashAttribute("msg","Update Successful!");
        }
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam String search_name, Model model,RedirectAttributes redirectAttributes){
        if(productService.search(search_name).size()==0){
            redirectAttributes.addFlashAttribute("msg","This product not found!");
        }else {
            model.addAttribute("products", productService.search(search_name));
        }
        return "/display";
    }

}
