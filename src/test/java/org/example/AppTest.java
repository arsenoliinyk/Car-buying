package org.example;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest{

   @Test
    public void testApp() throws IOException {
       //Arrange
       String filepath = "carList.csv";
       List<Car> carList = CsvParser.loadCsvData(filepath, new Car());

       //Act
       ArrayList<Integer> actualResult = Buyer.buyingProcess(carList);
       ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(5, 1, 17, 15, 3, 11, 2));

       //Assert
       assertEquals(expectedResult, actualResult);

   }
}