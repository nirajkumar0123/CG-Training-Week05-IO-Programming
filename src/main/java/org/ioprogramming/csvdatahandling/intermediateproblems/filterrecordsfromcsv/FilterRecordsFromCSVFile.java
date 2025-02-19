package org.ioprogramming.csvdatahandling.intermediateproblems.filterrecordsfromcsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class FilterRecordsFromCSVFile {
    public static void main(String[] args) {
        String csvFile = "src/main/java/org/ioprogramming/csvdatahandling/intermediateproblems/filterrecordsfromcsv/student.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            reader.readNext();
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (Integer.parseInt(line[3]) > 80) {
                    System.out.println("Id: " + line[0] + ", Name: " + line[1] + ", Age: " + line[2] + ", Marks: " + line[3]);
                }
            }
        } catch (IOException | CsvValidationException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
