package com.allstate.services;

import com.allstate.entities.City;
import com.allstate.entities.Driver;
import com.allstate.repositories.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {
    private ICityRepository repository;

    @Autowired
    public void setRepository(ICityRepository repository) {
        this.repository = repository;
    }

    public City create(String name, String state, double dRate, double nRate) {
        City c = new City(name, state, dRate, nRate);
        return this.repository.save(c);
    }
    public City getByName(String name){
        return this.repository.findByName(name);
    }

    public City getById(int id){
        return this.repository.findOne(id);
    }

    public Iterable<City> getAll(){
        return this.repository.findAll();
    }
    public void deleteById(int id){
        if(this.repository.findOne(id).getTrips().size() == 0){
            this.repository.delete(id);
        }
    }

    public List<Driver> findAllDrivers(int id) {
        return this.repository.findOne(id).getTrips().stream().map(t -> t.getCar().getDriver()).distinct().collect(Collectors.toList());
    }
}
