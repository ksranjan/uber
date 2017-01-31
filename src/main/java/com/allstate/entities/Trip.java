package com.allstate.entities;

import com.allstate.enums.CarType;
import com.allstate.enums.DayTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "trips")
@Data
public class Trip {
    private int id;
    private int version;
    private Date startTime;
    private Date endTime;
    private double distance;
    private double cost;
    private City city;
    private int tipPercent;
    private double totalCost;
    private Date created;
    private Date modified;
    private DayTime time;
    private double rate;
    private Car car;
    private Passenger passenger;
    private int pRating;
    private String pComment;
    private int dRating;
    private String dComment;
    private int tickets;
    private List<Review> reviews;
//    private Review dReview;
//    private Review pReview;
    private Review review;

    public Trip() {
    }

    public Trip(Date startTime, Date endTime, double distance, City city, int tipPercent, DayTime time, Car car, Passenger passenger , String pComment, int pRating, String dComment, int dRating, int tickets) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.distance = distance;
        this.city = city;
        this.tipPercent = tipPercent;
        this.time = time;
        this.rate =  time.equals(DayTime.DAY) ? city.getDayRate() : city.getNightRate();
        this.rate += car.getType().equals(CarType.BASIC) ? 0 : 5;
        this.cost = distance * this.rate;
        this.totalCost = cost + (cost * tipPercent)/100;
        this.passenger = passenger;
        this.pComment = pComment;
        this.pRating = pRating;
        this.dComment = dComment;
        this.dRating = dRating;
        this.tickets = tickets;
        this.car = car;
        car.getDriver().setTickets(tickets);
        this.review = new Review(car.getDriver(), this, passenger, pRating, pComment, dRating, dComment);
//        this.dReview = new Review(car.getDriver(), this, null, dRating, dComment);
//        this.pReview = new Review(null, this, passenger, pRating, pComment);
        reviews.add(review);
        passenger.setReviews(reviews);
        car.getDriver().setReviews(reviews);
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
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @NotNull
    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @NotNull
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
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
    @JoinColumn(name="city_id")
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }

    @ManyToOne
    @JoinColumn(name="car_id")
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne
    @JoinColumn(name ="passenger_id")
    public Passenger getPassenger() {
        return passenger;
    }
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "trip")
    @JsonIgnore
    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
    //    public Review getdReview() {
//        return dReview;
//    }
//
//    public void setdReview(Review dReview) {
//        this.dReview = dReview;
//    }
//
//    public Review getpReview() {
//        return pReview;
//    }
//
//    public void setpReview(Review pReview) {
//        this.pReview = pReview;
//    }
}
