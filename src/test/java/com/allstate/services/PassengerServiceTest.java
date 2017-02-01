package com.allstate.services;

import com.allstate.entities.Passenger;
import com.allstate.enums.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class PassengerServiceTest {

    @Autowired
    private PassengerService service;
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateAPassenger (){
        Passenger p = this.service.create("raman", 4000, 25, Gender.FEMALE);
        assertEquals(3, p.getId());
    }

    @Test
    public void shouldReturnPassengerById(){
        assertEquals("sita", this.service.getById(2).getName());
    }
    @Test
    public void shouldReturnPassengerByName() {
        assertEquals(2,this.service.getByName("sita").getId());
    }

    @Test
    public void shouldGetAllPassengers(){
        ArrayList<Passenger> passengers = (ArrayList)this.service.getAll();
        assertEquals(2, passengers.size());
    }
    @Test
    @org.springframework.transaction.annotation.Transactional
    public void shouldDeletePassengerIfNOTrip(){
        this.service.deleteById(2);
        ArrayList<Passenger> passengers = (ArrayList)this.service.getAll();
        assertEquals(1, passengers.size());
    }

    @Test
    @org.springframework.transaction.annotation.Transactional
    public void shouldNotDeletePassengerIfNOTrip(){
        this.service.deleteById(1);
        ArrayList<Passenger> passengers = (ArrayList)this.service.getAll();
        assertEquals(2, passengers.size());
    }

}