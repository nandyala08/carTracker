package io.egen.repository;

import io.egen.entity.GeoLocation;
import io.egen.entity.HighAlert;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public interface GeoLocationRepository {
    List<GeoLocation> getGeo();

    List<GeoLocation> findGeo(String vin);

    String create(GeoLocation geoLocation);
    //void setJdbcTemplate(JdbcTemplate jdbcTemplate) ;
}
