package io.egen.service;

import io.egen.entity.Reading;
import io.egen.entity.Vehicle;
import io.egen.exception.BadRequest;
import io.egen.repository.ReadingRepository;
import io.egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

//---------Implementation of Reading Service Interface--------//
@Service
public class ReadingServiceImpl implements ReadingService{

    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    AlertService alertService;

    //-----Method to find all readings-------//
    @Transactional(readOnly = true)
    public List<Reading> findAll() {

            return readingRepository.findAll();
    }

    //-----Method to find a reading-------//
    @Transactional(readOnly = true)
    public Reading findOne(String vin) {
        Reading existing = readingRepository.findOne(vin);
        if(existing==null){
            throw new BadRequest("Reading with vin "+ vin+ " does not exist");
        }
        return existing;
    }

    //-----Method to create readings-------//
    @Transactional
    public Reading create(Reading read) {
        Vehicle vech = vehicleRepository.findOne(read.getVin());
        if (vech == null) {
            throw new NullPointerException();
        }
        read.setVech(vech);
        readingRepository.create(read);
        alertService.checkForAlerts(read);
        return read;
    }

    //-----Method to update a reading-------//
    @Transactional
    public Reading update(Reading read) {
        return readingRepository.update(read);
    }
}