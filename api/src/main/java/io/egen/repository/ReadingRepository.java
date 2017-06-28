package io.egen.repository;


import io.egen.entity.Reading;


import java.util.List;

public interface ReadingRepository {
    List<Reading> findAll();

    Reading findOne(String vin);

    //Reading findByModel(String model);

    Reading create(Reading read);

    Reading update(Reading read);



}
