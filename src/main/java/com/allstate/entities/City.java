package com.allstate.entities;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="cities")
@Data
public class City {
    private int id;
    private int version;
    private String name;
    private String state;
    private Date created;
    private Date modified;
    private double dayRate;
    private double nightRate;

    public City() {
    }

    public City(String name, String state, double dayRate, double nightRate) {
        this.name = name;
        this.state = state;
        this.dayRate = dayRate;
        this.nightRate = nightRate;
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

    @NotNull
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
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

    @NotNull
    public double getDayRate() {
        return dayRate;
    }
    public void setDayRate(double dayRate) {
        this.dayRate = dayRate;
    }

    @NotNull
    public double getNightRate() {
        return nightRate;
    }
    public void setNightRate(double nightRate) {
        this.nightRate = nightRate;
    }
}

