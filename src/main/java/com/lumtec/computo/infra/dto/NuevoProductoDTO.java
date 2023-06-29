package com.lumtec.computo.infra.dto;

import java.math.BigDecimal;

public record NuevoProductoDTO(String nombre,
                               String marca,
                               String modelo,
                               Integer cantidad,
                               String provedor,
                               String garantia,
                               String descripcion,
                               BigDecimal precioCompra,
                               BigDecimal ganancia,
                               BigDecimal reinversion,
                               BigDecimal precioVenta) {
}
