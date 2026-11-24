package com.example.mytunesportfolio3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


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
    private TableView<Playlist> songsOnPlaylist;

    @FXML
    private TableColumn<?, ?> numberKolonne;

    @FXML
    private TableColumn<?, ?> songKolonne;

    @FXML
    private TableColumn<Playlist, String> timeKolonne;

    public void initialize () {
        playlists.setItems(observablePlaylist);
    }

    @FXML //Lav som ny klasse + dialog
    void alleSange(ActionEvent event) {
        AlleSange alleSange = new AlleSange();
        alleSange.opretDialog();
        
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
        PlaylistKnap playlistKnap = new PlaylistKnap();
        playlistKnap.editPlaylist();
    }

    @FXML //Lav i samme klasse som editPlaylist + dialog
    void newPlaylist(ActionEvent event) {
        PlaylistKnap playlistKnap = new PlaylistKnap();
        playlistKnap.newPlaylist();
    }

    @FXML //Lav i controller?
    void nextSong(ActionEvent event) {

    }

    private MediaPlayer mediaPlayer;
    @FXML //Lav i controller?
    void playSong(ActionEvent event) {
        try {
            Media lyd = new Media(String.valueOf(getClass().getResource("sample-3s.mp3")));
            mediaPlayer = new MediaPlayer(lyd);
            mediaPlayer.seek(mediaPlayer.getStartTime());
            mediaPlayer.play();

            //welcomeText.setText("Afspiller nu :" + mediaPlayer.getMedia().getSource().toString());
        } catch (Exception e) {
            System.out.println("Fejl: " + e.getMessage());
        }
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