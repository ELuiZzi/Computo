package com.lumtec.computo.Faltantes;

import com.lumtec.computo.Producto;

public interface FaltantesDAO {

    public Producto select(int id, String nombre);

    public void nuevoFaltante(Producto prod);

    public void editar(int id, Producto prod);

    public void calcularGasto(int id, String nombre);

    public void calcularGastoTotal();

    public void eliminarFaltante(int id, String nombre);

    public void acumularCantidad(int id, String nombre, int cantidad);

    public void disminuirCantidad(int id, String nombre, int cantidad);

    /*
    Devuelve la cantidad de un producto en la tabla faltantes
    Ej. A la hora de surtir, cuando queremos eliminar de faltantes los productos recién surtidos
     */
    public int getCantidad(int id, String nombre);

    public String getMarca(int id, String nombre);

    public String getModelo(int id, String nombre);

    public String getColor(int id, String nombre);

    public void venderP2(int id, Producto prod, int cantidad);

}
