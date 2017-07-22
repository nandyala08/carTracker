package io.egen.service;

import io.egen.entity.GeoLocation;
import io.egen.entity.Reading;
import io.egen.exception.BadRequest;
import io.egen.repository.GeoLocationRepository;
import io.egen.repository.HighAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GeoLocationServiceImpl implements GeoLocationService{
    @Autowired
    GeoLocationRepository geoLocationRepository;
//    public List<GeoLocation> getLocation() {
//        return geoLocationRepository.getLocation();
//    }
//    @Transactional(readOnly = true)
//    public List<GeoLocation> findByVin(String vin) {
//        return geoLocationRepository.findByVin(vin);
//    }
@Transactional(readOnly = true)
    public List<GeoLocation> getGeo() {
        return geoLocationRepository.getGeo();
    }
@Transactional(readOnly = true)
    public List<GeoLocation> findGeo(String vin) {
        return geoLocationRepository.findGeo(vin);
    }

    @Transactional
    public void create(Reading read) {
        GeoLocation geo= new GeoLocation(read.getVech().getVin(), read.getLatitude(), read.getLongitude(),read.getTimestamp());

//        GeoLocation existing = (GeoLocation) geoLocationRepository.findByVin(geoLocation.getVin());
//        if (existing != null) {
//            throw new BadRequest("GoeLocation with vin "+geoLocation.getVin()+ " does not exist");
//        }
         geoLocationRepository.create(geo);
    }
}
