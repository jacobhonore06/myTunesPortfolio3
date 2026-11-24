package com.example.mytunesportfolio3;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/*
Denne klasse indeholder et dialogvindue, hvor alle sange bliver vist, og der er en søgefunktion.
Vi laver koden til dette dialogvindue i denne klasse, for at have et bedre overblik i controlleren.
 */

public class AlleSange {

    public void opretDialog() {
        Dialog<ButtonType> dialogVindue = new Dialog<>();
        dialogVindue.setTitle("Alle sange");
        dialogVindue.setHeaderText("Alle sange");
        dialogVindue.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);

        TextField alleSangeSøg = new TextField();
        Button søgKnap = new Button("Søg");
        Button newSong = new Button("New");
        Button editSong = new Button("Edit");
        Button deleteSang = new Button("Delete");

        newSong.setOnAction(event -> {
            newSongDialog();
        });

        editSong.setOnAction(event -> {
            editSongDialog();
        });

        TableView <AlleSange> alleSange = new TableView<>();
        TableColumn<AlleSange, String> TitleColumn = new TableColumn<>("Title");
        TableColumn<AlleSange, String> ArtistColumn = new TableColumn<>("Artist");
        TableColumn<AlleSange, String> DurationColumn = new TableColumn<>("Duration");
        TableColumn<AlleSange, String> GenreColumn = new TableColumn<>("Genre");
        TableColumn<AlleSange, String> AlbumColumn = new TableColumn<>("Album");

        alleSange.getColumns().addAll(TitleColumn, ArtistColumn, DurationColumn, GenreColumn, AlbumColumn);


        HBox hBox = new HBox(10, alleSangeSøg, søgKnap);
        hBox.setAlignment(Pos.CENTER_RIGHT);

        HBox hBoxKnapper = new HBox(50, newSong, editSong, deleteSang);
        hBoxKnapper.setAlignment(Pos.CENTER);

        dialogVindue.getDialogPane().setContent(new VBox(10, hBox, alleSange, hBoxKnapper));
        dialogVindue.show();
    }

    public void editSongDialog () {
        Dialog<ButtonType> editSongDialog = new Dialog<>();
        editSongDialog.setTitle("Edit song");
        editSongDialog.setHeaderText("Edit song");
        editSongDialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);

        editSongDialog.show();
    }

    public void newSongDialog () {
        Dialog<ButtonType> newSongDialog = new Dialog<>();
        newSongDialog.setTitle("New song");
        newSongDialog.setHeaderText("New song");
        newSongDialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);

        newSongDialog.show();
    }

}


