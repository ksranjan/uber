package com.allstate.services;

import com.allstate.entities.Trip;
import com.allstate.enums.DayTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@Sql(value = {"/sql/seed.sql"})
@SpringBootTest
public class TripServiceTest {
    @Autowired
    private TripService tripService;
    @Autowired
    private CityService cityService;
    @Autowired
    private CarService carService;
    @Autowired
    private PassengerService passengerService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateATripIfDriverNotBannedAndPassengerHasEnough() throws Exception {
        Date date = new Date();
        Trip t = this.tripService.create(date, date, 30, this.cityService.getById(1), 0, DayTime.DAY, this.carService.getById(1), this.passengerService.getById(1), "cool pas", 5, "cool dvr", 5, 0);
        assertEquals(3, t.getId());
    }
    @Test
    public void shouldNotCreateTripOtherwise() {
        Date date = new Date();
        Trip t = this.tripService.create(date, date, 30, this.cityService.getById(1), 0, DayTime.DAY, this.carService.getById(1), this.passengerService.getById(2), "cool pas", 5, "cool dvr", 5, 0);
        assertNull(t);
    }

}