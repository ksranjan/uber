package com.allstate.entities;

import com.allstate.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

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
    private double avgRating;
    private Date created;
    private Date modified;

    public Driver() {
    }

    public Driver(Gender gender, String name, int age) {
        this.gender = gender;
        this.name = name;
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

    @Column(columnDefinition = "ENUM('MALE', 'FEMALE')")
    @Enumerated(EnumType.STRING)
    @NotNull
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
