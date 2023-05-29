package org.example;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {

        List<Car> carList = CsvParser.loadCsvData(Car.getFilePath(), new Car());
        System.out.println(carList);

        Shop.sortCarsInAscendingOrder(carList);

        CsvWriter csvWriter = new CsvWriter();
        csvWriter.write(carList, new Car());

        Buyer buyer = new Buyer(30000);
        System.out.println("Bought cars: " + buyer.buyListOfCars(carList));
        System.out.println("Remaining cash: " + buyer.getCash());

    }

}