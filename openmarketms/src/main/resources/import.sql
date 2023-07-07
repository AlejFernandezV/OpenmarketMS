-- Script para person
INSERT INTO Person (id, name, birthdate, email, password, role) VALUES (1, 'Camilo', '2023-06-12 22:02:18.000000', 'camilo@gmail.com', '1234', 'ROLE_ADMIN');
INSERT INTO Person (id, name, birthdate, email, password, role) VALUES (2, 'Juan', '2023-06-12 22:02:18.000000',  'juan@gmail.com', '1234', 'ROLE_USER');
INSERT INTO Person (id, name, birthdate, email, password, role) VALUES (3, 'Pedro', '2023-06-12 22:02:18.000000',  'pedro@gmail.con', '1234', 'ROLE_SELLER');
INSERT INTO Person (id, name, birthdate, email, password, role) VALUES (4, 'Maria', '2023-06-12 22:02:18.000000',  'maria@gmai.com', '1234', 'ROLE_DELIVERY');

-- Script para address
INSERT INTO address (id, latitude, longitude) VALUES (1, 37.7749, -122.4194);
INSERT INTO address (id, latitude, longitude) VALUES (2, 40.7128, -74.0060);
INSERT INTO address (id, latitude, longitude) VALUES (3, 51.5074, -0.1278);

-- Script para Product
INSERT INTO product (id, name, quantity, price, description, category, ubication) VALUES (1, 'Product A', 10, 19.99, 'This is a description of Product A', 'Electronics', 'Store A');
INSERT INTO product (id, name, quantity, price, description, category, ubication) VALUES (2, 'T-Shirt', 20, 12.99, 'Comfortable cotton t-shirt', 'Apparel', 'Clothing Store');
INSERT INTO product (id, name, quantity, price, description, category, ubication) VALUES (3, 'Smartphone', 5, 499.99, 'High-end smartphone with advanced features', 'Electronics', 'Electronics Store');
INSERT INTO product (id, name, quantity, price, description, category, ubication) VALUES (4, 'Milk', 50, 2.49, 'Fresh whole milk', 'Food', 'Supermarket');
INSERT INTO product (id, name, quantity, price, description, category, ubication) VALUES (5, 'Curtains', 2, 29.99, 'Elegant curtains for the living room', 'Home', 'Home Decor Store');



