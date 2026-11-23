package com.example.mytunesportfolio3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class myTunesController {

    @FXML
    private TextField filterSearch;

    @FXML
    private TableColumn<?, ?> nameKolonne;

    @FXML
    private Label playingSong;

    @FXML
    private TableView<?> playlists;

    @FXML
    private ImageView songCover;

    @FXML
    private TableColumn<?, ?> songsKolonne;

    @FXML
    private ListView<?> songsOnPlaylist;

    @FXML
    private TableColumn<?, ?> timeKolonne;

    @FXML //Lav som ny klasse + dialog
    void alleSange(ActionEvent event) {

    }

    @FXML //Lav i controller
    void deletePlaylist(ActionEvent event) {

    }

    @FXML //Lav i controller
    void deleteSong(ActionEvent event) {

    }

    @FXML //Lav som ny klasse (PlaylistKnap) m. newPlaylist + dialog
    void editPlaylist(ActionEvent event) {

    }

    @FXML //Lav i samme klasse som editPlaylist + dialog
    void newPlaylist(ActionEvent event) {

    }

    @FXML //Lav i controller?
    void nextSong(ActionEvent event) {

    }

    @FXML //Lav i controller?
    void playSong(ActionEvent event) {

    }

    @FXML //Lav i controller?
    void songBack(ActionEvent event) {

    }

    @FXML //Lav i controller
    void searchIcon (ActionEvent event){

    }

    @FXML //lav i controller
    void songDown(ActionEvent event) {

    }

    @FXML //lav i controller
    void songUp(ActionEvent event) {

    }

}