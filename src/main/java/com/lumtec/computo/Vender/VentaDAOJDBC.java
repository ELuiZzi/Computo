package com.lumtec.computo.Vender;


import com.lumtec.computo.Producto;
import com.lumtec.computo.Tiempo;
import ConexionBD.Conexion;
import java.sql.*;

public class VentaDAOJDBC implements VentaDAO {

    private Connection conexionTransaccional;

    public VentaDAOJDBC() {
    }

    public VentaDAOJDBC(Connection con) {
        this.conexionTransaccional = con;
    }

    @Override
    public void vender(Producto prod, int cantidad, float totalVenta) {

        Connection con;
        PreparedStatement pps;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("INSERT INTO ventas (nombre_producto, precio_venta, cantidad, fecha, mesVenta, añoVenta, ganancia, reinversion, modelo) VALUES (?,?,?,?,?,?,?,?,?)");

            pps.setString(1, prod.getNombreProducto());
            pps.setFloat(2, totalVenta);
            pps.setInt(3, cantidad);
            pps.setString(4, Tiempo.getFecha());
            pps.setString(5, Tiempo.getMes());
            pps.setString(6, Tiempo.getAño());
            pps.setDouble(7, prod.calcularGanacia(cantidad));
            pps.setDouble(8, prod.calcularReinversion(cantidad));
            pps.setString(9, prod.getModelo());
            pps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }

}
