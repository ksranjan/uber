package com.allstate.services;

import com.allstate.entities.Driver;
import com.allstate.enums.Gender;
import com.allstate.repositories.IDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by localadmin on 01/02/17.
 */
@Service
public class DriverService {
    private IDriverRepository repository;

    @Autowired

    public void setRepository(IDriverRepository repository) {
        this.repository = repository;
    }
    public Driver create(Gender gender, String name, int age){
        Driver d = new Driver(gender, name, 5);
        return this.repository.save(d);
    }

    public Driver getById(int id){
        return this.repository.findOne(id);
    }

    public Iterable<Driver> getAll(){
        return this.repository.findAll();
    }
    public void deleteById(int id){
        if(this.repository.findOne(id).getCars().stream().filter(c -> c.getTrips().size() > 0).count() == 0){
            this.repository.delete(id);
        }
    }

    public void getAllCities(int id){
//        List<List<City>> cities = this.repository.findOne(id).getCars().stream().map(c -> c.getTrips().stream().map(t -> t.getCity())).collect(Collectors.toList());
//        return list;
    }

}
