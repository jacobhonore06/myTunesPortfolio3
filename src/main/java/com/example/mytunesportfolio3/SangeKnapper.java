package com.example.mytunesportfolio3;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;

public class SangeKnapper {

    public void editSongDialog () {
        Dialog<ButtonType> editSongDialog = new Dialog<>();
        editSongDialog.setTitle("Edit song");
        editSongDialog.setHeaderText("Edit song");
        editSongDialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);

        editSongDialog.show();
    }

    private File valgt;
    public void newSongDialog () {
        Dialog<ButtonType> newSongDialog = new Dialog<>();
        newSongDialog.setTitle("New song");
        newSongDialog.setHeaderText("New song");
        newSongDialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Sounds", "*.mp3" + ".wav"));
        //File startmappe = new File("/Users/jacobhonore/Library/CloudStorage/OneDrive-SyddanskErhvervsakademi 2/SCO1/Java/JavaFX/musik");
        File startmappe = new File("C:\\Desktop\\Proggramering\\musik");
        if (startmappe.exists()) {
            fileChooser.setInitialDirectory(startmappe);
        }

        Button addSong = new Button("Add songs");
        addSong.setOnAction(event1 -> {
            File fil = (File) fileChooser.showOpenMultipleDialog(addSong.getScene().getWindow());
            if (fil != null) {
                valgt = fil;
                addSong.setText(fil.getName());
            }
        });

        newSongDialog.getDialogPane().setContent(new VBox(10, addSong));

        newSongDialog.show();
    }
}
