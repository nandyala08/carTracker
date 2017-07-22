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

    @Autowired
    GeoLocationService geoLocationService;

    //-----Method to find all readings-------//
    @Transactional(readOnly = true)
    public List<Reading> findAll() {

            List<Reading> readings = readingRepository.findAll();
            for(Reading r : readings)
            {
                r.setVin(r.getVech().getVin());
            }
            return readings;
    }

//    public List<Reading> findGeo() {
//        List<Reading> existing = readingRepository.findGeo();
//        if(existing==null){
//            throw new BadRequest(" does not exist");
//        }
//        return existing;
//    }

    //-----Method to find a reading-------//
    @Transactional(readOnly = true)
    public Reading findOne(String vin) {
        Reading existing = readingRepository.findOne(vin);
        if(existing==null){
            throw new BadRequest("Reading with vin "+ vin+ " does not exist");
        }
        return existing;
    }
    @Transactional(readOnly = true)
    public List<Reading> findByVechId(String VechId) {
        return readingRepository.findByVechId(VechId);
    }

    //-----Method to create readings-------//
    @Transactional
    public Reading create(Reading read) {
        Vehicle vech = vehicleRepository.findOne(read.getVin());
        if (vech == null) {
            throw new NullPointerException();
        }
        read.setVech(vech);
        //Reading reads =new Reading(read.getVech().getVin());
        read.setVechId(read.getVech().getVin());
        readingRepository.create(read);
        alertService.checkForAlerts(read);
        geoLocationService.create(read);
        return read;
    }

    //-----Method to update a reading-------//
    @Transactional
    public Reading update(Reading read) {
        return readingRepository.update(read);
    }
}