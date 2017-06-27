package io.egen.repository;

import io.egen.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository


public class VehicleRepositoryImpl implements VehicleRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll", Vehicle.class);

        return query.getResultList();
    }

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


    public Vehicle findOne(String vin) {
        return entityManager.find(Vehicle.class, vin);
    }



    public Vehicle create(Vehicle veh) {
        entityManager.persist(veh);
        return veh;
    }

    public Vehicle update(Vehicle veh) {
        return entityManager.merge(veh);
    }

    public void delete(Vehicle veh) {
      entityManager.remove(veh);
    }


}
