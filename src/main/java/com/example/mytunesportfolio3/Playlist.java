package com.example.mytunesportfolio3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Playlist {
    private String name;
    private int songs;
    private int time;
    private ArrayList<Sang> sange = new ArrayList<>();
    private transient ObservableList<Sang> sangeListe;

    public ObservableList<Sang> getSangeListe() {
        if (sangeListe == null) {
            sangeListe = FXCollections.observableList(sange);
        }
        return sangeListe;
    }

    public Playlist (String name1, int songs1, int time1) {
        this.name = name1;
        this.songs = songs1;
        this.time = time1;
    }

    public ArrayList<Sang> getSange () {
        return sange;
    }
    public void tilføjSongs(Sang s) {
        getSangeListe().add(s);
    }
    public void tilføjSange(Sang sang) {sange.add(sang);}

    public String getName () {
        return name;
    }
    public void setName (String n) {
        this.name = n;
    }

    public String getSongs () {
        return String.valueOf(songs);
    }
    public void setSongs (int s) {
        this.songs = s;
    }

    public String getTime () {
        return String.valueOf(time);
    }
    public void setTime (int t) {
        this.time = t;
    }

    @Override
    public String toString() {
        return getName();
    }
}

