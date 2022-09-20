CREATE DATABASE ProyectoERP;
USE ProyectoERP;
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
    precioCosto DOUBLE,
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
CREATE TABLE Usuarios(
	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(40),
    usuario VARCHAR(25),
    clave VARCHAR(25),
    correo VARCHAR(25)
);