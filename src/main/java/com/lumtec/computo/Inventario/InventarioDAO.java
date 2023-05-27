package com.lumtec.computo.Inventario;

import com.lumtec.computo.Producto;

public interface InventarioDAO {

    public void insertar(Producto prod);

    public Producto select(int idS, String nombreS);

    public void actualizar(Producto prod);

    public boolean verificarExistencia(Producto prod);

    public void insertarPrecio(Producto prod);

    public void surtir(Producto producto);

    /*
    Selecciona la cantidad de algun prroducto con su id.
    Ej. A la hora de surtir, para sumar a la cantidad actual los nueva cantidad
     */
    public int getCantidadActual(int id, String nombre);

    public float getInversion();

    public float getMaxVentas();

    public void vender(Producto producto, int cantidadInventario);

}
