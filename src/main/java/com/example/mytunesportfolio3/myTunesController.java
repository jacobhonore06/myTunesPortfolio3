package com.example.mytunesportfolio3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class myTunesController {

    @FXML
    private TextField filterSearch;

    @FXML
    private Label playingSong;

    @FXML
    public TableView<Playlist> playlists;

    @FXML
    private TableColumn<Playlist, String> nameKolonne;

    @FXML
    private TableColumn<Playlist, String> songsKolonne;

    @FXML
    private TableColumn<Playlist, String> timeKolonne;

    @FXML
    private ImageView songCover;

    @FXML
    private TableView<Playlist> songsOnPlaylist;

    @FXML
    private TableColumn<?, String> numberKolonne;

    @FXML
    private TableColumn<?, String> songKolonne;

    AlleSange alleSange;

    public ObservableList<Playlist> observablePlaylist = FXCollections.observableArrayList();

    public void initialize () {
        nameKolonne.setCellValueFactory(new PropertyValueFactory<Playlist, String>("name"));
        songsKolonne.setCellValueFactory(new PropertyValueFactory<Playlist, String>("songs"));
        timeKolonne.setCellValueFactory(new PropertyValueFactory<Playlist, String>("time"));
        //numberKolonne.setCellValueFactory(new PropertyValueFactory<Sang, String>("number"));
        //songKolonne.setCellValueFactory(new PropertyValueFactory<Sang, String>("song"));


        Playlist p1 = new Playlist("Erik", 1, 30);
        p1.tilføjSange(new Sang("Erik", "Erik", 30, "self made", "SEA"));

        observablePlaylist.add(p1);

        playlists.setItems(observablePlaylist);

        alleSange = new AlleSange();
        //alleSange.indlaesMappe("C:\\Desktop\\Proggramering\\musik");
        alleSange.indlaesMappe("/Users/jacobhonore/Library/CloudStorage/OneDrive-SyddanskErhvervsakademi 2/SCO1/Java/JavaFX/musik");
    }

    @FXML //Lav som ny klasse + dialog
    void alleSange(ActionEvent event) {
        alleSange.opretDialog();
    }

    @FXML //Lav i controller
    void deletePlaylist(ActionEvent event) {
        delete();
    }
    public void delete() {
        Dialog<ButtonType> deletePlaylistDialog = new Dialog<>();
        deletePlaylistDialog.setTitle("Are you sure, you want to delete?");
        deletePlaylistDialog.setHeaderText("Delete?");
        deletePlaylistDialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);

        Button deletePlaylisten = new Button("Delete playlist");
        deletePlaylisten.setOnAction(event -> {
            try {
                observablePlaylist.remove(playlists.getSelectionModel().getSelectedIndex());
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("listen er tom");
            }
        });

        deletePlaylistDialog.getDialogPane().setContent(new VBox(10, deletePlaylisten));
        deletePlaylistDialog.show();
    }


    @FXML //Lav i controller
    void deleteSong(ActionEvent event) {

        
    }

    @FXML //Lav som ny klasse (PlaylistKnap) m. newPlaylist + dialog
    void editPlaylist(ActionEvent event) {
        PlaylistKnap playlistKnap = new PlaylistKnap(observablePlaylist);
        playlistKnap.editPlaylist();
    }

    @FXML //Lav i samme klasse som editPlaylist + dialog
    void newPlaylist(ActionEvent event) {
        PlaylistKnap playlistKnap = new PlaylistKnap(observablePlaylist);
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
        if (filterSearch != null) {
            String search = filterSearch.getText();
            ObservableList<Playlist> finde = FXCollections.observableArrayList();

            for (Playlist p : observablePlaylist) {
                if (p.getSongs().contains(search)) {
                    finde.add(p);
                }
            }
            playlists.setItems(finde);
        } else {
            playlists.setItems(observablePlaylist);
        }
    }

    @FXML //lav i controller
    void songDown(ActionEvent event) {

    }

    @FXML //lav i controller
    void songUp(ActionEvent event) {

    }

}