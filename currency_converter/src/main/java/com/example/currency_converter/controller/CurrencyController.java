package com.example.currency_converter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
//    @GetMapping("")
//    public String redirect() {
//        return "index";
//    }

    @GetMapping("/currency")
    public String changedMoney(@RequestParam Double money, Model model) {
        model.addAttribute("money", money);
        return "currency";
    }


}
