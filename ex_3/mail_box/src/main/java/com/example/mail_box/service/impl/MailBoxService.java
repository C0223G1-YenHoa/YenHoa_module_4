package com.example.mail_box.service.impl;

import com.example.mail_box.Repository.IMailBoxRepo;
import com.example.mail_box.model.MailBox;
import com.example.mail_box.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MailBoxService implements IMailBoxService {
    @Autowired
    private IMailBoxRepo mailBoxRepo;

    @Override
    public List<MailBox> getMailBoxes() {
        return mailBoxRepo.getMailBoxes();
    }

    @Override
    public List<String> getLanguage() {
        return mailBoxRepo.getLanguage();
    }

    @Override
    public MailBox findById(Integer id) {
        return mailBoxRepo.findById(id);
    }

    @Override
    public List<Integer> getPageSize() {
        return mailBoxRepo.getPageSize();
    }

    @Override
    public void update(MailBox mailBox) {
        mailBoxRepo.update(mailBox);
    }
}
