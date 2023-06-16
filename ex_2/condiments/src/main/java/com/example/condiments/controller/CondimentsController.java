package com.example.condiments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class CondimentsController {
    @GetMapping("")
    public String condiments(){
        return "condiments";
    }

    @PostMapping("/condiments")
    public String chooseCondiments(@RequestParam(value = "condiment",required = false) String[] condiments, Model model){
        if(condiments == null){
            model.addAttribute("msg","you haven't chosen anything yet");
        }else
        model.addAttribute("listCondiments", Arrays.toString(condiments));
        return "condiments";
    }
}
