package com.example.f21comp1011lhw10;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MovieDetailsController implements Initializable, InitializesMovie {

    @FXML
    private Label titleLabel;

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

    @FXML
    private void backToSearch(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"search-view.fxml","OMDB - Search for your favourite movie!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void getMovieDetails(String movieID)
    {
        try {
            MovieDetail movieDetail = APIUtility.getMovieDetail(movieID);
            titleLabel.setText(movieDetail.getTitle());
            releaseDateLabel.setText(movieDetail.getReleased());
            imdbLabel.setText(movieDetail.getRated());
            runtimeLabel.setText(movieDetail.getRuntime());
            genreListView.getItems().addAll(movieDetail.getGenreArray());
            actorsListView.getItems().addAll(movieDetail.getActorsArray());
            boxOfficeLabel.setText(movieDetail.getBoxOffice());
            try {
                imageView.setImage(new Image(movieDetail.getPoster()));
            } catch (Exception e)
            {
                imageView.setImage(new Image(getClass().getResourceAsStream("default-movie.png")));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
