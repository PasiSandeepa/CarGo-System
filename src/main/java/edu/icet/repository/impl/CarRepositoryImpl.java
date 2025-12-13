package edu.icet.repository.impl;

import edu.icet.model.entity.Car;
import edu.icet.repository.CarRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class CarRepositoryImpl implements CarRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Car> findAvailableCars() {
        String jpql="SELECT c FROM Car c WHERE c.available = true";
        return entityManager.createQuery(jpql, Car.class).getResultList();

    }
}
