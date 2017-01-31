CREATE TABLE `trips` (
  `id`         INT            NOT NULL  AUTO_INCREMENT,
  `version`    INT            NOT NULL  DEFAULT 0,
  `start_Time` TIMESTAMP      NOT NULL  DEFAULT NOW(),
  `end_Time`   TIMESTAMP      NOT NULL  DEFAULT NOW(),
  `distance`   DECIMAL(10,2)  NOT NULL  DEFAULT  0,
  `cost`       DECIMAL(10,2)  NOT NULL  DEFAULT  0,
  `tip_Percent`INT            NOT NULL  DEFAULT  0,
  `total_cost` DECIMAL(10,2)  NOT NULL  DEFAULT  0,
  `created`    TIMESTAMP      NOT NULL  DEFAULT NOW(),
  `modified`   TIMESTAMP      NOT NULL  DEFAULT NOW(),
  `city_id`     INT           NOT NULL ,
  `passenger_id`INT           NOT NULL ,
  `car_id`      INT           NOT NULL ,
  `day_time`    ENUM('DAY', 'NIGHT'),
  `rate`        DECIMAL(10,2) NOT NULL ,
  `p_rating`    INT           NOT NULL ,
  `p_comment`   VARCHAR(50),
  `d_rating`    INT           NOT NULL ,
  `d_comment`   VARCHAR(50),
  `tickets`     INT ,
  PRIMARY KEY (`id`),

  CONSTRAINT `fk_car_id`
  FOREIGN KEY (`car_id`)
  REFERENCES `cars` (`id`),

  CONSTRAINT `fk_passenger_id`
  FOREIGN KEY (`passenger_id`)
  REFERENCES `passengers` (`id`),

  CONSTRAINT `fk_city_id`
  FOREIGN KEY (`city_id`)
  REFERENCES `cities` (`id`));


