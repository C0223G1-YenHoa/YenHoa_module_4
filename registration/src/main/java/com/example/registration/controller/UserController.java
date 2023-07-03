package com.example.registration.controller;


import com.example.registration.service.IUserService;
import com.example.registration.user.Account;
import com.example.registration.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService service;


    @GetMapping("")
    public String success(){
        return "/success";
    }

    @GetMapping("/sign_in")
    public String sign_in(Model model){
        model.addAttribute("account",new Account());
        return "sign_in";
    }

    @PostMapping("/sign_in")
    public String sign_in(@ModelAttribute Account account, RedirectAttributes redirectAttributes){
//        User users=service.login(user.getEmail(),user.getPassword());
        if(service.login(account.getEmail(),account.getPassword())!=null){
            redirectAttributes.addFlashAttribute("msg","Congratulations, sign in successful.") ;
        }else {
            redirectAttributes.addFlashAttribute("msg", "failed");
        }
        return "redirect:/user";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("user",new User());
        return "register_form";
    }


    @PostMapping("/process_register")
    public String processRegister(User user, HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
        service.create(new Account(user.getEmail(),user.getPassword()));
        service.register(user);
        String siteURL= getSiteURL(request);
        service.sendVerificationEmail(user,siteURL);
        return "/register_success";
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    @GetMapping("/verify")
    public String verifyUser(@RequestParam("code") String code) {
        if (service.verify(code)) {
            return "verify_success";
        } else {
            return "verify_fail";
        }
    }

}
