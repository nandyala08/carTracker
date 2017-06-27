package io.egen.repository;

import io.egen.entity.Vehicle;

import java.util.List;

public interface VehicleRepository {
    List<Vehicle> findAll();

    Vehicle findOne(String vin);

    Vehicle findByModel(String model);

    Vehicle create(Vehicle veh);

    Vehicle update(Vehicle veh);

    void delete(Vehicle veh);
}
