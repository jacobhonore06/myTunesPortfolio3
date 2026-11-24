package com.example.mytunesportfolio3;

import java.util.ArrayList;

public class Playlist {
    private String name;
    private int songs;
    private int time;
    private ArrayList<Sang> sange = new ArrayList<>();

    public Playlist (String name1, int songs1, int time1) {
        this.name = name1;
        this.songs = songs1;
        this.time = time1;
    }

    public ArrayList<Sang> getSange () {
        return sange;
    }

    public String getName () {
        return name;
    }
    public void setName (String n) {
        this.name = n;
    }

    public int getSongs () {
        return songs;
    }
    public void setSongs (int s) {
        this.songs = s;
    }

    public int getTime () {
        return time;
    }
    public void setTime (int t) {
        this.time = t;
    }
}

