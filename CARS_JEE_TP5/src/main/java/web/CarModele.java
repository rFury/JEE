package web;

import java.util.ArrayList;
import java.util.List;

import metier.Car;

public class CarModele {
    private String motCle;
    private List<Car> cars = new ArrayList<>();

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
