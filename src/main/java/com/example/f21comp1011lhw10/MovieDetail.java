package com.example.f21comp1011lhw10;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;

public class MovieDetail {
    @SerializedName("Title")
    private String title;

    @SerializedName("Released")  //what it is called in the JSON file
    private String released;     //what we will call it in our Java program

    @SerializedName("Runtime")
    private String runtime;

    @SerializedName("Genre")
    private String genre;

    @SerializedName("Actors")
    private String actors;

    @SerializedName("Boxoffice")
    private String boxOffice;

    @SerializedName("Rated")
    private String rated;

    @SerializedName("Poster")
    private String poster;

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    public String[] getGenreArray()
    {
        return genre.split(", ");
    }

    public String[] getActorsArray()
    {
        return actors.split(", ");
    }
}
