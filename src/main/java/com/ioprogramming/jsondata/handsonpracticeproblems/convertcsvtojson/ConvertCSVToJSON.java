package com.ioprogramming.jsondata.handsonpracticeproblems.convertcsvtojson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class ConvertCSVToJSON {
    public static void main(String[] args) {
        try {
            String csvData = Files.readString(Paths.get("src/main/resources/data.csv")).trim();
            String[] lines = csvData.split("\n");

            if (lines.length < 2) {
                System.out.println("Error: CSV file must contain at least one data row.");
                return;
            }

            String[] headers = lines[0].split(",");
            JSONArray jsonArray = new JSONArray();

            for (int i = 1; i < lines.length; i++) {
                String[] values = lines[i].split(",");
                JSONObject jsonObject = new JSONObject();
                for (int j = 0; j < headers.length; j++) {
                    jsonObject.put(headers[j].trim(), values[j].trim());
                }
                jsonArray.put(jsonObject);
            }

            System.out.println(jsonArray.toString(4));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

