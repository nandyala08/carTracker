package io.egen.service;

import io.egen.entity.Alert;
import io.egen.entity.Reading;
import io.egen.entity.Tires;
import io.egen.entity.Vehicle;
import io.egen.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    AlertRepository alertRepository;


    public void checkForAlerts(Reading readings) {
        Alert alert = null;
        Vehicle vech = readings.getVech();

        if(readings.getEngineRpm() > vech.getRedlineRpm())
        {
            alert = new Alert(readings, "HIGH");
        }
        else if(readings.getFuelVolume() < 0.1*vech.getMaxFuelVolume())
            alert = new Alert(readings, "MEDIUM");
        else if(checkTirePressure(readings.getTires()))
            alert = new Alert(readings, "LOW");
        else if(readings.isEngineCoolantLow() || readings.isCheckEngineLightOn())
            alert = new Alert(readings, "LOW");

        if(alert != null)
            alertRepository.create(alert);

    }

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
