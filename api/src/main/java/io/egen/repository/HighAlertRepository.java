package io.egen.repository;

import io.egen.entity.Alert;
import io.egen.entity.HighAlert;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

//import io.egen.entity.HighAlert;

//---------An interface for Alert Repository--------//
public interface HighAlertRepository {
    List<HighAlert> getAHighAlerts();
    void setJdbcTemplate(JdbcTemplate jdbcTemplate) ;

}
