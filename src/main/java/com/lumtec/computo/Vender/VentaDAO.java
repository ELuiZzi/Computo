package com.lumtec.computo.Vender;

import com.lumtec.computo.Producto;
import com.lumtec.computo.Venta;
import java.util.List;

public interface VentaDAO {

   
    public List<Venta> listarVentas();
    
    public List<Venta> listarVentasMensuales(String mes, String año);

    public void vender(Producto producto, int cantidad);

    public String getTotalVendido(String mes, String año);

    public String getGananciaTotal(String mes, String año);

    public String getReinversionTotal(String mes, String año);
    
     public List<String> listadoFinanzas(String mes, String año);
}
