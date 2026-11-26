package com.example.mytunesportfolio3;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.Optional;

public class PlaylistKnap {

    private ObservableList<Playlist> liste;
    private Playlist pl;


    public PlaylistKnap(ObservableList<Playlist> liste) {
        this.liste = liste;
    }

    public PlaylistKnap(ObservableList<Playlist> liste, Playlist pl) {
        this.liste = liste;
        this.pl=pl;

    }

    public void editPlaylist() {
        Dialog<ButtonType> dialogvindue = new Dialog<>();
        dialogvindue.setTitle("Edit playlist");
        dialogvindue.setHeaderText("Edit playlist");
        dialogvindue.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        TextField navnefelt = new TextField(pl.getName());

        dialogvindue.getDialogPane().setContent(new VBox(10, navnefelt));

        Optional<ButtonType> knap = dialogvindue.showAndWait();

        if (knap.isPresent() && knap.get() == ButtonType.OK) {
            pl.setName(navnefelt.getText());
            liste.set(liste.indexOf(pl), pl);
        }
    }

    private File valgt;
    public void newPlaylist() {
        Dialog<ButtonType> newPlaylistDialog = new Dialog<>();
        newPlaylistDialog.setTitle("New playlist");
        newPlaylistDialog.setHeaderText("New playlist");
        newPlaylistDialog.getDialogPane().getButtonTypes().addAll(ButtonType.APPLY, ButtonType.CLOSE);

        Label playlistLabel = new Label("Playlistnavn:");
        Label info = new Label("Add songs to playlist in all songs");
        TextField playlistName = new TextField();

        HBox playlist = new HBox(5, playlistLabel, playlistName);
        playlist.setAlignment(Pos.CENTER);

        newPlaylistDialog.getDialogPane().setContent(new VBox(10, playlist, info));

        Button applyButton = (Button) newPlaylistDialog.getDialogPane().lookupButton(ButtonType.APPLY);
        applyButton.addEventFilter(javafx.event.ActionEvent.ACTION, event -> {
            if (playlistName.getText().trim().isEmpty()) {
                new Alert(Alert.AlertType.WARNING,
                        "The playlist should have a name!",
                        ButtonType.OK).showAndWait();
                event.consume();
            }
        });

        Optional <ButtonType> knap = newPlaylistDialog.showAndWait();

        if (knap.isPresent() && knap.get() == ButtonType.APPLY) {
                liste.add(new Playlist(playlistName.getText(), 0,0));
        }
    }
}
