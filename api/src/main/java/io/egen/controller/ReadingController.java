package io.egen.controller;

import io.egen.entity.Reading;
import io.egen.repository.AlertRepository;
import io.egen.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//-------Controller for readings data-------//

// Using @CrossOrigin to reduce CORS issues
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/readings")
public class ReadingController {

    @Autowired
    ReadingService readingService;
    //CRUD operation- GET
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Reading> findAll() {
       System.out.println("-----------etching all the data from readings-------");
        return readingService.findAll();
    }
    //CRUD operation- POST
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.TEXT_HTML_VALUE)
    public String create(@RequestBody Reading read) {
        System.out.println("----------------------Creating data--------------------------------");
        readingService.create(read);
        return "" ;
    }

}
