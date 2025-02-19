package org.ioprogramming.csvdatahandling.advancedproblems.generatecsvreport;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class GenerateCSVReport {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";
        String csvFile = "src/main/java/org/ioprogramming/csvdatahandling/advancedproblems/generatecsvreport/employees.csv";

        String query = "SELECT id, name, department, salary FROM employees";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {

            // Write header
            writer.writeNext(new String[]{"Employee ID", "Name", "Department", "Salary"});

            // Write data
            while (rs.next()) {
                String[] row = {
                        String.valueOf(rs.getInt("id")),
                        rs.getString("name"),
                        rs.getString("department"),
                        String.valueOf(rs.getDouble("salary"))
                };
                writer.writeNext(row);
            }

            System.out.println("CSV file created successfully: " + csvFile);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
