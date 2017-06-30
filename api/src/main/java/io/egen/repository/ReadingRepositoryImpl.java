package io.egen.repository;

import io.egen.entity.Reading;
import io.egen.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

//--------------An implementation of Reading Repository interface--------------//
@Repository
public class ReadingRepositoryImpl implements ReadingRepository {

    @Autowired
    AlertService alertService;
    @PersistenceContext
    private EntityManager entityManager;
    //-----Method to find all readings-------//
    public List<Reading> findAll() {
        TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.findAll", Reading.class);
        return query.getResultList();
    }

    //-----Method to find a reading-------//
    public Reading findOne(String vin) {
        return entityManager.find(Reading.class, vin);
    }

    //-----Method to create readings-------//
    public Reading create(Reading read) {
        entityManager.persist(read);
        return read;
    }

    //-----Method to update a reading-------//
    public Reading update(Reading read) {
        return entityManager.merge(read);
    }
}