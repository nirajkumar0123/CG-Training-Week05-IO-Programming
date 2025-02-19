package com.ioprogramming.jsondata.practiceproblems.validatejson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;

public class ValidateJSON {
    public static void main(String[] args) {
        String filePath = "src/main/resources/data.json";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            FileReader reader = new FileReader(filePath);
            JsonNode jsonNode = objectMapper.readTree(reader);

            // JSON is valid
            System.out.println("Valid JSON structure!");
            System.out.println(jsonNode.toPrettyString());

        } catch (IOException e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}
