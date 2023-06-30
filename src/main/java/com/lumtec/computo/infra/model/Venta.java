/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lumtec.computo.infra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author LuiZzi
 */
@Entity
@Table(name = "ventas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidad;
    @Transient
    private BigDecimal totalVenta;
    private BigDecimal precioVenta;
    private BigDecimal ganancia;
    private BigDecimal reinversion;
    private LocalDate fecha = LocalDate.now();
    private String mes;
    private String año;

    @ManyToOne
    private Producto producto;




    

    
    
    
    
    
}
