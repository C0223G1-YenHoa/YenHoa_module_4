package com.example.shopping_cart.controller;

import com.example.shopping_cart.model.Cart;
import com.example.shopping_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart) {
        return new ModelAndView("/cart","cart", cart);
    }

    @GetMapping("/decrease/{id}")
    public String decrease(@SessionAttribute("cart") Cart cart, @PathVariable int id, RedirectAttributes redirectAttributes) {
        if(productService.findById(id)==null){
            redirectAttributes.addFlashAttribute("msg","Not found");
        }else {
            cart.decreaseProduct( productService.findById(id));
        }
        return "redirect:/cart/shopping-cart";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@SessionAttribute("cart") Cart cart, @PathVariable int id, RedirectAttributes redirectAttributes) {
        if(productService.findById(id)==null){
            redirectAttributes.addFlashAttribute("msg","Not found");
        }else {
            cart.addProduct(productService.findById(id));
        }
        return "redirect:/cart/shopping-cart";
    }
}
