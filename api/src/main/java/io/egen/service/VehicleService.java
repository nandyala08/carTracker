package io.egen.service;

import io.egen.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> findAll();

    Vehicle findOne(String vin);

    Vehicle create(Vehicle veh);

    Vehicle update(String vin, Vehicle veh);

    void delete(String vin);
}