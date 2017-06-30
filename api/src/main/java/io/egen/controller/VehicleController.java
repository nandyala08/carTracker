package io.egen.controller;

import io.egen.entity.Vehicle;
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

    // CRUD operation- GET
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAll() {
        System.out.println("Displaying all the data from vehicles");
        return service.findAll();
    }

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