CREATE TABLE `passengers` (
  `id`         INT            NOT NULL  AUTO_INCREMENT,
  `version`    INT            NOT NULL  DEFAULT 0,
  `name`       VARCHAR(255)   NOT NULL,
  `balance`    DECIMAL(12, 2) NOT NULL DEFAULT 1000,
  `age`        INT            NOT NULL,
  `gender`     ENUM('MALE', 'FEMALE') NOT NULL,
  `created`    TIMESTAMP      NOT NULL  DEFAULT NOW(),
  `modified`   TIMESTAMP      NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`));