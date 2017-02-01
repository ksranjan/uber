package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.Driver;
import com.allstate.enums.CarType;
import com.allstate.repositories.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private ICarRepository repository;

    @Autowired
    public void setRepository(ICarRepository repository) {
        this.repository = repository;
    }

    public Car create( String make, String name, CarType type, Driver driver) {
        return this.repository.save(new Car(make, name, type, driver));
    }

    public Car getById(int id){
        return this.repository.findOne(id);
    }

    public Iterable<Car> getAll(){
        return this.repository.findAll();
    }
    public void deleteById(int id){
        if(this.repository.findOne(id).getTrips().size() == 0){
            this.repository.delete(id);
        }
    }
}
