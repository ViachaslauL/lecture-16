

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `addresses` (
  `id` int NOT NULL,
  `street` varchar(32) NOT NULL,
  `building_number` int NOT NULL,
  `flat_number` int NOT NULL,
  `person_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `persons` (
  `id` int NOT NULL,
  `name` varchar(32) NOT NULL,
  `surname` varchar(32) NOT NULL,
  `patronymic` varchar(32) NOT NULL,
  `address_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE `addresses`
  ADD PRIMARY KEY (`id`),
  ADD KEY `person_id` (`person_id`);

ALTER TABLE `flyway_schema_history`
  ADD PRIMARY KEY (`installed_rank`),
  ADD KEY `flyway_schema_history_s_idx` (`success`);

ALTER TABLE `persons`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `addresses`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

ALTER TABLE `persons`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

ALTER TABLE `addresses`
  ADD CONSTRAINT `addresses_ibfk_1` FOREIGN KEY (`person_id`) REFERENCES `persons` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;
