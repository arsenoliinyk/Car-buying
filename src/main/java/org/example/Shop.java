package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.example.Buyer.*;

public class Shop {

    public static List<Car> sortCarsInAscendingOrder(List<Car> carList) {

        carList.sort(
                Comparator.comparing(Car::getCarPrice)
                        .thenComparing(
                                Car::getCarYear, Comparator.nullsLast(Comparator.reverseOrder()))
        );

        return carList;

    }

    static ArrayList<Integer> buyCheapestCarsWithExactType(Buyer buyer, List<Car> carList, String carType) {

        int exactCarTypeToBuy = matchCarTypeWithNeededNumberToBuy(buyer, carList, carType);
        ArrayList<Integer> boughtCarIds = new ArrayList<>();
        List<Car> carListWithExactType = getListOfCarsWithExactType(carList, carType);
        if (exactCarTypeToBuy <= carListWithExactType.size()) {
            for (Car car : carListWithExactType) {
                if (exactCarTypeToBuy > 0) {
                    if (car.getCarPrice() <= buyer.getCash()) {
                        buyer.setCash(buyer.getCash() - car.getCarPrice());
                        boughtCarIds.add(car.getCarId());
                        exactCarTypeToBuy--;
                    } else {
                        throw new RuntimeException(String.format("We ran out of money when buying %s cars. " +
                                "The car’s price is %d and we have only %d left.",
                                carType, car.getCarPrice(), buyer.getCash()));
                    }
                }
            }
        } else {
            throw new RuntimeException(String.format("There were not enough %s cars on sale. " +
                    "Required %d %s, but there are only %d for sale.",
                    carType, exactCarTypeToBuy, carType, getNumberOfCarsWithExactTypeOnSale(carList, carType)));

        }
        return boughtCarIds;

    }

    public static List<Car> getListOfCarsWithExactType(List<Car> carList, String carType) {

        List<Car> carListWithExactType = new ArrayList<>();
        for (Car car : carList) {
            if (car.getCarType().equals(carType)) {
                carListWithExactType.add(car);
            }
        }
        return carListWithExactType;

    }

    public static int getNumberOfCarsWithExactTypeOnSale(List<Car> carList, String carType) {

        int carCounter = 0;
        for (Car car : carList) {
            if (car.getCarType().equals(carType)) {
                carCounter++;
            }
        }
        return carCounter;

    }

    private static int matchCarTypeWithNeededNumberToBuy(Buyer buyer, List<Car> carList, String carType) {

        int exactCarTypeToBuy = 0;
        switch (carType) {
            case "TRUCK":
                exactCarTypeToBuy = trucksToBuy;
                break;
            case "VAN":
                exactCarTypeToBuy = vansToBuy;
                break;
            case "PASS":
                int numberCarsToBuy = getAffordedNumberCarsToBuy(buyer, carList, carType);
                exactCarTypeToBuy = Math.max(1, numberCarsToBuy);
                break;
        }
        return exactCarTypeToBuy;

    }

    private static int getAffordedNumberCarsToBuy(Buyer buyer, List<Car> carList, String carType) {

        List<Car> carListWithExactType = getListOfCarsWithExactType(carList, carType);
        int temporaryCash = buyer.getCash();
        int canAffordCarsToBuy = 0;
        if (!carListWithExactType.isEmpty()) {
            for (Car car : carListWithExactType) {
                if (temporaryCash >= car.getCarPrice()) {
                    temporaryCash -= car.getCarPrice();
                    canAffordCarsToBuy++;
                } else{
                    return canAffordCarsToBuy;
                }
            }
        } else {
            return 0;
        }
        return canAffordCarsToBuy;
    }

}
