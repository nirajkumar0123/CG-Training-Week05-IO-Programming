package org.ioprogramming.csvdatahandling.intermediateproblems.searchforarecordincsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchForRecordInCSVFile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the employee to search: ");
        String name = input.nextLine();
        boolean found = false;
        String csvFile = "src/main/java/org/ioprogramming/csvdatahandling/intermediateproblems/searchforarecordincsv/employees.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            reader.readNext();
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line[1].equals(name)) {
                    System.out.println("Department: " + line[2] + ", Salary: " + line[3]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("No employee found with the name: " + name);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
