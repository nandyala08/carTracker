package io.egen.service;


import io.egen.entity.Reading;
import io.egen.exception.BadRequest;
import io.egen.exception.ResourceNotFound;
import io.egen.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReadingServiceImpl implements ReadingService{

    @Autowired
    ReadingRepository readingRepository;
    @Transactional(readOnly = true)
    public List<Reading> findAll() {

            return readingRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Reading findOne(String vin) {
        Reading existing = readingRepository.findOne(vin);
        if(existing==null){
            throw new BadRequest("Reading with vin "+ vin+ " does not exist");
        }
        return existing;
    }

    @Transactional
    public Reading create(Reading read) {
        return readingRepository.create(read);
    }

    @Transactional
    public Reading update(Reading read) {
        return readingRepository.update(read);
    }
}