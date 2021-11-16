package com.example.f21comp1011lhw10;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchViewController implements Initializable {

    @FXML
    private TextField searchTextField;

    @FXML
    private ListView<Movie> initialMovieDataListView;

    @FXML
    private ImageView posterImageView;

    @FXML
    private Button getDetailsButton;

    @FXML
    private Label errMsgLabel;

    @FXML
    void getSearchResults(ActionEvent event) {
        initialMovieDataListView.getItems().addAll(APIUtility.getMoviesFromJSON().getSearch());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //add a listener to the ListView of movies to show the poster art
        initialMovieDataListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, old, movieSelected) -> {
                    try {
                        posterImageView.setImage(new Image(movieSelected.getPoster()));
                    } catch (Exception e)
                    {
                        posterImageView.setImage(new Image(getClass().getResourceAsStream("default-movie.png")));
                    }
                }
        );
    }
}

