package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class RideShare {
    public static JSONObject getCoordinates(String address) throws Exception {
        String apiKey = "YOUR_GOOGLE_API_KEY";  // Replace with your API key
        String urlString = "https://maps.googleapis.com/maps/api/geocode/json?address=" 
                            + address.replace(" ", "+") + "&key=" + apiKey;
        
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        conn.disconnect();

        JSONObject jsonResponse = new JSONObject(content.toString());
        double lat = jsonResponse.getJSONArray("results")
                                 .getJSONObject(0)
                                 .getJSONObject("geometry")
                                 .getJSONObject("location")
                                 .getDouble("lat");
        double lng = jsonResponse.getJSONArray("results")
                                 .getJSONObject(0)
                                 .getJSONObject("geometry")
                                 .getJSONObject("location")
                                 .getDouble("lng");

        JSONObject coordinates = new JSONObject();
        coordinates.put("lat", lat);
        coordinates.put("lng", lng);

        return coordinates;
    }
}
