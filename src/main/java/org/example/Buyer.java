package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Buyer {

    private static int cash = 30000;
    private static int numberOfBoughtCars;
    private static final int trucksToBuy = 3;
    private static final int vansToBuy = 2;

    public static ArrayList<Integer> buyingProcess(List<Car> carList) {
        ArrayList<Integer> boughtCarIds = new ArrayList<>();
        List<Car> sortedCarsList = sortCarsInAscendingOrder(carList);
        return buyingCheapest(sortedCarsList, boughtCarIds);
    }

    public static List<Car> sortCarsInAscendingOrder(List<Car> carList) {
        carList.sort(Comparator.comparing(Car::getCarPrice));
        return carList;
    }

    private static ArrayList<Integer> buyingCheapest(List<Car> carList, ArrayList<Integer> boughtCarIds) {
        buyingCheapestCarsWithExactType(carList, boughtCarIds, "TRUCK");
        buyingCheapestCarsWithExactType(carList, boughtCarIds, "VAN");
        buyingCheapestCarsWithExactType(carList, boughtCarIds, "PASS");
/*
        buyingCheapestCarsWithExactTypeTrucks(carList, boughtCarIds);
        buyingCheapestCarsWithExactTypeVans(carList, boughtCarIds);
        buyingCheapestCarsWithExactTypePass(carList, boughtCarIds);*/
        return boughtCarIds;
    }

    private static void buyingCheapestCarsWithExactType(List<Car> carList, ArrayList<Integer> boughtCarIds, String carType) {
        int exactCarTypeToBuy = matchingCarTypeWithNeededNumberToBuy(carType);
        for (Car car : carList) {
            if (car.getCarType().equals(carType)) {
                if (exactCarTypeToBuy > 0 && car.getCarPrice() <= cash) {
                    cash -= car.getCarPrice();
                    boughtCarIds.add(car.getCarId());
                    numberOfBoughtCars++;
                    exactCarTypeToBuy--;
                }
            }
        }
    }

    static int matchingCarTypeWithNeededNumberToBuy(String carType) {
        int exactCarTypeToBuy = 0;
        switch (carType) {
            case "TRUCK":
                exactCarTypeToBuy = trucksToBuy;
                break;
            case "VAN":
                exactCarTypeToBuy = vansToBuy;
                break;
            case "PASS":
                exactCarTypeToBuy = Integer.MAX_VALUE;
                break;
        }
        return exactCarTypeToBuy;
    }

    public static int getNumberOfBoughtCars() {
        return numberOfBoughtCars;
    }

    public static int getRemainingCash() {
        return cash;
    }
}
