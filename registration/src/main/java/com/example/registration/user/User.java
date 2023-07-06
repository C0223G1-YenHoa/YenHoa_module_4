package com.example.registration.user;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    @Column(name = "verification_code", length = 64)
    private String verificationCode;

    private boolean enabled;

    private Date expiryDate;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

//    public User(int id, String email, String firstName, String lastName, String password, String verificationCode, boolean enabled) {
//        this.id = id;
//        this.email = email;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.password = password;
//        this.verificationCode = verificationCode;
//        this.enabled = enabled;
//    }

    public User(int id, String email, String firstName, String lastName, String password, String verificationCode, boolean enabled, Date expiryDate) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.verificationCode = verificationCode;
        this.enabled = enabled;
        this.expiryDate = expiryDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
