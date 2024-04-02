package dao;

import java.util.List;

import metier.Car;

public class TestDao {
    public static void main(String[] args) {
        CarDaoImpl carDao = new CarDaoImpl();
        Car car = carDao.save(new Car("Toyota","Camry", 35000));
        System.out.println(car);

        List<Car> cars = carDao.carsByModel("X5M");
        for (Car c : cars)
            System.out.println(c);
    }
}
