package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.City;
import com.allstate.entities.Passenger;
import com.allstate.entities.Trip;
import com.allstate.enums.DayTime;
import com.allstate.repositories.ITripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TripService {
    private ITripRepository repository;

    @Autowired
    public void setRepository(ITripRepository repository) {
        this.repository = repository;
    }

    public Trip create(Date startTime, Date endTime, double distance, City city, int tipPercent, DayTime dayTime, Car car, Passenger passenger , String pComment, int pRating, String dComment, int dRating, int tickets){
        Trip t = new Trip(startTime, endTime, distance, city, tipPercent, dayTime, car, passenger, pComment, pRating, dComment, dRating, tickets);
        Trip resulting = null;
        if(passenger.getBalance() >= t.getTotalCost() && !car.getDriver().isBanned()) {
            resulting = this.repository.save(t);
        }
        return resulting;
    }

    public Trip getById(int id) {
        return this.repository.findOne(id);
    }

    public void noTripAvailable() {

    }

}
