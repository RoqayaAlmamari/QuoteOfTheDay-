package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class QuoteFileHandler {

    private static final String FILE_PATH = "quote.json";

    public static void write(String jsonString) {
        try (FileWriter writer = new FileWriter(new File(FILE_PATH))) {
            writer.write(jsonString);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static String read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_PATH)))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return null;
    }

}
