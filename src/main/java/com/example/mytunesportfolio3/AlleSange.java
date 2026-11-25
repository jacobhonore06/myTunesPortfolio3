package com.example.mytunesportfolio3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;


/*
Denne klasse indeholder et dialogvindue, hvor alle sange bliver vist, og der er en søgefunktion.
Vi laver koden til dette dialogvindue i denne klasse, for at have et bedre overblik i controlleren.
 */

public class AlleSange {

    private ObservableList<Sang> sangeListe = FXCollections.observableArrayList();
    private ArrayList<MediaPlayer> players = new ArrayList<>();

    public void indlaesMappe(String mappeSti) {

        File mappe = new File(mappeSti);
        File[] filer = mappe.listFiles(
                (m, navn) -> navn.toLowerCase().endsWith(".mp3")
                        || navn.toLowerCase().endsWith(".wav"));

        if (filer == null) {
            System.out.println("Mappen findes ikke: " + mappeSti);
            return;
        }

        for (File fil : filer) {
            String titel = fil.getName().replaceFirst("\\.[^.]+$", "");
            Sang sang = new Sang(titel, "Ukendt", 0, "Ukendt", "Ukendt");
            sang.setFil(fil.toURI().toString());
            sangeListe.add(sang);


            MediaPlayer mp = new MediaPlayer(new Media(sang.getFil()));
            players.add(mp);
            mp.setOnReady(() -> {
                sang.setSongDuration((int) mp.getMedia().getDuration().toSeconds());
                sangeListe.set(sangeListe.indexOf(sang), sang);
            });
        }
    }

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

        TableView <Sang> alleSange = new TableView<>();
        TableColumn<Sang, String> TitleColumn = new TableColumn<>("Title");
        TableColumn<Sang, String> ArtistColumn = new TableColumn<>("Artist");
        TableColumn<Sang, String> DurationColumn = new TableColumn<>("Duration");
        TableColumn<Sang, String> GenreColumn = new TableColumn<>("Genre");
        TableColumn<Sang, String> AlbumColumn = new TableColumn<>("Album");

        TitleColumn.setCellValueFactory(new PropertyValueFactory<>("songTitle"));
        ArtistColumn.setCellValueFactory(new PropertyValueFactory<>("songArtist"));
        DurationColumn.setCellValueFactory(new PropertyValueFactory<>("songDuration"));
        GenreColumn.setCellValueFactory(new PropertyValueFactory<>("songGenre"));
        AlbumColumn.setCellValueFactory(new PropertyValueFactory<>("songAlbum"));

        alleSange.getColumns().addAll(TitleColumn, ArtistColumn, DurationColumn, GenreColumn, AlbumColumn);

        alleSange.setItems(sangeListe);

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


        newSongDialog.show();
    }
}


