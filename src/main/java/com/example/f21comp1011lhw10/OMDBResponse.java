package com.example.f21comp1011lhw10;

import com.google.gson.annotations.SerializedName;

public class OMDBResponse {

    @SerializedName("Search")
    private Movie[] search;

    private String totalResults;

    @SerializedName("Response")
    private String response;

    public Movie[] getSearch() {
        return search;
    }

    public void setSearch(Movie[] search) {
        this.search = search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
