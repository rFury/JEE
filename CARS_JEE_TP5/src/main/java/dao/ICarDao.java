package dao;

import java.util.List;

import metier.Car;

public interface ICarDao {
    public Car save(Car p);
    public List<Car> carsByModel(String mc);
    public Car getCar(Long id);
    public Car updateCar(Car p);
    public void deleteCar(Long id);
}