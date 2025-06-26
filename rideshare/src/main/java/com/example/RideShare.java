package com.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class RideShare {
    public static void main(String[] args) {
        String apiUrl = "https://gbfs.divvybikes.com/gbfs/en/station_status.json";

        try {
            // Connect to the API endpoint
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read the response
            BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
            );
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            // Clean up
            in.close();
            conn.disconnect();

            // Parse JSON response
            JSONObject json = new JSONObject(content.toString());
            JSONArray stations = json
                .getJSONObject("data")
                .getJSONArray("stations");

            // Print info for each station
            for (int i = 0; i < stations.length(); i++) {
                JSONObject station = stations.getJSONObject(i);
                System.out.println(station);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
