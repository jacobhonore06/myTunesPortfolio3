package com.example.mytunesportfolio3;

import javafx.geometry.Pos;
import javafx.scene.control.*;
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
        newSongDialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        Label labelSong = new Label("Sang: ");
        TextField song = new TextField();
        HBox h1 = new HBox(5, labelSong, song);

        Label labelArtist = new Label("Artist: ");
        TextField artist = new TextField();
        HBox h2 = new HBox(5, labelArtist, artist);

        Label labelCategory = new Label("Category: ");
        ComboBox<String> categoryBoks = new ComboBox<>();
        categoryBoks.getItems().addAll("Pop", "Klassik", "Techno", "Rock");
        categoryBoks.setPromptText("Vælg genre");
        HBox h3 = new HBox(5, labelCategory, categoryBoks);

        Label labelTid = new Label("Tid: ");
        Label tidInfo = new Label("bliver taget automatisk");
        HBox h4 = new HBox(5, labelTid, tidInfo);

        Label labelFile = new Label("File: ");
        TextField fileName = new TextField();
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
        HBox h5 = new HBox(5, labelFile, fileName, addSong);

        newSongDialog.getDialogPane().setContent(new VBox(10, h1, h2, h3, h4, h5));

        newSongDialog.show();
    }
}
