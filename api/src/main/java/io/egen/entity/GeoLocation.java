package io.egen.entity;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.sql.Time;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NamedQueries({
        @NamedQuery(name = "GeoLocation.getGeo",query = "select geo from GeoLocation geo"),
        @NamedQuery(name = "GeoLocation.findGeo",query = "select geo from GeoLocation geo where timestamp >= (CURRENT_TIMESTAMP -30) and geo.vin=:paramVin")
})
public class GeoLocation {

    public GeoLocation(){

    }
    public GeoLocation(String vin, Double latitude, Double longitude, Timestamp timestamp){
       this.vin=vin;
       this.latitude=latitude;
       this.longitude=longitude;
       this.timestamp= timestamp;

    }

    @Id // Making rin a Primary key and generating integer values
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String vin;
    private double latitude;
    private double longitude;
    private Timestamp timestamp;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
