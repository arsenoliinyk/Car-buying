package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.Buyer.*;
import static org.junit.jupiter.api.Assertions.*;

class BuyerTest {

    @Test
    void testBuyingProcess() throws IOException {
        //Arrange
        List<Car> carList = CsvParser.loadCsvData(Car.getFilePath(), new Car());

        //Act
        ArrayList<Integer> actualResult = Buyer.buyingProcess(carList);
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(5, 1, 17, 15, 3, 11, 2));

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSortCarsInAscendingOrder() {
        //Arrange
        List<Car> carList = new ArrayList<Car>();
        Car car1 = new Car(7,"nissan","VAN",6100);
        Car car2 = new Car(11,"honda","PASS",3400);
        Car car3 = new Car(1,"ford","TRUCK",4000);
        Car car4 = new Car(9,"mazda","PASS",5100);
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);

        //Act
        List<Car> actualResult = Buyer.sortCarsInAscendingOrder(carList);
        List<Car> expectedResult =  new ArrayList<Car>();
        expectedResult.add(car2);
        expectedResult.add(car3);
        expectedResult.add(car4);
        expectedResult.add(car1);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMatchingTruckWithNeededNumberToBuy(){
        //Arrange
        int trucksToBuy = 3;

        //Act
        int actualResult = matchingCarTypeWithNeededNumberToBuy("TRUCK");
        int expectedResult = trucksToBuy;

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMatchingVansWithNeededNumberToBuy(){
        //Arrange
        int vansToBuy = 2;

        //Act
        int actualResult = matchingCarTypeWithNeededNumberToBuy("VAN");
        int expectedResult = vansToBuy;

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetNumberOfBoughtCars() throws IOException {
        List<Car> carList = CsvParser.loadCsvData(Car.getFilePath(), new Car());
        Buyer.buyingProcess(carList);

        //Act
        int actualResult = getNumberOfBoughtCars();
        int expectedResult = 7;

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetRemainingCash() throws IOException {
        //Arrange
        List<Car> carList = CsvParser.loadCsvData(Car.getFilePath(), new Car());
        Buyer.buyingProcess(carList);

        //Act
        int actualResult = getRemainingCash();
        int expectedResult = 1200;

        //Assert
        assertEquals(expectedResult, actualResult);
    }
}