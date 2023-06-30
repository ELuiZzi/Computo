package com.lumtec.computo.infra.model;

import com.lumtec.computo.infra.dto.NuevoProductoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "productos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nombre;
    private String marca;
    private String modelo;
    private String descripcion;
    private String garantia;

    @ManyToOne
    private Provedor provedor;

    private Integer cantidad;

    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
    private BigDecimal ganancia;
    private BigDecimal reinversion;

    @Transient
    private boolean switchIva = false;

    //Constructor para el inventario
    public Producto(String nombre, String marca, String modelo, Integer candidad, BigDecimal precioVenta) {
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.cantidad = candidad;
        this.precioVenta = precioVenta;
    }

    public Producto(NuevoProductoDTO nuevoProductoDTO) {
        this.nombre = nuevoProductoDTO.nombre().toUpperCase();
        this.marca = nuevoProductoDTO.marca().toUpperCase();
        this.modelo = nuevoProductoDTO.modelo().toUpperCase();
        this.cantidad = nuevoProductoDTO.cantidad();
        this.garantia = nuevoProductoDTO.garantia().toUpperCase();
        this.descripcion = nuevoProductoDTO.descripcion().toUpperCase();
        this.precioCompra = nuevoProductoDTO.precioCompra();
        this.ganancia = nuevoProductoDTO.ganancia();
        this.reinversion = nuevoProductoDTO.reinversion();
        this.precioVenta = nuevoProductoDTO.precioVenta();
    }

    public Producto(String modelo, BigDecimal precioVenta) {
        this.modelo = modelo;

        this.precioVenta = precioVenta;
    }

}
