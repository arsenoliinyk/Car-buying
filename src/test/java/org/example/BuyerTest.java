package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuyerTest {

    @Test
    public void testGetRemainingCash() throws IOException {
        //Arrange
        List<Car> carList = CsvParser.loadCsvData("testCarList.csv", new Car());
        Buyer buyer = new Buyer(30000);
        buyer.buyListOfCars(carList);

        //Act
        int actualResult = buyer.getCash();
        int expectedResult = 1200;

        //Assert
        assertEquals(expectedResult, actualResult);
    }

}