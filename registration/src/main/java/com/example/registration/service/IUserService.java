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
     boolean verifyReset(String verificationCode);

     Account login(String email,String password);

     User find(String email);

     User findByVerificationCode(String code);

     void reset(User user);

     void sendVerificationReset(User user,String siteURL) throws MessagingException, UnsupportedEncodingException;

     void reset_pw(User user,String new_pw);
}
