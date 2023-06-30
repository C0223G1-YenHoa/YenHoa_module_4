package com.example.excercise_1.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private String title;
    private String content;
    private String image;
    private boolean isFlag;

    @ManyToOne
    @JoinColumn(name="category_id",nullable = false)
    private Category category;

    public Blog() {
    }

    public Blog(int id, LocalDate date, String title, String content, String image, Boolean isFlag, Category category) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.content = content;
        this.image = image;
        this.isFlag = isFlag;
        this.category = category;
    }

    public Blog(int id, LocalDate date, String title, String content, String image) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.content = content;
        this.image = image;
    }

    public Blog(int id, LocalDate date, String title, String content) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getFlag() {
        return isFlag;
    }

    public void setFlag(Boolean flag) {
        isFlag = flag;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
