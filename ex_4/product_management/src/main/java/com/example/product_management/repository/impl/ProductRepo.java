package com.example.product_management.repository.impl;

import com.example.product_management.model.Product;
import com.example.product_management.repository.IProductRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepo implements IProductRepo {
    private static final String SELECT_ALL="from Product";

    private static List<Product> products=new ArrayList<>();
    static {
        products.add(new Product(1,"SamSung Note 9",12000,"Super AMOLED 6.4 Quad HD+ (2K+)","Sam Sung"));
        products.add(new Product(2,"SamSung Note 10",13000," Dynamic AMOLED, HDR10+ ; Size, 6.3 inches,","Sam Sung"));
        products.add(new Product(3,"Iphone 13 ",14000,"Super Retina XDR OLED, HDR10, Dolby Vision","Apple"));
        products.add(new Product(4,"Iphone 14",15000," Super Retina XDR OLED, HDR10, Dolby Vision, 800 nits (HBM), 1200 nits (peak) ; Size, 6.1 inches, 90.2 cm2)","Apple"));
        products.add(new Product(5,"Oppo F11",16000,"Dimensions: 76.1 x 162 x 8.3 mm ; Weight: 188 g ; SoC: MediaTek Helio P70","OPPO"));
        products.add(new Product(6,"Oppo Reno 11",17000,"DISPLAY: 6.77 inches · Camera: 5+16+108 MP · RAM: 12/14 GB ","OPPO"));
    }


    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void create(Product product) {
        products.add(product);
    }

    @Override
    public void update(Product product) {
        for (Product p: products) {
            if(p.getId()== product.getId()){
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setDescription(product.getDescription());
                p.setManufacture(product.getManufacture());
            }
        }
    }

    @Override
    public void delete(int id) {
        products.remove(findByID(id));
    }

    @Override
    public Product detail(int id) {
        return findByID(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList=new ArrayList<>();
        for (Product p: products) {
            if(p.getName().contains(name)){
                productList.add(p);
            }
        }
        return productList;
    }

    @Override
    public Product findByID(int id) {
        for (Product p: products) {
            if(p.getId()==id){
                return p;
            }
        }
        return null;
    }
}
