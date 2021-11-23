package com.example.f21comp1011lhw10;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {

    /**
     * This method extracts the JSON from the file
     *
     */
    public static OMDBResponse getMoviesFromJSON()
    {
        Gson gson = new Gson();
        OMDBResponse result = null;

        //create a FileReader that is passed into a JSONReader
        try(
                FileReader fileReader = new FileReader("apiResponse.json");
                JsonReader jsonReader = new JsonReader(fileReader);
                )
        {
            result = gson.fromJson(jsonReader, OMDBResponse.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * This method will call the OMBD API and return an OMDBResponse object
     */
    public static OMDBResponse getMoviesFromAPI(String searchText) throws IOException, InterruptedException {
        OMDBResponse result = null;

        searchText = searchText.replace(" ", "%20");

        //this is the URL that we put into the Browser
        String uri = "http://www.omdbapi.com/?apikey=4a1010ab&s="+searchText;

        //This snippet is how Java makes the http request and stores the response in a file
        //called "apiResponse.json"
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers
                                            .ofFile(Paths.get("apiResponse.json")));

        //using our existing method to read the JSON and create a OMDBResponse object
        result = getMoviesFromJSON();
        return result;
    }
}
