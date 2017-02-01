package com.allstate.entities;


import com.allstate.enums.CarType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="cars")
@Data
public class Car {
    private int id;
    private int version;
    private String name;
    private String make;
    private CarType type;
    private Driver driver;
    private Date created;
    private Date modified;
    private List<Trip> trips;

    public Car(){

    }

    public Car(String make, String name,CarType type, Driver driver) {
        this.make = make;
        this.name = name;
        this.type = type;
        this.driver = driver;
    }

   @Id
   @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(columnDefinition = "ENUM('BASIC', 'LUX')")
    @Enumerated(EnumType.STRING)
    @NotNull
    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
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

    @ManyToOne
    @JoinColumn(name="driver_id")
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "passenger")
    @JsonIgnore
    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }


}
