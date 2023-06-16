package com.example.calculator.service.impl;


import com.example.calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public double calculator(Double first, Double second, String operation) {
        double result = 0;
        switch (operation) {
            case "Addition":
                result = first + second;
                break;
            case "Subtraction":
                result = first - second;
                break;
            case "Multiplication":
                result = first * second;
                break;
            case "Division":
                result = first / second;
                break;
        }
        return result;
    }
}
