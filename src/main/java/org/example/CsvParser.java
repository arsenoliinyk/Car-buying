package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.nio.charset.Charset.defaultCharset;

public class CsvParser {

    private CsvParser() {
    }

    public static <T extends CustomCloneable & CsvReadableInterface<T>> List<T> loadCsvData(String filePath, T obj)
            throws IOException {

        CSVParser csvParser = CSVParser.parse(Path.of(filePath), defaultCharset(), CSVFormat.DEFAULT.withHeader(obj.csvHeaders()));

        return StreamSupport
                .stream(csvParser.spliterator(), false)
                .skip(1)
                .map(CSVRecord::toMap)
                .map(csvData -> {
                    obj.fillObjectFromCsvData(obj, csvData);
                    try {
                        return (T) obj.clone();
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList());
    }
}
