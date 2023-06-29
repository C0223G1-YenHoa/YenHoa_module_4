package com.example.shopping_cart.controller;

import com.example.shopping_cart.model.Cart;
import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    IProductService productService;
    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }
    @GetMapping("/decrease/{id}")
    public String decrease(@SessionAttribute("cart") Cart cart,@PathVariable int id){
        Product product=productService.findById(id);
        cart.decreaseProduct(product);
        return "redirect:/cart/shopping-cart";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@SessionAttribute("cart") Cart cart,@PathVariable int id){
        Product product=productService.findById(id);
        cart.addProduct(product);
        return "redirect:/cart/shopping-cart";
    }
}
