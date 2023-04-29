package com.lumtec.computo.Inventario;

import com.lumtec.computo.Producto;

public interface InventarioDAO {

    public void insertar(Producto prod);

    public void eliminarProducto(int id);

    public Producto select(int idS, String nombreS);

    public void actualizar(Producto prod);

    public void venderP1(int cantidad, Producto prod);

    public boolean verificarExistencia(Producto prod);

    public void insertarPrecio(Producto prod);

    public void surtir(int id, String nombre, int cantidad, double precioCompra, String marca, String modelo, String color);

    /*
    Selecciona la cantidad de algun prroducto con su id.
    Ej. A la hora de surtir, para sumar a la cantidad actual los nueva cantidad
     */
    public int cantidadActual(int id, String nombre);

    public float getInversion();

    public float getMaxVentas();

}
