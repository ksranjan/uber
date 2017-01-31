CREATE TABLE `reviews` (
  `id`         INT            NOT NULL  AUTO_INCREMENT,
  `version`    INT            NOT NULL  DEFAULT 0,
  `driver_id`  INT            NOT NULL,
  `trip_id`    INT            NOT NULL,
  `passenger_id` INT          NOT NULL,
  `p_rating`   INT            NOT NULL,
  `p_comment`  VARCHAR(255)   NOT NULL,
  `d_rating`   INT            NOT NULL,
  `d_comment`  VARCHAR(255)   NOT NULL,
  `created`    TIMESTAMP      NOT NULL  DEFAULT NOW(),
  `modified`   TIMESTAMP      NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`),

  CONSTRAINT `fk_trip_id`
  FOREIGN KEY (`trip_id`)
  REFERENCES `trips` (`id`));