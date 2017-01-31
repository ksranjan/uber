package com.allstate.entities;

import com.allstate.enums.Gender;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Map;

@Entity
@Table(name = "passengers")
@Data
public class Passenger {
    private int id;
    private int version;
    private String name;
    private Double balance;
    private int age;
    private Gender gender;
    private Date created;
    private Date modified;
//    private Map<Integer, String> comments;
//    private Map<Integer, Integer> ratings;


    public Passenger() {
    }

    public Passenger(String name, Double balance, int age, Gender gender) {
        this.name = name;
        this.balance = balance;
        this.age = age;
        this.gender = gender;
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
    @Min( value = 0)
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @NotNull
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
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

//    public Map<Integer, String> getComments() {
//        return comments;
//    }
//
//    public void setComments(int tId, String comment) {
//        this.comments.put(tId, comment);
//    }
//
//    public Map<Integer, Integer> getRatings() {
//        return ratings;
//    }
//
//    public void setRatings(int tId, int rating) {
//        this.ratings.put(tId, rating);
//    }
}
