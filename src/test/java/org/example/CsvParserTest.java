package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvParserTest {
    @Test
    public void testLoadCsvData() throws IOException {
        //Arrange
        String filepath = "testCsv.csv";
        //Act
        List<Car> actualResult = CsvParser.loadCsvData(filepath, new Car());
        List<Car> expectedResult =  new ArrayList<>();
        expectedResult.add(new Car(7,"nissan","VAN",6100));
        expectedResult.add(new Car(11,"honda","PASS",3400));
        //Assert
        assertEquals(expectedResult, actualResult);
    }
}