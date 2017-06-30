package io.egen.service;


import io.egen.entity.Reading;


import java.util.List;
//----------Interface for Reading Service---------//
public interface ReadingService {
    List<Reading> findAll();

    Reading findOne(String vin);

   Reading create(Reading read);

    Reading update(Reading read);
}
