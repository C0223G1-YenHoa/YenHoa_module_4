package com.example.dictionary_1;

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
    private static Map<String, String> listWord = new HashMap<>();

    static {
        listWord.put("Banana", "quả chuối");
        listWord.put("Apple", "quả táo");
        listWord.put("Jack fruit", "quả mít");
        listWord.put("Orange", "quả cam");
        listWord.put("Strawberry", "trái dâu");
    }

    @GetMapping("")
    public String dictionary() {
        return "translate";
    }

    @GetMapping("translate")
    public String translate(@RequestParam String word, Model model) {
        for (Map.Entry<String, String> entry : listWord.entrySet()) {
            if (word.equals(entry.getValue())) {
                model.addAttribute("mean", entry.getKey());
                return "translate";

            }
        }
        model.addAttribute("notfound", "NOT FOUND");
        return "translate";
    }
}
