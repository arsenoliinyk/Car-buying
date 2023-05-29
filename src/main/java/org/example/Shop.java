package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.example.Buyer.*;

public class Shop {

    public static List<Car> sortCarsInAscendingOrder(List<Car> carList) {
        carList.sort(Comparator.comparing(Car::getCarPrice));
        return carList;
    }

    static void buyCheapestCarsWithExactType(Buyer buyer, List<Car> carList, ArrayList<Integer> boughtCarIds, String carType) {
        int exactCarTypeToBuy = matchCarTypeWithNeededNumberToBuy(buyer, carList, carType);
        List<Car> carListWithExactType = getListOfCarsWithExactType(carList, carType);
        if (exactCarTypeToBuy <= carListWithExactType.size()){
            for (Car car : carListWithExactType) {
                if (exactCarTypeToBuy > 0 ){
                    if (car.getCarPrice() <= buyer.getCash()){
                        buyer.setCash(buyer.getCash() - car.getCarPrice());
                        boughtCarIds.add(car.getCarId());
                        exactCarTypeToBuy--;
                    }else{
                        throw new RuntimeException("We ran out of money when buying " + carType + " cars. " +
                                "The car’s price is " + car.getCarPrice() + " and we have only " +
                                buyer.getCash() + " left.");
                    }
                }
            }
        } else {
            throw new RuntimeException("There were not enough " + carType + " cars on sale. " +
                    "Required " + exactCarTypeToBuy +" "+ carType + ", but there are only " +
                    getNumberOfCarsWithExactTypeOnSale(carList, carType) + " for sale.");
        }
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
        for (Car car : carList){
            if (car.getCarType().equals(carType)){
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
                int price = buyer.getCash() / getCheapestCarPriceForType(carList, carType);
                exactCarTypeToBuy = Math.max(1, price);
                break;
        }
        return exactCarTypeToBuy;
    }

    private static int getCheapestCarPriceForType(List<Car> carList, String carType) {
        List<Car> carListWithExactType = getListOfCarsWithExactType(carList, carType);
        if (!carListWithExactType.isEmpty()) {
            return carListWithExactType.get(0).getCarPrice();
        } else {
            return Integer.MAX_VALUE;
        }
    }
}