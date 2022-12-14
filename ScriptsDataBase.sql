-- CREATE DATABASE proyectoerpjava;
USE heroku_8ccf36eef5db0d1;
CREATE TABLE Cliente(
	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(25),
	apellido VARCHAR(25),
	nit VARCHAR(12),
	direccion VARCHAR(40),
	correo VARCHAR(25),
	telefono VARCHAR(10)
);
CREATE TABLE Producto(
	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(25),
    marca VARCHAR(25),
    stock INTEGER,
    precioCompra DOUBLE,
    precioVenta DOUBLE,
    fechaUltimoIngreso DATE,
    fechaUltimaSalida DATE
);
CREATE TABLE Factura_CxC(
	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    idCliente INTEGER NOT NULL,
    idProducto INTEGER NOT NULL,
    numero BIGINT,
    fecha DATE,
    total DOUBLE,
    precioUnitario DOUBLE,
    cantidadArticulos INTEGER,
    FOREIGN KEY (idCliente) REFERENCES Cliente(id),
    FOREIGN KEY (idProducto) REFERENCES Producto(id)
);
-- INSERT INTO Factura_CxC(idCliente, idProducto, fecha, total, precioUnitario, cantidadArticulos) VALUES(2, 1, NOW(), 13.05, 2.5, 3);
-- SELECT * FROM Factura_CxC;
CREATE TABLE Proveedor(
	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    razonSocial VARCHAR(40),
    direccion VARCHAR(40),
    nombreContacto VARCHAR(40),
    telefonoContacto VARCHAR(10),
    emailContacto VARCHAR(25)
);
CREATE TABLE Factura_CxP(
	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    idProveedor INTEGER NOT NULL,
    idProducto INTEGER NOT NULL,
    numero BIGINT,
    fecha DATE,
    total DOUBLE,
    precioUnitario DOUBLE,
    cantidadArticulos INTEGER,
    FOREIGN KEY (idProveedor) REFERENCES Proveedor(id),
    FOREIGN KEY (idProducto) REFERENCES Producto(id)
);
-- INSERT INTO Factura_CxP(idProveedor, idProducto, fecha, total, precioUnitario, cantidadArticulos) VALUES(2, 1, NOW(), 13.05, 2.5, 3);
-- SELECT * FROM Factura_CxP;
CREATE TABLE Usuario(
	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(40),
    usuario VARCHAR(25),
    clave VARCHAR(25),
    correo VARCHAR(25),
    rol INTEGER
);
-- INSERT INTO Usuario(nombre, usuario, clave, correo, rol) VALUES('Julio Mayen', 'mayenrosil', '123', 'mayenrosil@gmail.com', 1);
 INSERT INTO Usuario(nombre, usuario, clave, correo, rol) VALUES('admin', 'admin', 'admin', 'admin@gmail.com', 1);
-- INSERT INTO Producto(nombre, marca, stock, precioCompra, precioVenta, fechaUltimoIngreso, fechaUltimaSalida) VALUES('Laptop', 'Dell', 2, 99.99, 149.99, NOW(), NOW());
-- INSERT INTO Proveedor(razonSocial, direccion, nombreContacto, telefonoContacto, emailContacto) VALUES('Intelaf', 'Metronorte zona 18', 'Juan Perez', '12345678', 'juan.perez@gmail.com');
-- INSERT INTO Cliente(nombre, apellido, nit, direccion, correo, telefono) VALUES('Juan', 'Perez', '10730648-4', 'Metronorte zona 18', 'juan.perez@gmail.com', '12345678');
-- SELECT * FROM Usuario;
-- SELECT * FROM Producto WHERE nombre = 'Mouse' LIMIT 1;
-- SELECT * FROM Producto;
-- SELECT * FROM Proveedor;
-- SELECT * FROM Cliente;
-- SELECT * FROM Producto RIGHT JOIN Usuario ON Producto.id = Usuario.id;
-- ALTER TABLE Producto RENAME COLUMN precioCosto TO precioCompra;
-- DELETE FROM Producto WHERE id = 6;
ALTER TABLE Cliente MODIFY COLUMN correo VARCHAR(50);
ALTER TABLE Proveedor MODIFY COLUMN emailContacto VARCHAR(50);
ALTER TABLE Usuario MODIFY COLUMN correo VARCHAR(50);
ALTER TABLE Factura_CxC DROP COLUMN numero;
ALTER TABLE Factura_CxP DROP COLUMN numero;
-- DESC Factura_CxC;
DELIMITER //
CREATE PROCEDURE actualizarStockProducto_Venta(
	IN idProductoPorActualizar INTEGER,
    IN aumentoStock INTEGER
)
BEGIN
	SELECT @stockActual := stock FROM Producto WHERE id = idProductoPorActualizar;
	UPDATE Producto SET stock = @stockActual - aumentoStock, fechaUltimaSalida = NOW() WHERE id = idProductoPorActualizar;
END //
DELIMITER ;
DELIMITER //
CREATE PROCEDURE actualizarStockProducto_Compra(
	IN idProductoPorActualizar INTEGER,
    IN aumentoStock INTEGER
)
BEGIN
	SELECT @stockActual := stock FROM Producto WHERE id = idProductoPorActualizar;
	UPDATE Producto SET stock = @stockActual + aumentoStock, fechaUltimoIngreso = NOW() WHERE id = idProductoPorActualizar;
END //
DELIMITER ;
-- CALL actualizarStockProducto_Venta(1, 2);
-- DROP PROCEDURE actualizarStockProducto_Venta;
-- DROP PROCEDURE actualizarStockProducto_Compra;