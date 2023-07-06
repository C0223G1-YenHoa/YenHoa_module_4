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
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService service;


    @GetMapping("")
    public String success() {
        return "/success";
    }

    @GetMapping("/sign_in")
    public String sign_in(Model model) {
        model.addAttribute("account", new Account());
        return "sign_in";
    }

    @PostMapping("/sign_in")
    public String sign_in(@ModelAttribute Account account, RedirectAttributes redirectAttributes) {
        if (service.login(account.getEmail(), account.getPassword()) != null && service.find(account.getEmail()).isEnabled()) {
            redirectAttributes.addFlashAttribute("msg", "Congratulations, sign in successful.");
        } else {
            redirectAttributes.addFlashAttribute("msg", "failed");
        }
        return "redirect:/user";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "register_form";
    }


    @PostMapping("/process_register")
    public String processRegister(User user, HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
        if (service.find(user.getEmail()) != null) {
            return "verify_fail";
        } else {
            service.create(new Account(user.getEmail(), user.getPassword()));
            user.setExpiryDate(calculateExpiryDate());
            service.register(user);
            String siteURL = getSiteURL(request);
            service.sendVerificationEmail(user, siteURL);
            return "/register_success";
        }
    }

    private Date calculateExpiryDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, 1);
        return new Date(cal.getTime().getTime());
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

    @GetMapping("/verifyReset")
    public String verifyReset(@RequestParam("code") String code,Model model) {
        String email=null;
        if(service.findByVerificationCode(code)!=null) {
            User user = service.findByVerificationCode(code);
            email = user.getEmail();
        }
        if (service.verifyReset(code)) {
            User user1=service.find(email);
            model.addAttribute("user",user1);
            return "reset_pw";
        } else {
            return "verify_fail";
        }
    }

    @GetMapping("/email")
    public String email() {
        return "email_reset_pw";
    }

    @PostMapping("/reset_pw")
    public String reset_pw(@RequestParam("email") String email, HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        User user = service.find(email);
        user.setExpiryDate(calculateExpiryDate());
        service.reset(user);
        String siteURL = getSiteURL(request);
        service.sendVerificationReset(user, siteURL);
        return "success";
    }
    @PostMapping("/new_pw")
    public String new_pw(@RequestParam("new_pw")String new_pw,@ModelAttribute User user){
        service.reset_pw(user, new_pw);
        return "verify_success";
    }
}
