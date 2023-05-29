package org.example;

import java.util.Map;
import java.util.Objects;

public class Car extends CustomCloneable implements CsvReadableInterface<Car> {

    private static final String filePath = "carListNew.csv";
    private int carId;
    private String carMake;
    private String carType;
    private int carPrice;
    private Integer carYear;

    public Car() {
    }

    public Car(int carId, String carMake, String carType, int carPrice) {
        this.carId = carId;
        this.carMake = carMake;
        this.carType = carType;
        this.carPrice = carPrice;
        this.carYear = null;
    }

    public Car(int carId, String carMake, String carType, int carPrice, Integer carYear) {
        this.carId = carId;
        this.carMake = carMake;
        this.carType = carType;
        this.carPrice = carPrice;
        this.carYear = carYear;
    }

    public static String getFilePath() {
        return filePath;
    }

    public String[] csvHeaders() {
        return new String[]{"car_id", "car_make", "car_type", "car_price", "car_year"};
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
        String carYearValue = row.get("car_year");
        car.carYear = carYearValue.isEmpty() || carYearValue.equals("null") ? null : Integer.parseInt(carYearValue);
        return car;
    }

    public int getCarId() {
        return carId;
    }

    public String getCarMake() {
        return carMake;
    }

    public String getCarType() {
        return carType;
    }

    public int getCarPrice() {
        return carPrice;
    }

    public Integer getCarYear() {
        return carYear;
    }

    public String getData (Car car) {
        return car.getCarId() + ","
                + car.getCarMake() + ","
                + car.getCarType() + ","
                + car.getCarPrice() + ","
                + car.getCarYear() + "\n";
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carMake='" + carMake + '\'' +
                ", carType='" + carType + '\'' +
                ", carPrice=" + carPrice + '\'' +
                ", carYear=" + carYear +
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
                Objects.equals(carYear, car.carYear) &&
                Objects.equals(carMake, car.carMake) &&
                Objects.equals(carType, car.carType);
    }

}
