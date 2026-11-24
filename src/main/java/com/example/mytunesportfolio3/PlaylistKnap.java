package com.example.mytunesportfolio3;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public class PlaylistKnap {

    public void editPlaylist() {
        Dialog<ButtonType> editPlaylistDialog = new Dialog<>();
        editPlaylistDialog.setTitle("Edit playlist");
        editPlaylistDialog.setHeaderText("Edit playlist");
        editPlaylistDialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);

        editPlaylistDialog.show();
    }

    public void newPlaylist() {
        Dialog<ButtonType> newPlaylistDialog = new Dialog<>();
        newPlaylistDialog.setTitle("New playlist");
        newPlaylistDialog.setHeaderText("New playlist");
        newPlaylistDialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);

        newPlaylistDialog.show();
    }
}
