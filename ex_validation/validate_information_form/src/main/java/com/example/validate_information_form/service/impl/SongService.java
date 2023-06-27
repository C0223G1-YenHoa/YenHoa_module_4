package com.example.validate_information_form.service.impl;

import com.example.validate_information_form.model.Song;
import com.example.validate_information_form.repository.ISongRepo;
import com.example.validate_information_form.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepo songRepo;
    @Override
    public List<Song> getList() {
        return songRepo.findAllByIsFlagFalse();
    }

    @Override
    public void create(Song song) {
    this.songRepo.save(song);
    }

    @Override
    public void update(Song song) {
        this.songRepo.save(song);
    }

    @Override
    public void delete(int id) {
    this.songRepo.save(findById(id));
    }

    @Override
    public Song findById(int id) {
        try {
            return songRepo.findById(id).get();
        }catch (IllegalArgumentException e){
            return null;
        }
    }
}
