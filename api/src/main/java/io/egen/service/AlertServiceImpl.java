package io.egen.service;

//import io.egen.ViewObject.AlertsVO;
import io.egen.entity.*;
import io.egen.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

//-----------Implementation of Alert Service interface-------------//
@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    AlertRepository alertRepository;

    //-----Method to check for Alerts-------//
    @Transactional
    public void checkForAlerts(Reading readings) {
        Alert alert = null;
        Vehicle vech = readings.getVech();
        String vin=vech.getVin();
        //Rules---->
        if(readings.getEngineRpm() > vech.getRedlineRpm())
        {
            alert = new Alert(readings, "HIGH",vin );
        }
        else if(readings.getFuelVolume() < 0.1*vech.getMaxFuelVolume()){
            alert = new Alert(readings, "MEDIUM",vin);}
        else if(checkTirePressure(readings.getTires())){
            alert = new Alert(readings, "LOW",vin);}
        else if(readings.isEngineCoolantLow() || readings.isCheckEngineLightOn()){
            alert = new Alert(readings, "LOW",vin);}

        if(alert != null)
          alertRepository.create(alert);
    }
    @Transactional
    public List<Alert> getAlerts() {
        List<Alert> alerts = alertRepository.findAll();
        for(Alert a: alerts)
        {
            a.setVin(a.getRead().getVech().getVin());
            a.setRin(a.getRead().getRin());
        }
        return alerts;
    }

    public List<Alert> findByVin(String vin) {
        return alertRepository.findByVin(vin);
    }

//    @Transactional
//    public List<HighAlert> getHighAlerts() {
//        List<HighAlert> alerts = alertRepository.findHighAlert();
//        for (HighAlert h: alerts )
//        {
//            h.setVin();
//        }
//        return alerts;
//    }

    //Conditions to check tire pressure----->

    private boolean checkTirePressure(Tires tires) {
        if(tires.getFrontLeft()<32 || tires.getFrontLeft() > 36)
            return true;
        else if(tires.getFrontRight()<32 || tires.getFrontRight() > 36)
            return true;
        else if(tires.getRearLeft()<32 || tires.getRearLeft() > 36)
            return true;
        else if(tires.getRearRight()<32 || tires.getRearRight() > 36)
            return true;
        else
            return false;
    }
}
