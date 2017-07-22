package io.egen.service;

import io.egen.entity.HighAlert;
import io.egen.repository.HighAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;


@Service
public class HighAlertServiceImpl implements HighAlertService{
    @Autowired
    HighAlertRepository highAlertRepository;
    Date newDate= new Date();
    public List<HighAlert> getHighAlerts() {

        return highAlertRepository.getAHighAlerts();
    }
}
