package com.example.validate_signup_form.controller;

import com.example.validate_signup_form.model.Information;
import com.example.validate_signup_form.dto.InformationDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("signup")
public class InformationController {
    @GetMapping("")
    public String signup(Model model){
        model.addAttribute("informationDto",new InformationDto());
        return "signup_form";
    }

    @PostMapping ("/register")
    public String register(@Valid @ModelAttribute InformationDto informationDto,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes){
    if(bindingResult.hasErrors()){
//        model.addAttribute("informationDto",informationDto);
        return "signup_form";
    }
        Information information=new Information();
        BeanUtils.copyProperties(informationDto,information);
        redirectAttributes.addAttribute("msg","Signup successful");
        return "redirect:/signup_form";
    }
}
