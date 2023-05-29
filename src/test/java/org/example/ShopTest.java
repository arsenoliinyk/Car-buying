package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

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
        List<Car> actualResult = Shop.sortCarsInAscendingOrder(carList);
        List<Car> expectedResult =  new ArrayList<Car>();
        expectedResult.add(car2);
        expectedResult.add(car3);
        expectedResult.add(car4);
        expectedResult.add(car1);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSortCarsWithNullYearValueInAscendingOrder() {
        //Arrange
        List<Car> carList = new ArrayList<Car>();
        Car car1 = new Car(7,"nissan","VAN",6100);
        Car car2 = new Car(11,"honda","PASS",3400);
        Car car3 = new Car(12,"honda","VAN",6100, 2020);
        Car car4 = new Car(13,"honda","TRUCK",4000);
        Car car5 = new Car(1,"ford","TRUCK",4000, 2010);
        Car car6 = new Car(9,"mazda","PASS",3400, 2015);
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
        carList.add(car6);

        //Act
        List<Car> actualResult = Shop.sortCarsInAscendingOrder(carList);
        List<Car> expectedResult =  new ArrayList<Car>();
        expectedResult.add(car6);
        expectedResult.add(car2);
        expectedResult.add(car5);
        expectedResult.add(car4);
        expectedResult.add(car3);
        expectedResult.add(car1);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetListOfTruckCars() throws IOException {
        //Arrange
        String filepath = "testCarList.csv";
        List<Car> carList = CsvParser.loadCsvData(filepath, new Car());

        //Act
        List<Car> actualResult = Shop.getListOfCarsWithExactType(carList, "TRUCK");
        List<Car> expectedResult = new ArrayList<>();
        expectedResult.add(new Car(1,"ford","TRUCK",4000));
        expectedResult.add(new Car(18,"ford","TRUCK",7800));
        expectedResult.add(new Car(17,"toyota","TRUCK",7700));
        expectedResult.add(new Car(5,"nissan","TRUCK",3100));

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetListOfVanCars() throws IOException {
        //Arrange
        String filepath = "testCarList.csv";
        List<Car> carList = CsvParser.loadCsvData(filepath, new Car());

        //Act
        List<Car> actualResult = Shop.getListOfCarsWithExactType(carList, "VAN");
        List<Car> expectedResult = new ArrayList<>();
        expectedResult.add(new Car(7,"nissan","VAN",6100));
        expectedResult.add(new Car(3,"ford","VAN",4100));
        expectedResult.add(new Car(15,"toyota","VAN",3000));

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetListOfPassCars() throws IOException {
        //Arrange
        String filepath = "testCarList.csv";
        List<Car> carList = CsvParser.loadCsvData(filepath, new Car());

        //Act
        List<Car> actualResult = Shop.getListOfCarsWithExactType(carList, "PASS");
        List<Car> expectedResult = new ArrayList<>();
        expectedResult.add(new Car(11,"honda","PASS",3400));
        expectedResult.add(new Car(9,"mazda","PASS",5100));
        expectedResult.add(new Car(2,"nissan","PASS",3500));

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetNumberOfTrucksOnSale() throws IOException {
        //Arrange
        String filepath = "testCarList.csv";
        List<Car> carList = CsvParser.loadCsvData(filepath, new Car());

        //Act
        Integer actualResult = Shop.getNumberOfCarsWithExactTypeOnSale(carList, "TRUCK");
        Integer expectedResult = 4;

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetNumberOfVanOnSale() throws IOException {
        //Arrange
        String filepath = "testCarList.csv";
        List<Car> carList = CsvParser.loadCsvData(filepath, new Car());

        //Act
        Integer actualResult = Shop.getNumberOfCarsWithExactTypeOnSale(carList, "VAN");
        Integer expectedResult = 3;

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetNumberOfPassOnSale() throws IOException {
        //Arrange
        String filepath = "testCarList.csv";
        List<Car> carList = CsvParser.loadCsvData(filepath, new Car());

        //Act
        Integer actualResult = Shop.getNumberOfCarsWithExactTypeOnSale(carList, "PASS");
        Integer expectedResult = 3;

        //Assert
        assertEquals(expectedResult, actualResult);
    }


}