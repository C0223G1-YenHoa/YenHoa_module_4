package com.example.ex1.controller;

import com.example.ex1.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @Autowired
    private ICurrencyService currencyService;

    @GetMapping("")
    public String redirect() {
        return "currency";
    }

    @PostMapping("/currency")
    public String changedMoney(@RequestParam Float money, @RequestParam Float rate, Model model) {
        model.addAttribute("money",currencyService.convert(money,rate));
        return "currency";
    }
}
