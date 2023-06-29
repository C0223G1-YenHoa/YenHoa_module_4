package com.example.shopping_cart.controller;

import com.example.shopping_cart.model.Cart;
import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/shopping")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("")
    public String getProducts(Model model){
        model.addAttribute("products",this.productService.getProducts());
        return "display_products";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "/create_product";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.add(product);
        redirectAttributes.addFlashAttribute("msg","Create successfully !");
        return "redirect:/shopping";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,RedirectAttributes redirectAttributes){
        if(productService.find(id)==null){
            redirectAttributes.addAttribute("msg","Not found");
        }else{
            productService.find(id).setFlag(true);
            productService.delete(id);
            redirectAttributes.addAttribute("msg","Delete successfully");
        }
        return "redirect:/shopping";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id,@ModelAttribute Cart cart,RedirectAttributes redirectAttributes,@RequestParam("action") String action){
        Optional<Product> product=productService.findById(id);
        if(!product.isPresent() ) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(product.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(product.get());
        return "redirect:/shopping";
    }

    @GetMapping("/decrease/{id}")
    public String decrease(@PathVariable int id,@ModelAttribute Cart cart,@RequestParam("action") String action){
        Optional<Product> product=productService.findById(id);
        if(!product.isPresent() ) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.decreaseProduct(product.get());
        }
        cart.decreaseProduct(product.get());
        return "redirect:/shopping-cart";
    }

    @GetMapping("/pay")
    public String pay(Model model){
        
        model.addAttribute("msg","Payment success");
        return "redirect:/shopping";
    }
}
