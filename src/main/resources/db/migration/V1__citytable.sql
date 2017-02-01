CREATE TABLE `cities` (
  `id` INT NOT NULL  AUTO_INCREMENT,
  `version` INT NOT NULL DEFAULT 0,
  `name` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `day_rate` DECIMAL(5, 2) NOT NULL,
  `night_rate` DECIMAL(5, 2) NOT NULL,
  `created` TIMESTAMP NULL DEFAULT now(),
  `modified` TIMESTAMP NULL DEFAULT now(),
  PRIMARY KEY (`id`));
