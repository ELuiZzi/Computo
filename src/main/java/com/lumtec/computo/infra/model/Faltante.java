package com.lumtec.computo.infra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "faltantes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Faltante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cantidad;
    @Transient
    private BigDecimal totalCompra;
    @ManyToOne
    private Producto producto;

}
