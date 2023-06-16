package com.example.calculator.controller;

import com.example.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("")
    public String calculator(){
        return "calculator";
    }
    @PostMapping("/calculator")
    public String calculate(@RequestParam Double first, Double second,String operation, Model model){
        if(second ==0 & operation.equals("Division")){
            model.addAttribute("msg","Number must be greater than 0");
        }
        else if(operation == null){
            model.addAttribute("msg","You haven't chosen operation");
        }
        else
        model.addAttribute("result",calculatorService.calculator(first,second,operation));
        return "calculator";
    }
}
