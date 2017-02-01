package com.allstate.services;

import com.allstate.entities.City;
import com.allstate.entities.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class CityServiceTest {

    @Autowired
    private CityService service;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateACity() throws Exception {
        City c = this.service.create("blr", "karnataka", 9, 12);
        assertEquals(3, c.getId());
    }

    @Test
    public void shouldReturnCityByName() {
        assertEquals(1,this.service.getByName("pune").getId());
    }

    @Test
    public void shouldReturnCityById(){
        assertEquals("chd", this.service.getById(2).getName());
    }

    @Test
    public void shouldGetAllCities(){
        ArrayList<City> cities = (ArrayList)this.service.getAll();
        assertEquals(2, cities.size());
    }
    @Test
    @Transactional
    public void shouldDeleteCityIfNOTrip(){
        this.service.deleteById(2);
        ArrayList<City> cities = (ArrayList)this.service.getAll();
        assertEquals(1, cities.size());
    }

    @Test
    @Transactional
    public void shouldNotDeleteCityIfNOTrip(){
        this.service.deleteById(1);
        ArrayList<City> cities = (ArrayList)this.service.getAll();
        assertEquals(2, cities.size());
    }

    @Test
    @Transactional
    public void shouldReturnAllDrivers() {
        List<Driver> drivers = this.service.findAllDrivers(1);
        assertEquals(1, drivers.size());
    }


}