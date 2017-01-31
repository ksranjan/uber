package com.allstate.services;

import com.allstate.entities.City;
import com.allstate.repositories.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    private ICityRepository repository;

    @Autowired
    public void setRepository(ICityRepository repository) {
        this.repository = repository;
    }

    public City create(String name, String state, double dRate, double nRate) {
        return this.repository.save(new City(name, state, dRate, nRate));
    }
    public City getByName(String name){
        return this.repository.findByName(name);
    }
}
