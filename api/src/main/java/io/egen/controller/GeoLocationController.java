//package io.egen.controller;
//
//import io.egen.entity.GeoLocation;
//import io.egen.entity.HighAlert;
//import io.egen.service.GeoLocationService;
//import io.egen.service.HighAlertService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
//@RequestMapping(value = "/geo")
//public class GeoLocationController {
//
//    @Autowired
//    GeoLocationService service;
//
//
//    // CRUD operation- GET
////    @RequestMapping(method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
////    public List<GeoLocation> getLocation() {
////        System.out.println("Displaying all the data from vehicles");
////        return service.getLocation();
////    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/{vin}",
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public List<GeoLocation> findByVin(@PathVariable("vin") String vin) {
//        System.out.println("Displaying a list of geo locations by its vin number");
//        return service.findByVin(vin);
//    }
//
////    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
////            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
////    public List<GeoLocation> create(@RequestBody GeoLocation geoLocation) {
////        System.out.println("----------------------Creating data--------------------------------");
////        return service.create(geoLocation);
////
////
////    }
//
//
//}