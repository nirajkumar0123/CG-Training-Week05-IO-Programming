package org.ioprogramming.csvdatahandling.advancedproblems.csvdataintojavaobjects;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.util.List;

public class CSVDataIntoObjects {
    public static void main(String[] args) {
        String csvFile = "src/main/java/org/ioprogramming/csvdatahandling/advancedproblems/csvdataintojavaobjects/student.csv";
        try{
            FileReader reader = new FileReader(csvFile);
            CsvToBean<Student> csvToBean = new CsvToBeanBuilder<Student>(reader)
                    .withType(Student.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Student> students = csvToBean.parse();

            for(Student stu : students){
                System.out.println(stu.getID() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t"  + stu.getMarks());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
