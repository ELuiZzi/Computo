package com.lumtec.computo;

public class Producto {

    private int idProducto;
    private int cantidad;

    private float precioCompra;
    private float precioVenta;
    private float porcentajeGanancia;
    private float ganancia;
    private float porcentajeReinversion;
    private float reinversion;

    private String nombreProducto;
    private String marca;
    private String color;
    private String modelo;
    private String descripcion;
    private String provedor;
    private String garantia;

    private boolean switchIva = false;

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

    public Float calcularGanacia(int cantidad) {
        float ganaTotal = getGanancia() * cantidad;
        return ganaTotal;
    }

    public Float calcularReinversion(int cantidad) {
        float reinTotal = getReinversion() * cantidad;
        return reinTotal;
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

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public float getPorcentajeGanancia() {
        return porcentajeGanancia;
    }

    public void setPorcentajeGanancia(float porcentajeGanancia) {
        this.porcentajeGanancia = porcentajeGanancia;
    }

    public float getGanancia() {
        return ganancia;
    }

    public void setGanancia(float ganancia) {
        this.ganancia = ganancia;
    }

    public float getPorcentajeReinversion() {
        return porcentajeReinversion;
    }

    public void setPorcentajeReinversion(float porcentajeReinversion) {
        this.porcentajeReinversion = porcentajeReinversion;
    }

    public float getReinversion() {
        return reinversion;
    }

    public void setReinversion(float reinversion) {
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

}
