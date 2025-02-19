package org.ioprogramming.csvdatahandling.advancedproblems.detectduplicatesincsvfile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class DetectDuplicatesInCSVFile {
    public static void main(String[] args) {
        String csvFile = "src/main/java/org/ioprogramming/csvdatahandling/advancedproblems/detectduplicatesincsvfile/students.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            HashSet<String> uniqueIds = new HashSet<>();
            reader.readNext();

            String[] line;
            while ((line = reader.readNext()) != null) {
                String id = line[0];

                if (!uniqueIds.add(id)) {
                    System.out.println("Duplicate record found: " + String.join(", ", line));
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
