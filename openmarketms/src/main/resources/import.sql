-- Script para person
INSERT INTO Person (person_id, person_name, person_birthdate, person_email, person_password,person_role) VALUES (1, 'Camilo', '2023-06-12 22:02:18.000000', 'camilo@gmail.com', '1234', 'ROLE_ADMIN');
INSERT INTO Person (person_id, person_name, person_birthdate, person_email, person_password,person_role) VALUES (2, 'Juan', '2023-06-12 22:02:18.000000',  'juan@gmail.com', '1234', 'ROLE_USER');
INSERT INTO Person (person_id, person_name, person_birthdate, person_email, person_password,person_role) VALUES (3, 'Pedro', '2023-06-12 22:02:18.000000',  'pedro@gmail.con', '1234', 'ROLE_SELLER');
INSERT INTO Person (person_id, person_name, person_birthdate, person_email, person_password,person_role) VALUES (4, 'Maria', '2023-06-12 22:02:18.000000',  'maria@gmai.com', '1234', 'ROLE_DELIVERY');

-- Script para address
INSERT INTO Address (address_id, address_latitude, address_longitude, person_id) VALUES (NULL, 1.0, 1.0, 1);
INSERT INTO Address (address_id, address_latitude, address_longitude, person_id) VALUES (NULL, 2.0, 2.0, 2);
INSERT INTO Address (address_id, address_latitude, address_longitude, person_id) VALUES (NULL, 3.0, 3.0, 3);
INSERT INTO Address (address_id, address_latitude, address_longitude, person_id) VALUES (NULL, 4.0, 4.0, 4);

-- Script para Product
INSERT INTO Product (product_Id, product_name, product_description, product_price, product_categori) VALUES (1, 'Computador', 'Computador de mesa marcar Lenovo', 2500000, 'Tecnología');
INSERT INTO Product (product_Id, product_name, product_description, product_price, product_categori) VALUES (1, 'Lavadora', 'Lavadora Samsung 17Kg', 1500000, 'Electrodomestico');
