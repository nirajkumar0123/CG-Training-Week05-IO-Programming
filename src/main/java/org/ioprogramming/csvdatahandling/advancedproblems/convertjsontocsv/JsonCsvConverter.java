package org.ioprogramming.csvdatahandling.advancedproblems.convertjsontocsv;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonCsvConverter {
    // Convert JSON to CSV
    public static void jsonToCsv(String jsonFile, String csvFile) {
        try {
            // Reading JSON from file
            JSONArray jsonArray = new JSONArray(new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(jsonFile))));

            // Writing CSV to file
            FileWriter writer = new FileWriter(csvFile);
            // Writing header
            writer.append("id,name,age,marks\n");

            // Writing records
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject student = jsonArray.getJSONObject(i);
                writer.append(student.getInt("id") + "," +
                        student.getString("name") + "," +
                        student.getInt("age") + "," +
                        student.getInt("marks") + "\n");
            }
            writer.flush();
            writer.close();
            System.out.println("CSV file created successfully from JSON!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Convert CSV to JSON
    public static void csvToJson(String csvFile, String jsonFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            JSONArray jsonArray = new JSONArray();
            // Skip header line
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                JSONObject student = new JSONObject();
                student.put("id", Integer.parseInt(fields[0]));
                student.put("name", fields[1]);
                student.put("age", Integer.parseInt(fields[2]));
                student.put("marks", Integer.parseInt(fields[3]));
                jsonArray.put(student);
            }

            // Save JSON to file
            java.nio.file.Files.write(java.nio.file.Paths.get(jsonFile), jsonArray.toString(4).getBytes());
            System.out.println("JSON file created successfully from CSV!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String jsonFile = "src/main/java/org/ioprogramming/csvdatahandling/advancedproblems/convertjsontocsv/students.json";
        String csvFile = "src/main/java/org/ioprogramming/csvdatahandling/advancedproblems/convertjsontocsv/students.csv";

        // Convert JSON to CSV
        jsonToCsv(jsonFile, csvFile);

        // Convert CSV to JSON
        csvToJson(csvFile, "src/main/java/org/ioprogramming/csvdatahandling/advancedproblems/convertjsontocsv/converted_students.json");
    }
}

