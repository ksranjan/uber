//package com.allstate.services;
//
//import com.allstate.entities.Car;
//import com.allstate.entities.City;
//import com.allstate.entities.Passenger;
//import com.allstate.entities.Trip;
//import com.allstate.enums.DayTime;
//import com.allstate.repositories.ITripRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Date;
//
//public class TripService {
//    private ITripRepository repository;
//
//    @Autowired
//    public void setRepository(ITripRepository repository) {
//        this.repository = repository;
//    }
//
//    public Trip create(Date startTime, Date endTime, double distance, City city, int tipPercent, DayTime time, Car car, Passenger passenger , String pComment, int pRating, String dComment, int dRating, int tickets){
//        return this.repository.save(new Trip(startTime, endTime, distance, city, tipPercent, time, car, passenger, pComment, pRating, dComment, dRating, tickets));
//    }
//}
