package com.allstate.entities;

import com.allstate.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="drivers")
@Data
public class Driver {
    private int id;
    private int version;
    private int age;
    private Gender gender;
    private String name;
    private List<Car> cars;
    private boolean banned;
    private int tickets;
    private List<Review> reviews;
    private double avgRating;
    private Date created;
    private Date modified;

    public Driver() {
    }

    public Driver(Gender gender, String name, List<Car> cars, int age) {
        this.gender = gender;
        this.name = name;
        this.cars = cars;
        this.age = age;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @NotNull
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driver")
    @JsonIgnore
    public List<Car> getCars() {
        return cars;
    }
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @NotNull
    public int getTickets() {
        return tickets;
    }
    public void setTickets(int ticket) {
        this.tickets += ticket;
        this.banned = tickets > 3;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driver")
    @JsonIgnore
    public List<Review> getReviews() {
        return reviews;
    }
    public void setReviews(List<Review> reviews){
        this.reviews = reviews;
    }
//
//    public void setReviews(Review review) {
//        this.reviews.add(review);
//    }
}
