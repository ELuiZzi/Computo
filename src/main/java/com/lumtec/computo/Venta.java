/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lumtec.computo;

/**
 *
 * @author LuiZzi
 */
public class Venta {
    
    private String nombre;
    private String modelo;
    private String fecha;
    private double reinverson;
    private double ganancia;
    private double totalVenta;

    public Venta(String nombre, String modelo, String fecha, double totalVenta) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.fecha = fecha;
        this.totalVenta = totalVenta;
    }

    public Venta(String nombre, String fecha, double totalVenta, double reinverson, double ganancia) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.totalVenta = totalVenta;
        this.reinverson = reinverson;
        this.ganancia = ganancia;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public String getFecha() {
        return fecha;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public double getReinverson() {
        return reinverson;
    }

    public double getGanancia() {
        return ganancia;
    }
    
    
    
    
    
    
}
