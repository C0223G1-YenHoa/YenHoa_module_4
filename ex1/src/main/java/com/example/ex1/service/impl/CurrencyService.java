package com.example.ex1.service.impl;

import com.example.ex1.service.ICurrencyService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService implements ICurrencyService {
    @Override
    public float convert(float money,float rate) {
        return money * rate;
    }
}
