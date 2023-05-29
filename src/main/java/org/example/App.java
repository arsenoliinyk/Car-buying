package org.example;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {

        List<Car> carList = CsvParser.loadCsvData(Car.getFilePath(), new Car());
        System.out.println(carList);
        System.out.println("Bought cars: " + Buyer.buyingProcess(carList));
        System.out.println("Bought cars: " + Buyer.getNumberOfBoughtCars());
        System.out.println("Remaining cash: " + Buyer.getRemainingCash());

    }
}