package org.ioprogramming.csvdatahandling.intermediateproblems.sortcsvrecords;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortCSVRecordsByCol {
    public static void main(String[] args) {
        String csvFile = "src/main/java/org/ioprogramming/csvdatahandling/intermediateproblems/sortcsvrecords/employees.csv";

        List<String[]> records = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            reader.readNext();
            String[] line;
            while ((line = reader.readNext()) != null) {
                records.add(line);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        Collections.sort(records, (o1, o2) -> {
            int salary1 = Integer.parseInt(o1[3]);
            int salary2 = Integer.parseInt(o2[3]);
            return Integer.compare(salary2, salary1);
        });

        for (int i = 0; i < 5 && i < records.size(); i++) {
            String[] record = records.get(i);
            System.out.println(record[0] + "\t" + record[1] + "\t" + record[2] + "\t" + record[3]);
        }

    }
}
