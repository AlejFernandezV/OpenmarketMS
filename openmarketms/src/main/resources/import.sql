CREATE TABLE Products (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre_producto VARCHAR(255) NOT NULL,
  descripcion_producto VARCHAR(255) NOT NULL,
  precio_producto DECIMAL(10,2) NOT NULL,
  categoria_producto VARCHAR(255) NOT NULL,
  cantidad_producto INT NOT NULL
);

INSERT INTO Products (nombre_producto, decripcion_producto, precio_producto, categoria_producto, cantidad_producto)
VALUES ('Lavadora Samsung', 'Lavadora de 17kg', 1700000, 'Electrodomestico',5);

INSERT INTO Products (nombre_producto, decripcion_producto, precio_producto, categoria_producto, cantidad_producto)
VALUES ('Televisor LG', 'Televisor LG 42 pilgadas pantalla LCD Full HD', 2000000, 'Electrodomestico',8);

INSERT INTO Products (nombre_producto, decripcion_producto, precio_producto, categoria_producto, cantidad_producto)
VALUES ('Lenovo Laptop', 'Lenovo Ideapad 330s Procezador AMD Ryzen 5 5500U RAM 16GB Disco duro SSD 2TB', 2500000, 'Tecnología',50);

INSERT INTO Products (nombre_producto, decripcion_producto, precio_producto, categoria_producto, cantidad_producto)
VALUES ('Olla arrocera', 'Olla arrocera de 2 Lt marca Oster',275000, 'Electrodomestico', 17);

INSERT INTO Products (nombre_producto, decripcion_producto, precio_producto, categoria_producto, cantidad_producto)
VALUES ('Celular Samsung Galaxy A52', 'Bateria de 4500 mAh RAM de 8GB Almacenamiento de 1TB', 1300000, 'Tecnología', 20);
