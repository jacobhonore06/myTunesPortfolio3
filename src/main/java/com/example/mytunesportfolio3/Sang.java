package com.example.mytunesportfolio3;

import java.util.ArrayList;

public class Sang {
    private String songTitle;
    private String songArtist;
    private int songDuration;
    private String songGenre;
    private String songAlbum;
    private String fil;

    public Sang (String songTitle1, String songArtist1, int songDuration1, String songGenre1, String songAlbum1) {
        this.songTitle = songTitle1;
        this.songArtist = songArtist1;
        this.songDuration = songDuration1;
        this.songGenre = songGenre1;
        this.songAlbum = songAlbum1;
    }

    public String getSongTitle() {
        return songTitle;
    }
    public void setSongTitle (String st) {
        this.songTitle = st;
    }

    public String getSongArtist () {
        return songArtist;
    }
    public void setSongArtist (String sa) {
        this.songArtist = sa;
    }

    public String getSongDuration () {
        int timer = songDuration / 3600;
        int minutter = (songDuration % 3600) / 60;
        int sekunder = songDuration % 60;
        return String.format("%d:%02d:%02d", timer, minutter, sekunder);
    }
    public void setSongDuration (int sd) {
        this.songDuration = sd;
    }

    public String getSongGenre () {
        return songGenre;
    }
    public void setSongGenre (String sg) {
        this.songGenre = sg;
    }

    public String getSongAlbum () {
        return songAlbum;
    }
    public void setSongAlbum (String s) {
        this.songAlbum = s;
    }

    public String getFil() {
        return fil;
    }
    public void setFil(String f) {
        this.fil = f;
    }
}
