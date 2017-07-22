package io.egen.repository;

import io.egen.entity.Vehicle;

import java.util.List;
//-------An Interface for Vehicle Repository----------//
public interface VehicleRepository {
    List<Vehicle> findAll();

    Vehicle findOne(String vin);

    Vehicle findByModel(String model);

    Vehicle create(Vehicle veh);

    Vehicle update(Vehicle veh);


}
