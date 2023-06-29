package com.example.shopping_cart.service.impl;

import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.repository.IProductRepo;
import com.example.shopping_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepo productRepo;

    @Override
    public List<Product> getProducts() {
        return this.productRepo.findAllByIsFlagFalse();
    }

    @Override
    public void add(Product product) {
        this.productRepo.save(product);
    }

    @Override
    public void delete(int id) {
        this.productRepo.save(find(id));
    }

    @Override
    public Optional<Product> findById(int id) {
            return this.productRepo.findById(id);
    }

    @Override
    public Product find(int id) {
        try {
            return this.productRepo.findById(id).get();
        }catch (IllegalArgumentException e){
            return null;
        }
    }
}
