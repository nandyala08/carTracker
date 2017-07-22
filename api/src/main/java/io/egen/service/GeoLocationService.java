package io.egen.service;


import io.egen.entity.GeoLocation;
import io.egen.entity.Reading;

import java.util.List;

public interface GeoLocationService {
  List<GeoLocation> getGeo();

   List<GeoLocation> findGeo(String vin);

    void create(Reading read);
}
