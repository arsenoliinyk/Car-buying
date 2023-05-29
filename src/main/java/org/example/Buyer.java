package org.example;

import java.util.ArrayList;
import java.util.List;

public class Buyer {

    int cash;
    final static int trucksToBuy = 3;
    final static int vansToBuy = 2;

    public Buyer(int cash) {
        this.cash = cash;
    }

    public ArrayList<Integer> buyListOfCars(Buyer buyer, List<Car> carList) {
        ArrayList<Integer> boughtCarIds = new ArrayList<>();
        List<Car> sortedCarsList = Shop.sortCarsInAscendingOrder(carList);
        return buyCheapest(buyer, sortedCarsList, boughtCarIds);
    }

    private ArrayList<Integer> buyCheapest(Buyer buyer, List<Car> carList, ArrayList<Integer> boughtCarIds) {

        Shop.buyCheapestCarsWithExactType(buyer, carList, boughtCarIds, "TRUCK");
        Shop.buyCheapestCarsWithExactType(buyer, carList, boughtCarIds, "VAN");
        Shop.buyCheapestCarsWithExactType(buyer, carList, boughtCarIds, "PASS");

        return boughtCarIds;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
