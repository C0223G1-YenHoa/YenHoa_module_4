package com.example.registration.service.impl;

import com.example.registration.repository.IAccountRepo;
import com.example.registration.repository.IUserRepo;
import com.example.registration.service.IUserService;
import com.example.registration.user.Account;
import com.example.registration.user.User;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.persistence.PersistenceContext;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

@Service
@Component
public class UserService implements IUserService {
    @Autowired
    IUserRepo userRepo;

    @Autowired
    IAccountRepo accountRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void create(Account account) {
        accountRepo.save(account);
    }

    @Override
    public void register(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        String randomCode = RandomString.make(64);
        user.setVerificationCode(randomCode);
        user.setEnabled(false);
        userRepo.save(user);
    }

    @Override
    public void sendVerificationEmail(User user, String siteURL) throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = "lsyh31@gmail.com";
        String senderName = "Tian flight";
        String subject = "Confirm your email address";
        String content = "<p>Dear "+user.getLastName() + ",</p><br>"
                + "Thank you for creating an account with TianFlight. To complete the registration process, " +
                "we need you to confirm your email address by clicking on the link below:<br>";
        String verifyURL= siteURL+ "/user/verify?code="+user.getVerificationCode();
        content+= "<button style='background-color: #a0a7a0; \n" +
                "  border: none; \n" +
                "  color: black; \n" +
                "  padding: 12px 24px;\n" +
                "  text-align: center;\n" +
                "  text-decoration: none;\n" +
                "  display: inline-block;\n" +
                "  font-size: 16px; \n" +
                "  margin: 4px 2px; \n" +
                "  cursor: pointer; \n" +
                "  border-radius: 8px;'><a href=\"" + verifyURL + "\">Confirm Your Email Address</a></button>";
        content+= "<br><br>If you did not create an account with us, please ignore this email.\n" +
                "\n" +
                "Thank you for choosing TianFlight. We look forward to serving you! <br><br>\n" +
                "\n" +
                "Best regards!<br>";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
    }

    @Override
    public boolean verify(String verificationCode) {
        User user = userRepo.findByVerificationCode(verificationCode);
        Calendar cal = Calendar.getInstance();
        if (user == null || user.isEnabled()) {
            return false;
        }else if((user.getExpiryDate().getTime()- cal.getTime().getTime()) <= 0){
            userRepo.delete(user);
            return false;
        }else {
            user.setVerificationCode(null);
            user.setEnabled(true);
            userRepo.save(user);
            return true;
        }
    }

    @Override
    public boolean verifyReset(String verificationCodeReset) {
        User user = userRepo.findByVerificationCode(verificationCodeReset);
        Calendar cal = Calendar.getInstance();
        if(user==null||(user.getExpiryDate().getTime()- cal.getTime().getTime()) <= 0){
            return false;
        }else {
            user.setVerificationCode(null);
            userRepo.save(user);
            return true;
        }
    }

    @Override
    public Account login(String email, String password) {
        return accountRepo.findByEmailAndPassword(email,password);
    }

    @Override
    public User find(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public User findByVerificationCode(String code) {
        return userRepo.findByVerificationCode(code);
    }

    @Override
    public void reset(User user) {
        String randomCode = RandomString.make(64);
        user.setVerificationCode(randomCode);
        userRepo.save(user);
    }

    @Override
    public void sendVerificationReset(User user, String siteURL) throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = "lsyh31@gmail.com";
        String senderName = "Tian flight";
        String subject = "Confirm your email address";
        String content = "<p>Dear "+user.getLastName() + ",</p><br>"
                + "We have received a request to reset the password associated with your account. In order to proceed with " +
                "the password reset process, we need to confirm that the email address associated with your account is valid.<br>" +
                "Please click on the following link to confirm your email address:<br>";
        String verifyURL= siteURL+ "/user/verifyReset?code="+user.getVerificationCode();
        content+= "<button style='background-color: #a0a7a0; \n" +
                "  border: none; \n" +
                "  color: black; \n" +
                "  padding: 12px 24px;\n" +
                "  text-align: center;\n" +
                "  text-decoration: none;\n" +
                "  display: inline-block;\n" +
                "  font-size: 16px; \n" +
                "  margin: 4px 2px; \n" +
                "  cursor: pointer; \n" +
                "  border-radius: 8px;'><a href=\"" + verifyURL + "\">Confirm Your Email Address</a></button>";
        content+= "<br><br>If you did not request a password reset, please disregard this message. " +
                "If you believe that your account has been compromised, please contact our customer support team immediately.<br>" +
                "Thank you,<br>" +
                "TianFlight";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
    }

    @Override
    public void reset_pw(User user, String new_pw) {
        String encodedPassword = passwordEncoder.encode(new_pw);
        User user1=userRepo.findByEmail(user.getEmail());
        user1.setPassword(encodedPassword);
//        user.setPassword(encodedPassword);
        userRepo.save(user1);
    }


}
