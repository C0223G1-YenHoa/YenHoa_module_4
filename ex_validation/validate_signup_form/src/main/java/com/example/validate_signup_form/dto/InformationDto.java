package com.example.validate_signup_form.dto;

import javax.validation.constraints.*;

public class InformationDto {

    @NotBlank(message = "Please enter your last name")
    @Size(min = 5,max = 45)
    private String firstName;


    @NotBlank(message = "Please enter your last name")
    @Size(min = 5,max = 45)
    private String lastName;

    @Min(value = 18,message = "You must be over 18 years old")
    private int age;

    @Email(message = "email invalidate")
    private String email;

    @Pattern(regexp = "^(84|0[3|5|7|8|9])+([0-9]{8})$",message = "phone number error")
    private String phone;

    public InformationDto() {
    }

    public InformationDto(String firstName, String lastName, int age, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phone = phone;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
