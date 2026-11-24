package com.example.mytunesportfolio3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

public class myTunesController {

    @FXML
    private TextField filterSearch;

    @FXML
    private TableColumn<Playlist, String> nameKolonne;

    @FXML
    private Label playingSong;

    @FXML
    private TableView<Playlist> playlists;
    private ObservableList<Playlist> observablePlaylist = FXCollections.observableArrayList();

    @FXML
    private ImageView songCover;

    @FXML
    private TableColumn<Playlist, ?> songsKolonne;

    @FXML
    private ListView<?> songsOnPlaylist;

    @FXML
    private TableColumn<Playlist, String> timeKolonne;

    public void initialize () {
        playlists.setItems(observablePlaylist);
    }

    @FXML //Lav som ny klasse + dialog
    void alleSange(ActionEvent event) {

    }

    @FXML //Lav i controller
    void deletePlaylist(ActionEvent event) {
        Playlist playlistValgt = playlists.getSelectionModel().getSelectedItem();
        if (playlistValgt == null) {
            return;
        }
        observablePlaylist.remove(playlistValgt);
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