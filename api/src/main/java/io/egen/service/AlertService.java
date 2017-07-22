package io.egen.service;


//import io.egen.ViewObject.AlertsVO;
import io.egen.entity.Alert;
//import io.egen.entity.HighAlert;
import io.egen.entity.Reading;

import java.util.List;

//-------------Interface for Alert Service-------------//
public interface AlertService {
    void checkForAlerts(Reading readings);

    List<Alert> getAlerts();

    List<Alert> findByVin(String vin);

    //List<HighAlert> getHighAlerts();
}
