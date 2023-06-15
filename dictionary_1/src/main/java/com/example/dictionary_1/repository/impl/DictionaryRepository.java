package com.example.dictionary_1.repository.impl;

import com.example.dictionary_1.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String, String> listWord = new HashMap<>();

    static {
        listWord.put("Banana", "quả chuối");
        listWord.put("Apple", "quả táo");
        listWord.put("Jack fruit", "quả mít");
        listWord.put("Orange", "quả cam");
        listWord.put("Strawberry", "trái dâu");
    }


    @Override
    public String translate(String word) {
        for (Map.Entry<String, String> entry : listWord.entrySet()) {
            if (word.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
