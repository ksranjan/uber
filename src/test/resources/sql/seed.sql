use ubertest;

set FOREIGN_KEY_CHECKS = 0;
truncate table cities;
truncate table passengers;
truncate table cars;
truncate table trips;
TRUNCATE TABLE drivers;

set FOREIGN_KEY_CHECKS = 1;

INSERT INTO cities (name, state, day_rate, night_rate) VALUES
  ("pune", "maharashtra", 7, 10),
  ("chd", "punjab", 10, 15);

INSERT INTO passengers (name, balance, age, gender) VALUES
  ("ram", 5000, 25, 'MALE'),
  ("sita", 0, 23, 'FEMALE');

INSERT INTO drivers (gender, name, age, banned, tickets, avg_rating) VALUES
  ('FEMALE', "bill", 6, FALSE , 1, 5),
  ('MALE', "pankaj", 7, FALSE , 0, 6);

INSERT INTO cars (name, make, type, driver_id )  VALUES
  ('Mahindra XUV', 2016, 'LUX', 1),
  ('TATA Safari', 2016, 'LUX', 1);

INSERT INTO trips (start_time, end_time, distance, cost, tip_Percent, total_cost, city_id, passenger_id, car_id, day_time, rate, p_rating, p_comment, d_rating, d_comment, tickets) VALUES
  ('2017-1-3 00:00:00', '2017-1-4 00:00:00', 20, 100, 10, 110, 1, 1, 1, 'DAY', 7, 5, "awesome", 5, "awesome", 0),
  ('2017-1-3 00:00:00', '2017-1-4 00:00:00', 20, 100, 10, 110, 1, 1, 1, 'DAY', 7, 5, "nice", 5, "nice", 0);