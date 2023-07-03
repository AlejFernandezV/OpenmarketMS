-- Script para person
INSERT INTO person (person_id, person_name, person_birthdate, person_email, person_password,person_role) VALUES (1, 'Camilo', '2023-06-12 22:02:18.000000', 'camilo@gmail.com', '1234', 'ROLE_ADMIN');
INSERT INTO person (person_id, person_name, person_birthdate, person_email, person_password,person_role) VALUES (2, 'Juan', '2023-06-12 22:02:18.000000',  'juan@gmail.com', '1234', 'ROLE_USER');
INSERT INTO person (person_id, person_name, person_birthdate, person_email, person_password,person_role) VALUES (3, 'Pedro', '2023-06-12 22:02:18.000000',  'pedro@gmail.con', '1234', 'ROLE_SELLER');
INSERT INTO person (person_id, person_name, person_birthdate, person_email, person_password,person_role) VALUES (4, 'Maria', '2023-06-12 22:02:18.000000',  'maria@gmai.com', '1234', 'ROLE_DELIVERY');

-- Script para address
INSERT INTO address (address_id, address_latitude, address_longitude, person_id) VALUES (NULL, 1.0, 1.0, 1);
INSERT INTO address (address_id, address_latitude, address_longitude, person_id) VALUES (NULL, 2.0, 2.0, 2);
INSERT INTO address (address_id, address_latitude, address_longitude, person_id) VALUES (NULL, 3.0, 3.0, 3);
INSERT INTO address (address_id, address_latitude, address_longitude, person_id) VALUES (NULL, 4.0, 4.0, 4);