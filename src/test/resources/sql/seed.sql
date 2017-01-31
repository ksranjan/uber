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
  ("sita", 3000, 23, 'FEMALE');