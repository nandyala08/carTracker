package io.egen.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import java.sql.Date;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;
//-------- An entity for Alerts -------//
@Entity
@NamedQueries({
        @NamedQuery(name = "Alert.findAll",query = "select alert from Alert alert"), //Query to find all readings data
        @NamedQuery(name = "Alert.findByVin",query = "select alert from Alert alert where alert.vin=:paramVin")
})
public class Alert {

    public Alert(){

    }
    public Alert(Reading reading, String prior, String vin){
        this.read = reading;
        this.priority = prior;
        this.vin=vin;
        this.datetime=new java.sql.Timestamp(new java.util.Date().getTime());
    }

    //--- Mapping Many to alerts to One Reading, joining using rin number of readings data-----///
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rin", nullable = false)
    @JsonIgnore
    private Reading read;


    @Id // Making alertId a Primary Key and generating integral values for alerts
    @GeneratedValue(strategy = IDENTITY)
    private Integer alertId;

    private String vin;

    @Transient
    private Integer rin;

    private Timestamp datetime;

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public Integer getRin() {
        return rin;
    }

    public void setRin(Integer rin) {
        this.rin = rin;
    }


    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Reading getRead() {
        return read;
    }

    public void setRead(Reading read) {
        this.read = read;
    }

    //    public Vehicle getVech() {
//        return vech;
//    }
//
//    public void setVech(Vehicle vech) {
//        this.vech = vech;
//    }

    public Integer getAlertId() {
        return alertId;
    }

    public void setAlertId(Integer alertId) {
        this.alertId = alertId;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    private String priority;

//    private java.sql.Timestamp datetime ;
//
//    public java.sql.Timestamp getDatetime() {
//        return datetime;
//    }
//
//    public void setDatetime(java.sql.Timestamp datetime) {
//        this.datetime = datetime;
//    }
}
