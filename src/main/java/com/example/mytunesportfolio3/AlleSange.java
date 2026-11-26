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
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;


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
                new FileChooser.ExtensionFilter("Sounds", "*.mp3", "*.wav"));
        //File startmappe = new File("/Users/jacobhonore/Library/CloudStorage/OneDrive-SyddanskErhvervsakademi 2/SCO1/Java/JavaFX/musik");
        File startmappe = new File("C:\\Desktop\\Proggramering\\musik");
        if (startmappe.exists()) {
            fileChooser.setInitialDirectory(startmappe);
        }
        Button addSong = new Button("Add songs");
        addSong.setOnAction(event1 -> {
            File fil = fileChooser.showOpenDialog(addSong.getScene().getWindow());
            if (fil != null) {
                valgt = fil;
                addSong.setText(fil.getName());
                fileName.setText(fil.getName());
            }
        });
        HBox h5 = new HBox(5, labelFile, fileName, addSong);

        newSongDialog.getDialogPane().setContent(new VBox(10, h1, h2, h3, h4, h5));

        Optional<ButtonType> knap = newSongDialog.showAndWait();

        if (knap.isPresent() && knap.get() == ButtonType.OK) {
            try {
                String titel = song.getText();
                String kunstner = artist.getText();
                String kategorie = categoryBoks.getValue();
                String filen = fileName.getText();

                if (titel.isEmpty() || kunstner.isEmpty() || kategorie == null || filen.isEmpty()) {
                    System.out.println("Du skal udfylde alt");
                    return;
                }

                Sang s = new Sang(song.getText(), artist.getText(), 0, categoryBoks.getValue(), fileName.getText());
                sangeListe.add(s);

            } catch (NumberFormatException e) {
                System.out.println("der gik noget galt");
            }
        }
    }
}


