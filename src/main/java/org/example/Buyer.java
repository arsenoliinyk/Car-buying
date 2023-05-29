package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Buyer {

    int cash;
    final static int trucksToBuy = 3;
    final static int vansToBuy = 2;

    public Buyer(int cash) {
        this.cash = cash;
    }

    public ArrayList<Integer> buyListOfCars(List<Car> carList) {

        List<Car> sortedCarsList = Shop.sortCarsInAscendingOrder(carList);
        return buyCheapest(sortedCarsList);

    }

    private ArrayList<Integer> buyCheapest(List<Car> carList) {

        ArrayList<Integer> boughtTrucksIds = Shop.buyCheapestCarsWithExactType(this, carList,"TRUCK");
        ArrayList<Integer> boughtVansIds = Shop.buyCheapestCarsWithExactType(this, carList,"VAN");
        ArrayList<Integer> boughtPassIds = Shop.buyCheapestCarsWithExactType(this, carList,"PASS");

        return Stream.of(boughtTrucksIds, boughtVansIds, boughtPassIds)
                .flatMap(Collection::stream)
                .collect(Collectors
                        .toCollection(ArrayList::new));

    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
