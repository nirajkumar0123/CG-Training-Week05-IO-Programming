package com.ioprogramming.jsondata.handsonpracticeproblems.filterjsondata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilterJsonData {
    public static void main(String[] args) {
        String filePath = "src/main/resources/json_array.json";

        try (FileReader reader = new FileReader(filePath)) {
            ObjectMapper objectMapper = new ObjectMapper();

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
