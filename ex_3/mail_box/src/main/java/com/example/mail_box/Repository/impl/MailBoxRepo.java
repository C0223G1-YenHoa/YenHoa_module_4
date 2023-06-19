package com.example.mail_box.Repository.impl;

import com.example.mail_box.Repository.IMailBoxRepo;
import com.example.mail_box.model.MailBox;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MailBoxRepo implements IMailBoxRepo {

    private static List<MailBox> mailBoxes=new ArrayList<>();
    private static List<String> languages= new ArrayList<>();
    private static List<Integer> pageSizes=new ArrayList<>();
    static{
        pageSizes.add(5);
        pageSizes.add(10);
        pageSizes.add(15);
        pageSizes.add(25);
        pageSizes.add(50);
        pageSizes.add(100);
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        mailBoxes.add(new MailBox(1,languages.get(2), pageSizes.get(3),true,"Lê Thị Yến Hoa" ));
        mailBoxes.add(new MailBox(2,languages.get(1), pageSizes.get(4),false,"Lê Văn Hưng" ));
        mailBoxes.add(new MailBox(3,languages.get(3), pageSizes.get(2),true,"Mai Phước Tài" ));
        mailBoxes.add(new MailBox(4,languages.get(0), pageSizes.get(1),false,"Trần Thanh Sơn" ));
    }

    @Override
    public List<MailBox> getMailBoxes() {
        return mailBoxes;
    }

    @Override
    public List<String> getLanguage() {
        return languages;
    }

    @Override
    public List<Integer> getPageSize() {
        return pageSizes;
    }

    @Override
    public MailBox findById(Integer id) {
        for (MailBox m: mailBoxes) {
            if(m.getId()==id){
                return m;
            }
        }
        return null;
    }

    @Override
    public void update(MailBox mailBox) {
        for (MailBox m : mailBoxes) {
            if (m.getId() == mailBox.getId()) {
                m.setLanguage(mailBox.getLanguage());
                m.setPageSize(mailBox.getPageSize());
                m.setSpams(mailBox.isSpams());
                m.setSignature(mailBox.getSignature());
            }
        }
    }
}
