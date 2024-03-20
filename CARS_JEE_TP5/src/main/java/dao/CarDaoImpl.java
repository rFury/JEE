package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.Car;
import Util.JPAutil;

public class CarDaoImpl implements ICarDao {
    private EntityManager entityManager = JPAutil.getEntityManager("CARS_JEE_2");

    @Override
    public Car save(Car car) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(car);
        tx.commit();
        return car;
    }

    @Override
    public List<Car> carsByModel(String mc) {
        List<Car> cars = entityManager.createQuery("select c from Car c where c.carModel like :mc")
                .setParameter("mc", "%" + mc + "%")
                .getResultList();
        return cars;
    }


    @Override
    public Car getCar(Long id) {
        return entityManager.find(Car.class, id);
    }

    @Override
    public Car updateCar(Car car) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(car);
        tx.commit();
        return car;
    }

    @Override
    public void deleteCar(Long id) {
        Car car = entityManager.find(Car.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(car);
        entityManager.getTransaction().commit();
    }
}
