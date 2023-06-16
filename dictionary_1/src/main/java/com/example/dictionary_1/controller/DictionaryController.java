package com.example.dictionary_1.controller;

import com.example.dictionary_1.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;


    @GetMapping("")
    public String dictionary() {
        return "translate";
    }

    @GetMapping("translate")
    public String translate(@RequestParam String word, Model model) {
        if (dictionaryService.translate(word) != null) {
            model.addAttribute("mean", dictionaryService.translate(word));
        } else
            model.addAttribute("notfound", "NOT FOUND THIS WORD");
        return "translate";
    }
}
