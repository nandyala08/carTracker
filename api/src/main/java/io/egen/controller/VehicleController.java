package io.egen.controller;

import io.egen.entity.Vehicle;
//import io.egen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    //@Autowired
   // EmployeeService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAll() {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle findOne(@PathVariable("vin") String vehId) {
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle create(@RequestBody Vehicle veh) {
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{vin}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle update(@PathVariable("vin") String empId, @RequestBody Vehicle veh) {
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{vin}")
    public void delete(@PathVariable("vin") String empId) {
        //service.delete(empId);
    }
}