INSERT INTO `addresses` (`address_id`, `street`, `building_number`, `flat_number`) VALUES
(1, 'TestOne', 1, 1),
(2, 'TestTwo', 2, 2),
(3, 'TestThree', 3, 3),
(4, 'TestFour', 4, 4),
(5, 'TestFive', 5, 5);

INSERT INTO `persons` (`person_id`, `name`, `surname`, `patronymic`, `address_id`) VALUES
(1, 'One', 'One', 'One', 1),
(2, 'Two', 'Two', 'Two', 2),
(3, 'Three', 'Three', 'Three', 3),
(4, 'Four', 'Four', 'Four', 4),
(5, 'Five', 'Five', 'Five', 5);