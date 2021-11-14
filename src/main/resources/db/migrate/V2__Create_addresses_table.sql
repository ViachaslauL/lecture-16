CREATE TABLE `addresses`
(
    `id`              int         NOT NULL AUTO_INCREMENT,
    `street`          varchar(32) NOT NULL,
    `building_number` int         NOT NULL,
    `flat_number`     int         NOT NULL,
    `person_id`       int         NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `addresses_ibfk_1`
    FOREIGN KEY (`person_id`)
    REFERENCES `persons` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;