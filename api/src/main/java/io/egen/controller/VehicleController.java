package io.egen.controller;

//import io.egen.ViewObject.AlertsVO;
import io.egen.entity.Alert;
//import io.egen.entity.HighAlert;
import io.egen.entity.GeoLocation;
import io.egen.entity.Vehicle;
import io.egen.service.AlertService;
import io.egen.service.GeoLocationService;
import io.egen.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;



import java.util.List;
//-----------Controller for Vehicle------------//
//Annotating to overcome CORS issue
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    VehicleService service;

    @Autowired
    AlertService alertService;

    @Autowired
    GeoLocationService geoLocationService;



    // CRUD operation- GET
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAll() {
        System.out.println("Displaying all the data from vehicles");
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/alerts",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alert> getAlerts() {
        System.out.println("Displaying a single vehicle by its vin number");
        return alertService.getAlerts();
    }


    @RequestMapping(method = RequestMethod.GET, value = "/alerts/{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alert> findByVin(@PathVariable("vin") String vehId) {
        System.out.println("Displaying a single vehicle by its vin number");
        return alertService.findByVin(vehId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/geo",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<GeoLocation> getGeo() {
        System.out.println("Displaying a single vehicle by its vin number");
        return geoLocationService.getGeo();
    }


    @RequestMapping(method = RequestMethod.GET, value = "/geo/{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<GeoLocation> findGeo(@PathVariable("vin") String vehId) {
        System.out.println("Displaying a single vehicle by its vin number");
        return geoLocationService.findGeo(vehId);
    }


//    @RequestMapping(method = RequestMethod.GET, value = "/alerts/high",
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public List<HighAlert> getHighAlerts() {
//        System.out.println("Displaying a single vehicle by its vin number");
//        return alertService.getHighAlerts();
//    }

    //CRUD operation- GET
    @RequestMapping(method = RequestMethod.GET, value = "/{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle findOne(@PathVariable("vin") String vehId) {
        System.out.println("Displaying a single vehicle by its vin number");
        return service.findOne(vehId);
    }

    //CRUD operation- POST
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle create(@RequestBody Vehicle veh) {
        System.out.println("Creating vehicles data");
        return service.create(veh);
    }

    //CRUD operation- PUT (Insert/update)
    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.TEXT_HTML_VALUE)
    public String update( @RequestBody List<Vehicle> veh) {

        for (Vehicle vehicle : veh) {
            service.update(vehicle);
        }

        return "";
    }

}