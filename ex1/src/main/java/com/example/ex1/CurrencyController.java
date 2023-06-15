package com.example.ex1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @GetMapping("")
    public String redirect() {
        return "currency";
    }

    @GetMapping("/currency")
    public String changedMoney(@RequestParam Float money, @RequestParam Float rate, Model model) {
        model.addAttribute("money", money * rate);
        return "currency";
    }
}
