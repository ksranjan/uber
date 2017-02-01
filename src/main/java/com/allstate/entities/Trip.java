package com.allstate.entities;

import com.allstate.enums.CarType;
import com.allstate.enums.DayTime;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
    private DayTime dayTime;
    private double rate;
    private Car car;
    private Passenger passenger;
    private int pRating;
    private String pComment;
    private int dRating;
    private String dComment;
    private int tickets;

    public Trip() {
    }

    public Trip(Date startTime, Date endTime, double distance, City city, int tipPercent, DayTime dayTime, Car car, Passenger passenger , String pComment, int pRating, String dComment, int dRating, int tickets) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.distance = distance;
        this.city = city;
        this.tipPercent = tipPercent;
        this.dayTime = dayTime;
        this.rate =  dayTime.equals(DayTime.DAY) ? city.getDayRate() : city.getNightRate();
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

    @Column(name = "p_rating")
    public int getpRating() {
        return pRating;
    }

    public void setpRating(int pRating) {
        this.pRating = pRating;
    }

    @Column(name = "p_comment")
    public String getpComment() {
        return pComment;
    }

    public void setpComment(String pComment) {
        this.pComment = pComment;
    }

    @Column(name = "d_rating")
    public int getdRating() {
        return dRating;
    }

    public void setdRating(int dRating) {
        this.dRating = dRating;
    }

    @Column(name = "d_comment")
    public String getdComment() {
        return dComment;
    }

    public void setdComment(String dComment) {
        this.dComment = dComment;
    }

    @Column(columnDefinition = "ENUM('DAY', 'NIGHT')")
    @Enumerated(EnumType.STRING)
    @NotNull
    public DayTime getDayTime() {
        return dayTime;
    }

    public void setDayTime(DayTime dayTime) {
        this.dayTime = dayTime;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
