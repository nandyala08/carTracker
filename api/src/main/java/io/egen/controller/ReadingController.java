package io.egen.controller;

import io.egen.entity.Reading;
import io.egen.repository.AlertRepository;
import io.egen.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/readings")
public class ReadingController {

    @Autowired
    ReadingService readingService;



    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Reading> findAll() {
       // System.out.println("CAME HERE11111111111!!!!!!!!!!!!!!!!!");
        return readingService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading findOne(@PathVariable("vin") String vehId) {
        //System.out.println("CAME HERE222222222222222!!!!!!!!!!!!!!!!!");
        return readingService.findOne(vehId);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.TEXT_HTML_VALUE)
    public String create(@RequestBody Reading read) {
        System.out.println("------------------------------------------------------");
        System.out.println(read);
        readingService.create(read);
        return "" ;
    }

}
