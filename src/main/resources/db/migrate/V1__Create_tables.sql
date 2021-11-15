CREATE TABLE `addresses`
(
    `address_id`              int         NOT NULL AUTO_INCREMENT,
    `street`          varchar(32) NOT NULL,
    `building_number` int         NOT NULL,
    `flat_number`     int         NOT NULL,
    PRIMARY KEY (`address_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT=1
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `persons`
(
    `person_id`         int         NOT NULL AUTO_INCREMENT,
    `name`       varchar(32) NOT NULL,
    `surname`    varchar(32) NOT NULL,
    `patronymic` varchar(32) NOT NULL,
    `address_id`        int  NOT NULL,
    PRIMARY KEY (`person_id`),
    CONSTRAINT `addresses_ibfk_1`
        FOREIGN KEY (`address_id`)
            REFERENCES `addresses`(`address_id`)
            ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT=1
  DEFAULT CHARSET = utf8mb4;

