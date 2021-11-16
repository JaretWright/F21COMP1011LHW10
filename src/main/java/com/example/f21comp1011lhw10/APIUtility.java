package com.example.f21comp1011lhw10;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;

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
}
