package org.example;

import java.util.Map;
import java.util.Objects;

public class Car extends CustomCloneable implements CsvReadableInterface<Car> {

    private static final String filePath = "carList.csv";
    private int carId;
    private String carMake;
    private String carType;
    private int carPrice;

    public Car() {
    }

    public Car(int carId, String carMake, String carType, int carPrice) {
        this.carId = carId;
        this.carMake = carMake;
        this.carType = carType;
        this.carPrice = carPrice;
    }

    public static String getFilePath() {
        return filePath;
    }

    public String[] csvHeaders() {
        return new String[]{"car_id", "car_make", "car_type", "car_price"};
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Car fillObjectFromCsvData(Car car, Map<String, String> row) {
        car.carId = Integer.parseInt(row.get("car_id"));
        car.carMake = row.get("car_make");
        car.carType = row.get("car_type");
        car.carPrice = Integer.parseInt(row.get("car_price"));
        return car;
    }

    public int getCarId() {
        return carId;
    }

    public String getCarType() {
        return carType;
    }

    public int getCarPrice() {
        return carPrice;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carMake='" + carMake + '\'' +
                ", carType='" + carType + '\'' +
                ", carPrice=" + carPrice +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return carId == car.carId &&
                carPrice == car.carPrice &&
                Objects.equals(carMake, car.carMake) &&
                Objects.equals(carType, car.carType);
    }

}