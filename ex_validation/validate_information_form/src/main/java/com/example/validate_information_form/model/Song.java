package com.example.validate_information_form.model;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String songName;
    private String singer;
    private String kindOfMusic;
    private boolean isFlag;

    public Song() {
    }


    public Song(int id, String songName, String singer, String kindOfMusic, boolean isFlag) {
        this.id = id;
        this.songName = songName;
        this.singer = singer;
        this.kindOfMusic = kindOfMusic;
        this.isFlag = isFlag;
    }

    public boolean isFlag() {
        return isFlag;
    }

    public void setFlag(boolean flag) {
        isFlag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }
}
