package com.ioprogramming.jsondata.practiceproblems.parsejson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseJson {
    public static void main(String[] args) {
        String path = "src/main/resources/json_array.json";

        try {

            // ObjectMapper parses JSON into Java objects.

            ObjectMapper objectMapper = new ObjectMapper();
            FileReader reader = new FileReader(path);

            // readTree(reader) reads the entire JSON file and returns a JsonNode.
            // rootArray now holds the entire JSON array.
            JsonNode rootArray = objectMapper.readTree(reader);

            List<JsonNode> filteredRecords = new ArrayList<>();
            for (JsonNode node : rootArray) {
                int age = node.get("age").asInt();

                // Check if age > 25
                if (age > 25) {
                    filteredRecords.add(node);
                }
            }

            for (JsonNode record : filteredRecords) {
                System.out.println(record.toPrettyString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
