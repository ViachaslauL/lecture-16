CREATE TABLE `persons`
(
    `id`         int         NOT NULL AUTO_INCREMENT,
    `name`       varchar(32) NOT NULL,
    `surname`    varchar(32) NOT NULL,
    `patronymic` varchar(32) NOT NULL,
    `address_id` int         NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;