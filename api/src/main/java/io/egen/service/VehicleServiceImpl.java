
package io.egen.service;

        import io.egen.entity.Vehicle;
        import io.egen.exception.BadRequest;
        import io.egen.exception.ResourceNotFound;
        import io.egen.repository.VehicleRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.List;
//---------------Implementation of Vehicle Service Interface------------//
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;
    //-----Method to find all vehicles-------//
    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    //-----Method to find one vehicle-------//
    @Transactional(readOnly = true)
    public Vehicle findOne(String vin) {
        Vehicle existing = repository.findOne(vin);
        if (existing == null) {
        throw new ResourceNotFound("Vehicle with vin "+ vin +" does not exist");
        }
        return existing;
    }

    //-----Method to create vehicles-------//
    @Transactional
    public Vehicle create(Vehicle veh) {
        Vehicle existing = repository.findByModel(veh.getModel());
        if (existing != null) {
            throw new BadRequest("Vehicle with model "+veh.getModel()+ " does not exist");
        }
        return repository.create(veh);
    }

    //-----Method to update a vehicle-------//
    @Transactional
    public Vehicle update(Vehicle veh) {
        Vehicle existing = repository.findOne(veh.getVin());
        if (existing == null) {
            return repository.create(veh);
        }
        return repository.update(veh);
    }


}