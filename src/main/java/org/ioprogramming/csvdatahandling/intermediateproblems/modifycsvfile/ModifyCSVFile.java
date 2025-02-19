package org.ioprogramming.csvdatahandling.intermediateproblems.modifycsvfile;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModifyCSVFile {
    public static void main(String[] args) {
        String csvFile = "src/main/java/org/ioprogramming/csvdatahandling/intermediateproblems/modifycsvfile/employees.csv";
        String newCSVFile = "src/main/java/org/ioprogramming/csvdatahandling/intermediateproblems/modifycsvfile/employeeupdated.csv";

        List<String[]> updatedRecords = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            reader.readNext();
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line[2].equals("IT")) {
                    int salary = Integer.parseInt(line[3]);
                    int newSalary = (int) (salary + 0.1 * salary);
                    line[3] = String.valueOf(newSalary);
                }
                updatedRecords.add(line);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(newCSVFile))) {
            String[] header = {"Id", "Name", "Department", "Salary"};

            writer.writeNext(header);
            writer.writeAll(updatedRecords);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Updated Records have been written to " + newCSVFile);
    }
}
