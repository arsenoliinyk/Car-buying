package org.example;

import java.util.Map;

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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String[] csvHeaders() {
        return new String[]{"car_id", "car_make", "car_type", "car_price"};
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

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(int carPrice) {
        this.carPrice = carPrice;
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

}