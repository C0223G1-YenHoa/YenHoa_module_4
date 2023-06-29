package com.example.shopping_cart.model;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String productName;
    private float price;
    private String description;
    @Column(columnDefinition = "mediumtext")
    private String image;

    private boolean isFlag;

    public Product() {
    }

    public Product(int id, String productName, float price, String description, String image, boolean isFlag) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.image = image;
        this.isFlag = isFlag;
    }

    public Product(int id, String productName, float price, String description) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
    }


    public boolean isFlag() {
        return isFlag;
    }

    public void setFlag(boolean flag) {
        isFlag = flag;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
