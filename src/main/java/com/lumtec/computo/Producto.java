package com.lumtec.computo;

import java.text.DecimalFormat;

public class Producto {

    private int idProducto;
    private int cantidad;

    private double precioCompra;
    private double precioVenta;
    private double porcentajeGanancia;
    private double ganancia;
    private double porcentajeReinversion;
    private double reinversion;
    private double totalCompra;

    private String nombreProducto;
    private String marca;
    private String color;
    private String modelo;
    private String descripcion;
    private String provedor;
    private String garantia;

    private boolean switchIva = false;

    public Producto() {

    }

    public Producto(String nombre, String marca, String modelo, int cantidad, double precioVenta) {
        this.nombreProducto = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
    }

    public Producto(String nombre, String provedor, String modelo, int faltantes, double precioCompra, double totalCompra) {
        this.nombreProducto = nombre;
        this.provedor = provedor;
        this.modelo = modelo;
        this.cantidad = faltantes;
        this.precioCompra = precioCompra;
        this.totalCompra = totalCompra;
    }

    public Producto(String nombre, String modelo, double precioCompra) {
        this.nombreProducto = nombre;
        this.modelo = modelo;
        this.precioCompra = precioCompra;
    }

    public void reset() {
        this.setIdProducto(0);
        this.setCantidad(0);

        this.setNombreProducto(null);
        this.setMarca(null);
        this.setColor(null);
        this.setModelo(null);
        this.setDescripcion(null);

        this.setPrecioCompra(0);
        this.setPrecioVenta(0);
        this.setGanancia(0);
        this.setReinversion(0);
    }

    public double calcularGanacia(int cantidad) {
        double ganaTotal = getGanancia() * cantidad;
        return FuncionesMatematicas.recortarDecimales(ganaTotal);
    }

    public double calcularReinversion(int cantidad) {
        double reinTotal = getReinversion() * cantidad;
        return FuncionesMatematicas.recortarDecimales(reinTotal);
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioCompra() {
        return FuncionesMatematicas.recortarDecimales(this.precioCompra);
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return FuncionesMatematicas.recortarDecimales(this.precioVenta);
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPorcentajeGanancia() {
        return FuncionesMatematicas.recortarDecimales(this.porcentajeGanancia);
    }

    public void setPorcentajeGanancia(double porcentajeGanancia) {
        this.porcentajeGanancia = porcentajeGanancia;
    }

    public double getGanancia() {
        return FuncionesMatematicas.recortarDecimales(this.ganancia);
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public double getPorcentajeReinversion() {
        return FuncionesMatematicas.recortarDecimales(this.porcentajeReinversion);
    }

    public void setPorcentajeReinversion(double porcentajeReinversion) {
        this.porcentajeReinversion = porcentajeReinversion;
    }

    public double getReinversion() {
        return FuncionesMatematicas.recortarDecimales(this.reinversion);
    }

    public void setReinversion(double reinversion) {
        this.reinversion = reinversion;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProvedor() {
        return provedor;
    }

    public void setProvedor(String provedor) {
        this.provedor = provedor;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public boolean isSwitchIva() {
        return switchIva;
    }

    public void setSwitchIva(boolean switchIva) {
        this.switchIva = switchIva;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

}
