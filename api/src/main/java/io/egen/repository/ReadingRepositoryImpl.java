package io.egen.repository;


import io.egen.entity.Reading;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ReadingRepositoryImpl implements ReadingRepository {
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