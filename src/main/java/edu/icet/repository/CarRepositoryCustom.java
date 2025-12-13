package edu.icet.repository;

import edu.icet.model.entity.Car;

import java.util.List;

public interface CarRepositoryCustom {
    List<Car>findAvailableCars();
}
