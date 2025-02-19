package com.ioprogramming.jsondata.handsonpracticeproblems.csvreportfromdatabase;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.*;
import java.util.*;

public class JSONReportGenerator {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "root";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM your_table")) {

            List<Map<String, Object>> records = new ArrayList<>();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(metaData.getColumnName(i), rs.getObject(i));
                }
                records.add(row);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonReport = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(records);
            System.out.println(jsonReport);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
