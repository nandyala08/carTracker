package io.egen.repository;

import io.egen.entity.Alert;
//import io.egen.entity.HighAlert;
import io.egen.entity.Reading;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Calendar;
import java.util.List;

//-----------An implementation of Alert Repository---------//
@Repository

public class AlertRepositoryImpl implements AlertRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Alert> findAll() {
        TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.findAll", Alert.class);
        return query.getResultList();
    }

    public List<Alert> findByVin(String vin) {

            TypedQuery<Alert> query = entityManager.createNamedQuery("Alert.findByVin", Alert.class);
            query.setParameter("paramVin", vin);
            List<Alert> resutList = query.getResultList();
            if(resutList!= null){
                return resutList;
            }
            else {
                return null;
            }

    }

    //    public List<HighAlert> findHighAlert() {
//        TypedQuery<HighAlert> query = entityManager.createNamedQuery("HighAlert.findHighAlert", HighAlert.class);
//        return query.getResultList();
//    }
    public String create(Alert alert) {
        //long timeNow = Calendar.getInstance().getTimeInMillis();
        //java.sql.Timestamp ts = new java.sql.Timestamp(timeNow);

        //java.text.SimpleDateFormat sdf =    new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //String currentTime = sdf.format(dt);
        //alert.setDatetime(ts);
         entityManager.persist(alert);
         return "";
    }
}
