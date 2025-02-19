package org.ioprogramming.csvdatahandling.basicproblems.readcsvfile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class ReadAndPrintCSVFile {
    public static void main(String[] args) {
        String csvFile = "src/main/java/org/ioprogramming/csvdatahandling/basicproblems/readcsvfile/student.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                System.out.println("Id: " + line[0] + ", Name: " + line[1] + ", Age: " + line[2] + ", Marks: " + line[3]);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
