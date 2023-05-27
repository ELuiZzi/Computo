package com.lumtec.computo.Vender;

import com.lumtec.computo.Producto;
import com.lumtec.computo.Tiempo;
import ConexionBD.Conexion;
import com.lumtec.computo.Venta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaDAOJDBC implements VentaDAO {

    private Connection conexionTransaccional;
    private List<Venta> listaVentas, listaVentasMensual;
    private List<String> listadoFinanzas;

    public VentaDAOJDBC() {
        this.listadoFinanzas = new ArrayList();
    }

    public VentaDAOJDBC(Connection con) {
        this.listadoFinanzas = new ArrayList();
        this.conexionTransaccional = con;
    }

    @Override
    public void vender(Producto producto, int cantidad) {

        final Connection con = this.conexionTransaccional;
        final PreparedStatement pps;

        try {
            pps = con.prepareStatement("INSERT INTO ventas (nombre_producto, precio_venta, cantidad, fecha, mesVenta, añoVenta, ganancia, reinversion, modelo) VALUES (?,?,?,?,?,?,?,?,?)");
            try (pps) {
                pps.setString(1, producto.getNombreProducto());
                pps.setDouble(2, producto.getPrecioVenta() * cantidad);
                pps.setInt(3, cantidad);
                pps.setString(4, Tiempo.getFecha());
                pps.setString(5, Tiempo.getMes());
                pps.setString(6, Tiempo.getAño());
                pps.setDouble(7, producto.calcularGanacia(cantidad));
                pps.setDouble(8, producto.calcularReinversion(cantidad));
                pps.setString(9, producto.getModelo());
                pps.executeUpdate();
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public List<Venta> listarVentas() {
        listaVentas = new ArrayList<>();
        final Connection con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        final PreparedStatement pps;
        final ResultSet rs;
        try {
            pps = con.prepareStatement("SELECT nombre_producto, modelo, fecha, precio_venta FROM ventas");
            try (pps) {
                rs = pps.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        listaVentas.add(new Venta(rs.getString("nombre_producto"),
                                rs.getString("modelo"),
                                rs.getString("fecha"),
                                rs.getDouble("precio_venta")));
                    }
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
            }
        }

        return listaVentas;
    }

    @Override
    public List<Venta> listarVentasMensuales(String mes, String año) {
        listaVentasMensual = new ArrayList<>();
        final Connection con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        final PreparedStatement pps;
        final ResultSet rs;
        try {
            pps = con.prepareStatement("SELECT nombre_producto, fecha, precio_venta, reinversion, ganancia FROM ventas WHERE mesVenta = '" + mes + "' AND añoVenta ='" + año + "'");
            try (pps) {
                rs = pps.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        listaVentasMensual.add(new Venta(rs.getString("nombre_producto"),
                                rs.getString("fecha"),
                                rs.getDouble("precio_venta"),
                                rs.getDouble("reinversion"),
                                rs.getDouble("ganancia")));
                    }
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
            }
        }

        return listaVentasMensual;
    }

    @Override
    public String getTotalVendido(String mes, String año) {
        Connection con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        String totalVendido = null;
        final PreparedStatement pps;
        final ResultSet rs;
        try {
            pps = con.prepareStatement("SELECT SUM(precio_venta) FROM ventas WHERE mesVenta = '" + mes + "' AND añoVenta = '" + año + "'");
            try (pps) {
                rs = pps.executeQuery();
                try (rs) {
                    if (rs.next()) {
                        totalVendido = rs.getString(1);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return totalVendido;
    }

    @Override
    public String getGananciaTotal(String mes, String año) {
        Connection con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        String gananciaTotal = null;
        final PreparedStatement pps;
        final ResultSet rs;
        try {
            pps = con.prepareStatement("SELECT SUM(ganancia) FROM ventas WHERE mesVenta = '" + mes + "' AND añoVenta = '" + año + "'");
            try (pps) {
                rs = pps.executeQuery();
                try (rs) {
                    if (rs.next()) {
                        gananciaTotal = rs.getString(1);
                    }

                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return gananciaTotal;
    }

    @Override
    public String getReinversionTotal(String mes, String año) {
        Connection con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        String reinversionTotal = null;
        final PreparedStatement pps;
        final ResultSet rs;
        try {
            pps = con.prepareStatement("SELECT SUM(reinversion) FROM ventas WHERE mesVenta = '" + mes + "' AND añoVenta = '" + año + "'");
            try (pps) {
                rs = pps.executeQuery();
                try (rs) {
                    if (rs.next()) {
                        reinversionTotal = rs.getString(1);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return reinversionTotal;
    }

    public List<String> listadoFinanzas(String mes, String año) {
        this.conexionTransaccional = Conexion.getConnection();

        this.listadoFinanzas.add(this.getTotalVendido(mes, año));
        this.listadoFinanzas.add(this.getGananciaTotal(mes, año));
        this.listadoFinanzas.add(this.getReinversionTotal(mes, año));

        Conexion.close(conexionTransaccional);

        return this.listadoFinanzas;
    }
}
