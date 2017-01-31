package com.allstate.entities;


import com.allstate.enums.CarType;
import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

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
    private int driver_id;

    public Car(int id, String make, String name,CarType type, Driver driver) {
        this.id = id;
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
}
