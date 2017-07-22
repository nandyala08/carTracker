package io.egen.controller;

//import io.egen.ViewObject.AlertsVO;

import io.egen.entity.Alert;
import io.egen.entity.HighAlert;
import io.egen.entity.Vehicle;
import io.egen.service.AlertService;
import io.egen.service.HighAlertService;
import io.egen.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import io.egen.entity.HighAlert;

//-----------Controller for Vehicle------------//
//Annotating to overcome CORS issue
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/highalerts")
public class HighAlertController {

    @Autowired
    HighAlertService service;


    // CRUD operation- GET
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<HighAlert> getHighAlerts() {
        System.out.println("Displaying all the data from vehicles");
        return service.getHighAlerts();
    }


}