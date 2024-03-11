package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import Entities.Cars;
import Util.JPAutil;

public class CarsDAO {
    private EntityManager entityManager = JPAutil.getEntityManager("MonProjetJPA");

    public void ajouter(Cars car) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(car);
        tx.commit();
    }

    public void modifier(Cars car) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(car);
        tx.commit();
    }

    public void supprimer(Cars car) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        car = entityManager.merge(car); // important
        entityManager.remove(car);
        tx.commit();
    }

    public Cars consulter(Long carID) {
        return entityManager.find(Cars.class, carID);
    }

    public List<Cars> listerTous() {
        List<Cars> cars = entityManager.createQuery("select c from Cars c", Cars.class).getResultList();
        return cars;
    }

    public List<Cars> listerParModel(String carModel) {
        List<Cars> cars = entityManager.createQuery("select c from Cars c where c.carModel like :pmodel", Cars.class)
                .setParameter("pmodel", "%" + carModel + "%")
                .getResultList();
        return cars;
    }

    public List<Cars> listerParBrand(String carBrand) {
        List<Cars> cars = entityManager.createQuery("select c from Cars c where c.carBrand like :pbrand", Cars.class)
                .setParameter("pbrand", "%" + carBrand + "%")
                .getResultList();
        return cars;
    }
}
