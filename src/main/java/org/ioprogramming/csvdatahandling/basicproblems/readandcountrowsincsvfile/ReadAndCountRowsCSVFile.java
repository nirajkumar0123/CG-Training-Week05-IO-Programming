package org.ioprogramming.csvdatahandling.basicproblems.readandcountrowsincsvfile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class ReadAndCountRowsCSVFile {
    public static void main(String[] args) {
        String csvFile = "src/main/java/org/ioprogramming/csvdatahandling/basicproblems/readandcountrowsincsvfile/student.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            reader.readNext();
            int rowCount = 0;
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line.length > 0) {
                    rowCount++;
                }
            }

            System.out.println("Total rows (excluding header): " + rowCount);
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
