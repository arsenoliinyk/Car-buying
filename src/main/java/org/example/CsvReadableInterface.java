package org.example;

import java.util.Map;

public interface CsvReadableInterface<T> {
    String[] csvHeaders();

    T fillObjectFromCsvData(T obj, Map<String, String> row);

}