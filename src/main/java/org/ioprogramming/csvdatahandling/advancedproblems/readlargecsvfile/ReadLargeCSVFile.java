package org.ioprogramming.csvdatahandling.advancedproblems.readlargecsvfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeCSVFile {
    public static void main(String[] args) {
        String csvFile = "src/main/java/org/ioprogramming/csvdatahandling/advancedproblems/readlargecsvfile/large_file.csv";
        int batchSize = 100;
        int totalRecordsProcessed = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {
                count++;
                totalRecordsProcessed++;

                if (count == batchSize) {
                    System.out.println("Processed " + totalRecordsProcessed + " records...");
                    count = 0;
                }
            }

            System.out.println("Total Records Processed: " + totalRecordsProcessed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

