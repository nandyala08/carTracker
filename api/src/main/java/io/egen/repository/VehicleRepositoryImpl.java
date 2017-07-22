package io.egen.repository;

import io.egen.entity.Vehicle;


import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

//-----------An implementation of Vehicle Repository Interface----------//
@Repository
public class VehicleRepositoryImpl implements VehicleRepository {
    @PersistenceContext
    private EntityManager entityManager;

//    @Autowired
//    private HibernateTemplate hibernateTemplate;

    //-----Method to find all vehicles-------//
    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll", Vehicle.class);
        return query.getResultList();
    }

    //-----Method to find a vehicle by its Model-------//
    public Vehicle findByModel(String model) {
            TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findByModel", Vehicle.class);
            query.setParameter("paramModel", model);
            List<Vehicle> resutList = query.getResultList();
            if(resutList!= null && resutList.size() == 1){
                return resutList.get(0);
            }
            else {
                return null;
            }
        }

    //-----Method to find a vehicle-------//
    public Vehicle findOne(String vin) {
        return entityManager.find(Vehicle.class, vin);
    }

    //-----Method to create vehicle-------//
    public Vehicle create(Vehicle veh) {
        entityManager.persist(veh);
        return veh;
    }

    //-----Method to update vehicle-------//
    public Vehicle update(Vehicle veh) {
        return entityManager.merge(veh);
    }




}
