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
    public void shouldReturnPassengerByName() {
        Passenger p = this.service.create("rama", 4000, 25, Gender.FEMALE);
        System.out.println(this.service.getByName("rama").getName());
        assertEquals(3, p.getId());
        //assertEquals(2,this.service.getByName("sita").getId());
    }
}