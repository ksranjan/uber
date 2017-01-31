package com.allstate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="reviews")
@Data
public class Review {
    private int id;
    private int version;
    private Driver driver;
    private Trip trip;
    private Passenger passenger;
    private int dRating;
    private String dComment;
    private int pRating;
    private String pComment;
    private Date created;
    private Date modified;

    public Review(Driver driver,Trip trip, Passenger passenger, int pRating, String pComment, int dRating, String dComment) {
        this.driver = driver;
        this.passenger = passenger;
        this.trip = trip;
        this.pRating = pRating;
        this.pComment = pComment;
        this.dComment = dComment;
        this.dRating = dRating;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @ManyToOne
    @JoinColumn(name="driver_id")
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @OneToOne
    @JoinColumn(name="trip_id")
    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    @ManyToOne
    @JoinColumn(name="passenger_id")
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public int getdRating() {
        return dRating;
    }

    public void setdRating(int dRating) {
        this.dRating = dRating;
    }

    public String getdComment() {
        return dComment;
    }

    public void setdComment(String dComment) {
        this.dComment = dComment;
    }

    public int getpRating() {
        return pRating;
    }

    public void setpRating(int pRating) {
        this.pRating = pRating;
    }

    public String getpComment() {
        return pComment;
    }

    public void setpComment(String pComment) {
        this.pComment = pComment;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
