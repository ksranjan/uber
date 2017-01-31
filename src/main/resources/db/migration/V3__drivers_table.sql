CREATE TABLE `drivers` (
  `id`         INT            NOT NULL  AUTO_INCREMENT,
  `version`    INT            NOT NULL  DEFAULT 0,
  `name`       VARCHAR(255)   NOT NULL,
  `age`        INT            NOT NULL,
  `banned`     BOOLEAN        NOT NULL  DEFAULT FALSE,
  `gender`     ENUM('MALE', 'FEMALE') NOT NULL,
  `tickets`    INT            DEFAULT 0,
  `avg_rating` DECIMAL(5,2),
  `created`    TIMESTAMP      NOT NULL  DEFAULT NOW(),
  `modified`   TIMESTAMP      NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`));