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

import java.io.IOException;
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
    void getSearchResults(ActionEvent event) throws IOException, InterruptedException {
        initialMovieDataListView.getItems().clear();
        initialMovieDataListView.setVisible(true);
        errMsgLabel.setVisible(false);
        try {
            initialMovieDataListView.getItems().addAll(
                    APIUtility.getMoviesFromAPI(searchTextField.getText()).getSearch());
        } catch(NullPointerException e)
        {
            errMsgLabel.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //make the error msg label invisible unless there is an issue
        errMsgLabel.setVisible(false);
        getDetailsButton.setVisible(false);
        initialMovieDataListView.setVisible(false);

        //add a listener to the ListView of movies to show the poster art
        initialMovieDataListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, old, movieSelected) -> {
                    getDetailsButton.setVisible(true);
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

