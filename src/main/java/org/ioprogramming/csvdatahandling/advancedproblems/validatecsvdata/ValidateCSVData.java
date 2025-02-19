package org.ioprogramming.csvdatahandling.advancedproblems.validatecsvdata;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCSVData {
    public static void main(String[] args) {
        String csvFile = "src/main/java/org/ioprogramming/csvdatahandling/advancedproblems/validatecsvdata/employees.csv";

        String emailRegex = "^[a-zA-Z0-9-+._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern emailPattern = Pattern.compile(emailRegex);

        String phoneRegex = "^[0-9]{10}$";
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            reader.readNext();
            String[] line;
            while ((line = reader.readNext()) != null) {
                String email = line[3];
                String phone = line[4];

                Matcher emailMatcher = emailPattern.matcher(email);
                if (!emailMatcher.matches()) {
                    System.out.println("Invalid email format in row: " + String.join(",", line));
                }

                Matcher phoneMatcher = phonePattern.matcher(phone);
                if (!phoneMatcher.matches()) {
                    System.out.println("Invalid phone format in row: " + String.join(",", line));
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
