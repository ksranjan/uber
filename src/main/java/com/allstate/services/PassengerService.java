package com.allstate.services;

import com.allstate.entities.Passenger;
import com.allstate.enums.Gender;
import com.allstate.repositories.IPassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
    private IPassengerRepository repository;

    @Autowired
    public void setRepository(IPassengerRepository repository) {
        this.repository = repository;
    }

    public Passenger create(String name, double balance, int age, Gender gender){
        return this.repository.save(new Passenger(name, balance, age, gender ));
    }

    public Passenger getById(int id){
        return this.repository.findOne(id);
    }
    public Passenger getByName(String name){
        return this.repository.findByName(name);
    }

    public Iterable<Passenger> getAll(){
        return this.repository.findAll();
    }
    public void deleteById(int id){
        if(this.repository.findOne(id).getTrips().size() == 0){
            this.repository.delete(id);
        }
    }
}
