
package io.egen.service;

        import io.egen.entity.Vehicle;
        import io.egen.repository.VehicleRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;
    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return repository.findAll();
    }
    @Transactional(readOnly = true)
    public Vehicle findOne(String vin) {
        Vehicle existing = repository.findOne(vin);
        if (existing == null) {

        }
            return existing;
        }


    @Transactional
    public Vehicle create(Vehicle veh) {
        Vehicle existing = repository.;
        if (existing != null) {

        }
        return null;
    }
    @Transactional
    public Vehicle update(String vin, Vehicle veh) {
        Vehicle existing = null;
        if (existing == null) {

        }
        return null;
    }
    @Transactional
    public void delete(String id) {
        Vehicle existing = null;
        if (existing == null) {

        }

    }
}