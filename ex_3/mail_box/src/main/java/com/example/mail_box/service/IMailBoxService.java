package com.example.mail_box.service;

import com.example.mail_box.model.MailBox;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IMailBoxService {
    List<MailBox> getMailBoxes();
    List<String> getLanguage();
    MailBox findById(Integer id);
    List<Integer> getPageSize();
    void update(MailBox mailBox);
}
