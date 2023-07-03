package com.example.registration.service;

import com.example.registration.user.Account;
import com.example.registration.user.User;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface IUserService {

     void create(Account account);
     void register(User user) throws UnsupportedEncodingException, MessagingException;

     void sendVerificationEmail(User user, String siteURL) throws MessagingException, UnsupportedEncodingException;

     boolean verify(String verificationCode);

     Account login(String email,String password);
}
