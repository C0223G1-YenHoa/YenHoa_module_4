package com.example.product_management.service.impl;

import com.example.product_management.model.Product;
import com.example.product_management.repository.IProductRepo;
import com.example.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepo productRepo;

    @Override
    public List<Product> getProducts() {
        return productRepo.getProducts();
    }

    @Override
    public void create(Product product) {
        productRepo.create(product);
    }

    @Override
    public void update(Product product) {
        productRepo.update(product);
    }

    @Override
    public void delete(int id) {
    productRepo.delete(id);
    }

    @Override
    public Product detail(int id) {
        return productRepo.detail(id);
    }

    @Override
    public List<Product> search(String name) {
        return productRepo.search(name);
    }

    @Override
    public Product findByID(int id) {
        return productRepo.findByID(id);
    }
}
