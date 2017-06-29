package io.egen.service;


import io.egen.entity.Reading;

public interface AlertService {
    void checkForAlerts(Reading readings);
}
