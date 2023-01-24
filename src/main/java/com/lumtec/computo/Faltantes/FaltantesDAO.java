package com.lumtec.computo.Faltantes;

import com.lumtec.computo.Faltante;

public interface FaltantesDAO {

    public Faltante select(int id);

    public void nuevoFaltante(Faltante falt);

    public void editar(int id, Faltante falt);

    public void calcularGasto(int id);
    
    public void calcularGastoTotal();
    
    public void eliminarFaltante(int id);
    
    public void editarCantidad(int id, int cantidadR);
    
    /*
    Devuelve la cantidad de un producto en la tabla faltantes
    Ej. A la hora de surtir, cuando queremos eliminar de faltantes los productos recién surtidos
    */
    public int getCantidad(int id);
}
