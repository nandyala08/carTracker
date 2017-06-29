package io.egen.repository;


import io.egen.entity.Reading;
import io.egen.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ReadingRepositoryImpl implements ReadingRepository {

    @Autowired
    AlertService alertService;
    @PersistenceContext
    private EntityManager entityManager;
    public List<Reading> findAll() {
        TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.findAll", Reading.class);

        return query.getResultList();
    }



    public Reading findOne(String vin) {
        return entityManager.find(Reading.class, vin);
    }

    public Reading create(Reading read) {

        entityManager.persist(read);

        return read;
    }

    public Reading update(Reading read) {
        return entityManager.merge(read);
    }
}