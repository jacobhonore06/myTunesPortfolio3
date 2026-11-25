package com.example.mytunesportfolio3;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Optional;

public class PlaylistKnap {

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

        /*FileChooser filechooser = new FileChooser();
        filechooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Billeder", "*.mp3"));
        File startmappe = new File("/Users/jacobhonore/Library/CloudStorage/OneDrive-SyddanskErhvervsakademi 2/SCO1/Java/JavaFX/musik");
        //File startmappe = new File("C:\\Desktop\\Proggramering\\musik");
        if (startmappe.exists()) {
            filechooser.setInitialDirectory(startmappe);
        }

        Button addSong = new Button("Add songs");
        addSong.setOnAction(event1 -> {
            File fil = (File) filechooser.showOpenMultipleDialog(addSong.getScene().getWindow());
            if (fil != null) {
                valgt = fil;
                addSong.setText(fil.getName());
            }
        });*/

        newPlaylistDialog.getDialogPane().setContent(new VBox(10, playlist, info));

        Optional<ButtonType> knap = newPlaylistDialog.showAndWait();

        while (knap.isPresent() && knap.get() == ButtonType.APPLY && playlistName.getText().isEmpty()) {
            new Alert(Alert.AlertType.WARNING,"Playlist should have a name").showAndWait();
            newPlaylistDialog.showAndWait();
        }

        if (knap.isPresent() && knap.get() == ButtonType.APPLY) {
            String navn = playlistName.getText();
        }
    }

}
