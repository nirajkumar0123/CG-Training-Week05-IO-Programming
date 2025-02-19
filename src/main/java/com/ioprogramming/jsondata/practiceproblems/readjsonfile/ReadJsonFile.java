package com.ioprogramming.jsondata.practiceproblems.readjsonfile;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;

public class ReadJsonFile {
    public static void main(String[] args) {
        String path = "src/main/resources/data.json";
        try {
            FileReader reader = new FileReader(path);

            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

            String name = jsonObject.get("name").getAsString();
            String email = jsonObject.get("email").getAsString();

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
