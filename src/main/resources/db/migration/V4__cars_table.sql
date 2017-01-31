CREATE TABLE `cars` (
  `id` INT NOT NULL  AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `make` VARCHAR(45) NOT NULL ,
  `type` ENUM('BASIC','LUX') NOT NULL ,
  `driver_id` INT NOT NULL,
  `version` INT NOT NULL DEFAULT 0,
  `created` TIMESTAMP NULL DEFAULT now(),
  `modified` TIMESTAMP NULL DEFAULT now(),
  PRIMARY KEY (`id`),

  CONSTRAINT `fk_driver_id`
  FOREIGN KEY (`driver_id`)
  REFERENCES `drivers` (`id`));
