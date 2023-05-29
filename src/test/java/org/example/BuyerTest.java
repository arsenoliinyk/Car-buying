package org.example;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest{

   @Test
    public void testApp() throws IOException {
       //Arrange
       String filepath = "testCarList.csv";
       List<Car> carList = CsvParser.loadCsvData(filepath, new Car());
       Buyer buyer = new Buyer(30000);

       //Act
       ArrayList<Integer> actualResult = buyer.buyListOfCars(buyer, carList);
       ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(5, 1, 17, 15, 3, 11, 2));

       //Assert
       assertEquals(expectedResult, actualResult);

   }

   @Test
   public void testAppNotEnoughTrucksOnSale() throws IOException {
      //Arrange
      String filepath = "testCarListNotEnoughTrucks.csv";
      List<Car> carList = CsvParser.loadCsvData(filepath, new Car());
      Buyer buyer = new Buyer(30000);
      RuntimeException expectedException = assertThrows(RuntimeException.class, () -> {
         buyer.buyListOfCars(buyer, carList);
      });

      //Act
      String actualResult = expectedException.getMessage();
      String expectedResult = "There were not enough TRUCK cars on sale. Required 3 TRUCK, but there are only 2 for sale.";

      //Assert
      assertTrue(actualResult.contains(expectedResult));

   }

   @Test
   public void testAppNotEnoughVansOnSale() throws IOException {
      //Arrange
      String filepath = "testCarListNotEnoughVans.csv";
      List<Car> carList = CsvParser.loadCsvData(filepath, new Car());
      Buyer buyer = new Buyer(30000);
      RuntimeException expectedException = assertThrows(RuntimeException.class, () -> {
         buyer.buyListOfCars(buyer, carList);
      });

      //Act
      String actualResult = expectedException.getMessage();
      String expectedResult = "There were not enough VAN cars on sale. Required 2 VAN, but there are only 0 for sale.";

      //Assert
      assertTrue(actualResult.contains(expectedResult));

   }

   @Test
   public void testAppNotEnoughPassOnSale() throws IOException {
      //Arrange
      String filepath = "testCarListNotEnoughPass.csv";
      List<Car> carList = CsvParser.loadCsvData(filepath, new Car());
      Buyer buyer = new Buyer(30000);
      RuntimeException expectedException = assertThrows(RuntimeException.class, () -> {
         buyer.buyListOfCars(buyer, carList);
      });

      //Act
      String actualResult = expectedException.getMessage();
      String expectedResult = "There were not enough PASS cars on sale. Required 1 PASS, but there are only 0 for sale.";

      //Assert
      assertTrue(actualResult.contains(expectedResult));

   }

   @Test
   public void testAppNotEnoughCashForTrucks() throws IOException {
      //Arrange
      String filepath = "testCarList.csv";
      List<Car> carList = CsvParser.loadCsvData(filepath, new Car());
      Buyer buyer = new Buyer(14500);
      RuntimeException expectedException = assertThrows(RuntimeException.class, () -> {
         buyer.buyListOfCars(buyer, carList);
      });

      //Act
      String actualResult = expectedException.getMessage();
      String expectedResult = "We ran out of money when buying TRUCK cars. The car’s price is 7700 and we have only 7400 left.";

      //Assert
      assertTrue(actualResult.contains(expectedResult));

   }

   @Test
   public void testAppNotEnoughCashForVans() throws IOException {
      //Arrange
      String filepath = "testCarList.csv";
      List<Car> carList = CsvParser.loadCsvData(filepath, new Car());
      Buyer buyer = new Buyer(21500);
      RuntimeException expectedException = assertThrows(RuntimeException.class, () -> {
         buyer.buyListOfCars(buyer, carList);
      });

      //Act
      String actualResult = expectedException.getMessage();
      String expectedResult = "We ran out of money when buying VAN cars. The car’s price is 4100 and we have only 3700 left.";

      //Assert
      assertTrue(actualResult.contains(expectedResult));

   }

   @Test
   public void testAppNotEnoughCashForPass() throws IOException {
      //Arrange
      String filepath = "testCarList.csv";
      List<Car> carList = CsvParser.loadCsvData(filepath, new Car());
      Buyer buyer = new Buyer(23500);
      RuntimeException expectedException = assertThrows(RuntimeException.class, () -> {
         buyer.buyListOfCars(buyer, carList);
      });

      //Act
      String actualResult = expectedException.getMessage();
      String expectedResult = "We ran out of money when buying PASS cars. The car’s price is 3400 and we have only 1600 left.";

      //Assert
      assertTrue(actualResult.contains(expectedResult));

   }
}