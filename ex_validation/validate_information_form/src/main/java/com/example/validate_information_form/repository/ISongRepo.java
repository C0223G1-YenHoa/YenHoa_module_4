package com.example.validate_information_form.repository;

import com.example.validate_information_form.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface ISongRepo extends JpaRepository<Song,Integer>{

    @Query(value = "select * from song where is_flag=false",nativeQuery = true)
    List<Song> findAllByIsFlagFalse();
}
