package com.example.mail_box.model;

public class MailBox {
    private Integer id;
    private String language;
    private Integer pageSize;
    private boolean spams;
    private String signature;

    public MailBox() {
    }

    public MailBox(Integer id, String language, Integer pageSize, boolean spams, String signature) {
        this.id = id;
        this.language = language;
        this.pageSize = pageSize;
        this.spams = spams;
        this.signature = signature;
    }

    public MailBox(String language, Integer pageSize, boolean spams, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spams = spams;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpams() {
        return spams;
    }

    public void setSpams(boolean spams) {
        this.spams = spams;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
