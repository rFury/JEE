package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.Family_Group;
import Util.JPAutil;

public class FGDaoImpl implements IFGDao {
    // Replace "TP6_JEE" with your persistence unit name as defined in persistence.xml
    private EntityManager entityManager = JPAutil.getEntityManager("CARS_JEE_2");

    @Override
    public Family_Group save(Family_Group group) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(group);
        tx.commit();
        return group;
    }

    @Override
    public Family_Group getFamily_Group(Long id) {
        return entityManager.find(Family_Group.class, id);
    }

    @Override
    public Family_Group updateFamily_Group(Family_Group group) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(group);
        tx.commit();
        return group;
    }

    @Override
    public void deleteFamily_Group(Long id) {
        Family_Group familyGroup = entityManager.find(Family_Group.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(familyGroup);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Family_Group> getAllFamily_Groups() {
        List<Family_Group> groups = entityManager.createQuery("SELECT fg FROM Family_Group fg", Family_Group.class)
                                                  .getResultList();
        return groups;
    }
}
