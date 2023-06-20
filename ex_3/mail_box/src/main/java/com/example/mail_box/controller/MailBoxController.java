package com.example.mail_box.controller;

import com.example.mail_box.model.MailBox;
import com.example.mail_box.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailBoxController {
    @Autowired
    private IMailBoxService mailBoxService;

    @GetMapping("")
    public String mailBox(Model model) {
        model.addAttribute("mailList", mailBoxService.getMailBoxes());
        return "mail";
    }

    @GetMapping("/showEditForm/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("mail_box");
        MailBox mailBox = mailBoxService.findById(id);
        modelAndView.addObject("mailBox", mailBox);
        modelAndView.addObject("languages", mailBoxService.getLanguage());
        modelAndView.addObject("pageSizes",mailBoxService.getPageSize());
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateMail(@ModelAttribute MailBox mailBox) {
        mailBoxService.update(mailBox);
        return "redirect:/";
    }
}
