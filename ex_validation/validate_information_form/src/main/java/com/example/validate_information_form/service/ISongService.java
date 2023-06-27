package com.example.validate_information_form.service;

import com.example.validate_information_form.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> getList();
    void create(Song song);
    void update(Song song);
    void delete(int id);
    Song findById(int id);
}
