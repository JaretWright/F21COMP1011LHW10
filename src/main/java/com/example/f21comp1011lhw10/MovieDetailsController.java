package com.example.f21comp1011lhw10;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

public class MovieDetailsController {

    @FXML
    private Label releaseDateLabel;

    @FXML
    private Label imdbLabel;

    @FXML
    private Label runtimeLabel;

    @FXML
    private ListView<String> genreListView;

    @FXML
    private ListView<String> actorsListView;

    @FXML
    private Label boxOfficeLabel;

    @FXML
    private ImageView imageView;

}
