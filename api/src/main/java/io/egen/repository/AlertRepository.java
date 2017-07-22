package io.egen.repository;

import io.egen.entity.Alert;
//import io.egen.entity.HighAlert;

import java.util.List;

//---------An interface for Alert Repository--------//
public interface AlertRepository {
    String create(Alert alert);
    public List<Alert> findAll();
    List<Alert> findByVin(String vin);
    //public List<HighAlert> findHighAlert();



}
