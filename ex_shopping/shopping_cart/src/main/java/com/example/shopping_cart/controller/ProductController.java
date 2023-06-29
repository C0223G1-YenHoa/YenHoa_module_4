package com.example.shopping_cart.controller;

import com.example.shopping_cart.model.Cart;
import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.service.IProductService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/shopping")
public class ProductController {
    @Autowired
    HttpSession session;
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
        if(productService.findById(id)==null){
            redirectAttributes.addAttribute("msg","Not found");
        }else{
            productService.findById(id).setFlag(true);
            productService.delete(id);
            redirectAttributes.addAttribute("msg","Delete successfully");
        }
        return "redirect:/shopping";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@SessionAttribute("cart") Cart cart,@PathVariable int id){
        Product product=productService.findById(id);
            cart.addProduct(product);
        return "redirect:/shopping";
    }


    @GetMapping("/pay")
    public String pay(Model model){
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        session= request.getSession();
//        session.removeAttribute("cart");
        model.addAttribute("msg","Payment success");
        return "redirect:/shopping";
    }
}
