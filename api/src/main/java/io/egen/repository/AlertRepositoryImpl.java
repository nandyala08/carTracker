package io.egen.repository;

import io.egen.entity.Alert;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class AlertRepositoryImpl implements AlertRepository {



    @PersistenceContext
    private EntityManager entityManager;
    public String create(Alert alert) {

         entityManager.persist(alert);
         return "";


    }
}
