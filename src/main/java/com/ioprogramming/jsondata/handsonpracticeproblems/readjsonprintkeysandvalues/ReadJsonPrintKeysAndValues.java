package com.ioprogramming.jsondata.handsonpracticeproblems.readjsonprintkeysandvalues;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;

public class ReadJsonPrintKeysAndValues {
    public static void main(String[] args) {
        String path = "src/main/resources/data.json";

        try (FileReader reader = new FileReader(path)) {
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

            for (String key : jsonObject.keySet()) {
                System.out.println(key + " : " + jsonObject.get(key));
            }

        } catch (Exception e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
        }
    }
}
