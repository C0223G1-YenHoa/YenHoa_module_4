package com.example.mail_box.Repository;

import com.example.mail_box.model.MailBox;


import java.util.List;
public interface IMailBoxRepo {
    List<MailBox> getMailBoxes();
    List<String> getLanguage();
    List<Integer> getPageSize();
    MailBox findById(Integer id);
    void update(MailBox mailBox);
}
