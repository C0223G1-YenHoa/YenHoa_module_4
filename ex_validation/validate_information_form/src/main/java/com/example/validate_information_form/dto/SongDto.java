package com.example.validate_information_form.dto;


import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto {
    @NotBlank
    @Size(max = 800)
    @Pattern(regexp = "^([\\w\\d\\s]+)+$", message = "Don't have  @ ; , . = - + ")
    private String songName;

    @NotBlank
    @Size(max = 300)
    @Pattern(regexp = "^([\\w\\d\\s]+)+$", message = "Don't have  @ ; , . = - + ")
    private String singer;

    @NotBlank
    @Size(max = 1000)
    @Pattern(regexp = "^([\\w\\d\\s]+[,]*)+$", message = "Don't have  @ ; . = - + ")
    private String kindOfMusic;


    private boolean isFlag;

    public SongDto() {
    }

    public SongDto(String songName, String singer, String kindOfMusic, boolean isFlag) {
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
