package com.example.mytunesportfolio3;

import java.util.ArrayList;

public class Playlist {
    private String name;
    private int songs;
    private String time;
    private ArrayList<Sang> sange = new ArrayList<>();

    public Playlist (String name1, int songs1, String time1) {
        this.name = name1;
        this.songs = songs1;
        this.time = time1;
    }

    public ArrayList<Sang> getSange () {
        return sange;
    }
}

