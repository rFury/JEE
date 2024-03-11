package Test;

import DAO.CarsDAO;
import Entities.Cars;

public class CarsTest {
    public static void main(String[] args) {
        // Create a Cars object
        Cars car = new Cars("X5M", "DMW", 120000);
        
        CarsDAO carsDao = new CarsDAO();
        carsDao.ajouter(car);
        
        System.out.println("listerTous method");
        for (Cars c : carsDao.listerTous()) {
            System.out.println(c.getCarID() + " " + c.getCarModel() + " " + c.getCarBrand());
        }
        
        System.out.println("listerParModel 'Model X' method");
        for (Cars c : carsDao.listerParModel("Model X")) {
            System.out.println(c.getCarID() + " " + c.getCarModel() + " " + c.getCarBrand());
        }
        
        System.out.println("listerParBrand 'Porsche' method");
        for (Cars c : carsDao.listerParBrand("Porsche")) {
            System.out.println(c.getCarID() + " " + c.getCarModel() + " " + c.getCarBrand());
        }
        
        
        // Test other methods of the CarsDao class
    }
}
