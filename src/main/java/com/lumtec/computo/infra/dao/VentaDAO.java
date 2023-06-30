package com.lumtec.computo.infra.dao;

import com.lumtec.computo.infra.model.Venta;

import java.util.List;

public interface VentaDAO {

    public void vender(Venta venta);

    public List<Venta> getVentasFinanzas();
    public List<Venta> getVentasFinanzasMensual(String mes);

}
