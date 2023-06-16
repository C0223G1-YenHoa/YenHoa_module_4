package com.example.calculator.service;


import org.springframework.stereotype.Service;

@Service
public interface ICalculatorService {
    double calculator(Double first, Double second, String operation);
}
