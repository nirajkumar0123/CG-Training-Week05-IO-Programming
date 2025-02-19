package org.ioprogramming.csvdatahandling.advancedproblems.mergetwocsvfiles;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeTwoCSVFiles {
    public static void main(String[] args) {
        String file1 = "src/main/java/org/ioprogramming/csvdatahandling/advancedproblems/mergetwocsvfiles/students1.csv";
        String file2 = "src/main/java/org/ioprogramming/csvdatahandling/advancedproblems/mergetwocsvfiles/students2.csv";
        String outputFile = "src/main/java/org/ioprogramming/csvdatahandling/advancedproblems/mergetwocsvfiles/merged_students.csv";

        Map<String, String[]> studentData = new HashMap<>();

        try (CSVReader reader1 = new CSVReader(new FileReader(file1))) {
            reader1.readNext();
            String[] line;
            while ((line = reader1.readNext()) != null) {
                studentData.put(line[0], new String[]{line[1], line[2]});
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        try (CSVReader reader2 = new CSVReader(new FileReader(file2));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});
            reader2.readNext();
            String[] line;
            while ((line = reader2.readNext()) != null) {
                if (studentData.containsKey(line[0])) {
                    String[] studentInfo = studentData.get(line[0]);
                    writer.writeNext(new String[]{line[0], studentInfo[0], studentInfo[1], line[1], line[2]});
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
