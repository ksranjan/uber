package com.allstate.services;

import com.allstate.entities.Driver;
import com.allstate.enums.Gender;
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

import static org.junit.Assert.*;

/**
 * Created by localadmin on 01/02/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class DriverServiceTest {
    @Autowired
    private DriverService service;
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateADriver() {
        Driver d = this.service.create(Gender.MALE,"BILL",3);
        assertEquals(3, d.getId());
    }
    @Test
    public void shouldGetById(){
        assertEquals("bill",this.service.getById(1).getName());
    }

    @Test
    public void shouldGetAllDrivers(){
        ArrayList<Driver> drivers = (ArrayList)this.service.getAll();
        assertEquals(2, drivers.size());
    }
    @Test
    @Transactional
    public void shouldDeleteDriverIfNOTrip(){
        this.service.deleteById(2);
        ArrayList<Driver> drivers = (ArrayList)this.service.getAll();
        assertEquals(1, drivers.size());
    }

    @Test
    @Transactional
    public void shouldNotDeleteDriverIfNOTrip(){
        this.service.deleteById(1);
        ArrayList<Driver> drivers = (ArrayList)this.service.getAll();
        assertEquals(2, drivers.size());
    }

    @Test
    @Transactional
    public void shouldAddTickets(){
        this.service.getById(1).setTickets(2);
        assertEquals(3, this.service.getById(1).getTickets());
    }

    @Test
    @Transactional
    public void shouldBanIfTicketsMoreThan3(){
        Driver d = this.service.create(Gender.MALE, "ram", 4);
        d.setTickets(4);
        assertEquals(true, d.isBanned());
    }

}