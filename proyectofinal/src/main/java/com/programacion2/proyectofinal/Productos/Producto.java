
package com.programacion2.proyectofinal.Productos;

/**
 *
 * @author mayen
 */
public class Producto {
    
    private int id;
    private String nombre;
    private String marca;
    private int stock;
    private double precioCosto;
    private double precioVenta;
    private String fechaUltimoIngreso;
    private String fechaUltimaSalida;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getFechaUltimoIngreso() {
        return fechaUltimoIngreso;
    }

    public void setFechaUltimoIngreso(String fechaUltimoIngreso) {
        this.fechaUltimoIngreso = fechaUltimoIngreso;
    }

    public String getFechaUltimaSalida() {
        return fechaUltimaSalida;
    }

    public void setFechaUltimaSalida(String fechaUltimaSalida) {
        this.fechaUltimaSalida = fechaUltimaSalida;
    }
    
    
    
}
