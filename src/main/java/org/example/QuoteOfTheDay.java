package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;

public class QuoteOfTheDay {
    public static void main(String[] args) {
        String responseBody = null;

        // Create OkHttpClient object
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        // Create a request object for the Programming Quotes API
        Request request = new Request.Builder()
                .url("https://quotes.rest/qod.json")
                .get()
                .build();


// Try to read the response from the file
        responseBody = QuoteFileHandler.read();

        if (responseBody == null) {
            // If file is empty or doesn't exist, fetch the quote from the API and write to file
            try (Response response = client.newCall(request).execute()) {
                responseBody = response.body().string();
                QuoteFileHandler.write(responseBody);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // Parse the JSON response and print the quote of the day to the console
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONObject contentsObject = jsonObject.getJSONObject("contents");
        JSONObject quotesObject = contentsObject.getJSONArray("quotes").getJSONObject(0);
        String quote = quotesObject.getString("quote");
        String author = quotesObject.getString("author");
        System.out.println("Quote of the day: " + quote);

    }
}