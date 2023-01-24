package com.lumtec.computo.Vender;

import com.lumtec.computo.Producto;

public interface VentaDAO {

    public void vender(Producto prod, int cantidad, float totalVenta);

}
