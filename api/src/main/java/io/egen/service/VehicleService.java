package io.egen.service;

import io.egen.entity.Vehicle;

import java.util.List;
//------------Interface for Vehicle-------------//
public interface VehicleService {
    List<Vehicle> findAll();

    Vehicle findOne(String vin);

    Vehicle create(Vehicle veh);

    Vehicle update(Vehicle veh);

}