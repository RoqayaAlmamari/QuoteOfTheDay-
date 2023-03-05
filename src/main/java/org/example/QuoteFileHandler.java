package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class QuoteFileHandler {

    // Define the path for the file
    private static final String FILE_PATH = "quote.json";

    // Method to write a JSON string to the file
    public static void write(String jsonString) {
        try (FileWriter writer = new FileWriter(new File(FILE_PATH))) {
            writer.write(jsonString);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read the JSON string from the file
    public static String read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_PATH)))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            // Read each line from the file and append it to the StringBuilder
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            // Return the JSON string as a String
            return stringBuilder.toString();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return null;
    }

}
