package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.enums.CarType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class CarServiceTest {
    @Autowired
    private CarService service;
    @Autowired
    private DriverService driverService;

    @Test
    public  void shouldCreateACar(){
        Car c1 = this.service.create("2016","Tata Hexa", CarType.BASIC, this.driverService.getById(1));
        assertEquals(3,c1.getId());
    }

    @Test
    public void shouldGetACarById(){
        assertEquals("Mahindra XUV", this.service.getById(1).getName());
    }

    @Test
    public void shouldGetAllCars(){
        ArrayList<Car> cars = (ArrayList)this.service.getAll();
        assertEquals(2, cars.size());
    }
    @Test
    @Transactional
    public void shouldDeleteCarIfNOTrip(){
        this.service.deleteById(2);
        ArrayList<Car> cars = (ArrayList)this.service.getAll();
        assertEquals(1, cars.size());
    }

    @Test
    @Transactional
    public void shouldNotDeleteCarIfNOTrip(){
        this.service.deleteById(1);
        ArrayList<Car> cars = (ArrayList)this.service.getAll();
        assertEquals(2, cars.size());
    }
}
