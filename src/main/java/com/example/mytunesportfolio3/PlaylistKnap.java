package com.example.mytunesportfolio3;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Optional;

public class PlaylistKnap extends myTunesController{

    public void editPlaylist() {
        Dialog<ButtonType> editPlaylistDialog = new Dialog<>();
        editPlaylistDialog.setTitle("Edit playlist");
        editPlaylistDialog.setHeaderText("Edit playlist");
        editPlaylistDialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);

        editPlaylistDialog.show();
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

        Optional <ButtonType> knap = newPlaylistDialog.showAndWait();

        Button applyButton = (Button) newPlaylistDialog.getDialogPane().lookupButton(ButtonType.APPLY);
        applyButton.addEventFilter(javafx.event.ActionEvent.ACTION, event -> {
            if (playlistName.getText().trim().isEmpty()) {
                new Alert(Alert.AlertType.WARNING,
                        "The playlist should have a name!",
                        ButtonType.OK).showAndWait();
                event.consume(); // block the APPLY action, dialog stays open
            }
        });

        if (knap.isPresent() && knap.get() == ButtonType.APPLY) {
                Playlist newPlaylist = new Playlist(
                        playlistName.getText(),
                        0,0
                );
                observablePlaylist.add(newPlaylist);
                playlists.setItems(observablePlaylist);
                playlists.sort();
        }

        newPlaylistDialog.showAndWait();
    }

}
