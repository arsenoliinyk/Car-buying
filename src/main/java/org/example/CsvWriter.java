package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CsvWriter {

    public <T extends CustomCloneable & CsvReadableInterface<T>> void write(List<T> objList, T obj){

    String csvFilePath = "sortedCarList.csv";

        try (FileWriter writer = new FileWriter(csvFilePath)) {
        // Write CSV header
        writer.write(String.join(",", obj.csvHeaders()) + "\n");

        // Write data for each object
        for (T object : objList) {
            String line = object.getData(object);
            writer.write(line);
        }

        System.out.println("CSV file created successfully.");
    } catch (
    IOException e) {
        System.out.println("Error writing to CSV file: " + e.getMessage());
    }
}

}
