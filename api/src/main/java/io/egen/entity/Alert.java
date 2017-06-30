package io.egen.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
//-------- An entity for Alerts -------//
@Entity
public class Alert {

    public Alert(Reading reading, String prior){
        this.read = reading;
        this.priority = prior;
    }

    //--- Mapping Many to alerts to One Reading, joining using rin number of readings data-----///
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rin", nullable = false)
    private Reading read;

    @Id // Making alertId a Primary Key and generating integral values for alerts
    @GeneratedValue(strategy = IDENTITY)
    private Integer alertId;

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
}
