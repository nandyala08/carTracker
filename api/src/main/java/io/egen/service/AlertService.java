package io.egen.service;


import io.egen.entity.Reading;

//-------------Interface for Alert Service-------------//
public interface AlertService {
    void checkForAlerts(Reading readings);
}
