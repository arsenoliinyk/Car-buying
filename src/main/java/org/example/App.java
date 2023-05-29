package org.example;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {

        List<Car> carList = CsvParser.loadCsvData(Car.getFilePath(), new Car());
        System.out.println(carList);
        Buyer buyer = new Buyer(5000);
        System.out.println("Bought cars: " + buyer.buyListOfCars(carList));
        System.out.println("Remaining cash: " + buyer.getCash());

    }

}