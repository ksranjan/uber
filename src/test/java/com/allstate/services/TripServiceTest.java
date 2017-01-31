//package com.allstate.services;
//
//import com.allstate.entities.Trip;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Date;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@Sql(value = {"/sql/seed.sql"})
//@SpringBootTest
//public class TripServiceTest {
//    @Autowired
//    private TripService tripService;
//
//    @Before
//    public void setUp() throws Exception {
//
//    }
//
//    @After
//    public void tearDown() throws Exception {
//
//    }
//
// //   @Test
////    public void shouldCreateATrip() throws Exception {
////        Trip t = tripService.create(new Date(2016, 3, 3, 7, 7, 7), new Date(2016, 3, 3, 8, 8, 7),30,'' )
////    }
//
//}