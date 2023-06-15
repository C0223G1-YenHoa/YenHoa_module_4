package com.example.dictionary_1.service.impl;

import com.example.dictionary_1.repository.IDictionaryRepository;
import com.example.dictionary_1.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    private IDictionaryRepository dictionaryRepository;

    @Override
    public String translate(String word) {
        return dictionaryRepository.translate(word);
    }
}
