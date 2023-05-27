package com.lumtec.computo.Inventario;

import com.lumtec.computo.Producto;
import ConexionBD.Conexion;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class InventarioDAOJDBC implements InventarioDAO {

    Producto producto;

    List<Producto> lista;

    private Connection conexionTransaccional;

    private static boolean existeProducto;

    public InventarioDAOJDBC(Connection conexion) {
        this.conexionTransaccional = conexion;
    }

    public InventarioDAOJDBC() {

    }

    @Override
    public void insertar(Producto prod) {
        final Connection con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        PreparedStatement pps = null;

        try (con) {

            pps = con.prepareStatement("INSERT INTO inventario (NOMBRE,MARCA,CANTIDAD,COLOR,MODELO,DESCRIPCION,PROVEDOR,PRECIO_COMPRA, PRECIO_VENTA, GANANCIA, REINVERSION, PORCENTAJE_GANANCIA, PORCENTAJE_REINVERSION, GARANTIA) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

            pps.setString(1, prod.getNombreProducto());
            pps.setString(2, prod.getMarca());
            pps.setInt(3, prod.getCantidad());
            pps.setString(4, prod.getColor());
            pps.setString(5, prod.getModelo());
            pps.setString(6, prod.getDescripcion());
            pps.setString(7, prod.getProvedor());
            pps.setDouble(8, prod.getPrecioCompra());
            pps.setDouble(9, prod.getPrecioVenta());
            pps.setDouble(10, prod.getGanancia());
            pps.setDouble(11, prod.getReinversion());
            pps.setDouble(12, prod.getPorcentajeGanancia());
            pps.setDouble(13, prod.getPorcentajeReinversion());
            pps.setString(14, prod.getGarantia());

            pps.execute();

            JOptionPane.showMessageDialog(null, "Producto Agregado Exitosamente");
        } catch (SQLException ex) {
            if (ex.getMessage().equals("Duplicate entry 'BD' for key 'inventario.NOMBRE_UNIQUE'")) {
                JOptionPane.showMessageDialog(null, "El nombre ya existe en la BD");
            }
            ex.printStackTrace();

        } finally {

            Conexion.close(pps);
            //Resetear Producto
            prod.reset();
        }

    }

    @Override
    public Producto select(int id, String nombreS) {
        producto = new Producto();
        final Connection con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        final PreparedStatement pps;
        final ResultSet rs;
        try {
            pps = con.prepareStatement("SELECT * FROM inventario WHERE ID = " + id + " OR  NOMBRE = '" + nombreS + "'");
            try (pps) {
                rs = pps.executeQuery();
                try (rs) {
                    if (rs.next()) {

                        producto.setIdProducto(rs.getInt("ID"));
                        producto.setNombreProducto(rs.getString("NOMBRE"));
                        producto.setMarca(rs.getString("MARCA"));
                        producto.setColor(rs.getString("COLOR"));
                        producto.setModelo(rs.getString("MODELO"));
                        producto.setProvedor(rs.getString("PROVEDOR"));
                        producto.setDescripcion(rs.getString("DESCRIPCION"));
                        producto.setGarantia(rs.getString("GARANTIA"));
                        producto.setPrecioCompra(rs.getDouble("PRECIO_COMPRA"));
                        producto.setPrecioVenta(rs.getDouble("PRECIO_VENTA"));
                        producto.setGanancia(rs.getDouble("GANANCIA"));
                        producto.setReinversion(rs.getDouble("REINVERSION"));
                        producto.setCantidad(rs.getInt("CANTIDAD"));
                        producto.setPorcentajeGanancia(rs.getDouble("PORCENTAJE_GANANCIA"));
                        producto.setPorcentajeReinversion(rs.getDouble("PORCENTAJE_REINVERSION"));
                    }
                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
            }
        }
        return producto;
    }

    @Override
    public void actualizar(Producto producto) {
        final Connection con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        final PreparedStatement pps;
        try (con) {
            pps = con.prepareStatement("UPDATE inventario SET NOMBRE=?, MARCA=?, MODELO=?, COLOR=?, DESCRIPCION=?,"
                    + "CANTIDAD=?, PRECIO_COMPRA=?, PRECIO_VENTA=?, GANANCIA=?, REINVERSION=?, PORCENTAJE_GANANCIA = ?,"
                    + "PORCENTAJE_REINVERSION = ?, PROVEDOR = ?, GARANTIA= ? WHERE ID = " + producto.getIdProducto() + "");
            try (pps) {
                pps.setString(1, producto.getNombreProducto());
                pps.setString(2, producto.getMarca());
                pps.setString(3, producto.getModelo());
                pps.setString(4, producto.getColor());
                pps.setString(5, producto.getDescripcion());
                pps.setInt(6, producto.getCantidad());
                pps.setDouble(7, producto.getPrecioCompra());
                pps.setDouble(8, producto.getPrecioVenta());
                pps.setDouble(9, producto.getGanancia());
                pps.setDouble(10, producto.getReinversion());
                pps.setDouble(11, producto.getPorcentajeGanancia());
                pps.setDouble(12, producto.getPorcentajeReinversion());
                pps.setString(13, producto.getProvedor());
                pps.setString(14, producto.getGarantia());
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Producto Actualizado");
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void vender(Producto producto, int cantidad) {

        Connection con = this.conexionTransaccional;
        final PreparedStatement pps;

        try {
            pps = con.prepareStatement("UPDATE inventario SET CANTIDAD = ? WHERE nombre = '" + producto.getNombreProducto() + "'");
            try (pps) {
                pps.setInt(1, cantidad);
                pps.executeUpdate();
                System.out.println("Cantidad en Inventario Actualizada");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public boolean verificarExistencia(Producto prod) {
        existeProducto = false;
        Connection con = null;
        PreparedStatement pps = null;
        ResultSet rs = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("SELECT * FROM inventario WHERE MODELO = '" + prod.getModelo() + "' AND nombre_producto = '" + prod.getNombreProducto() + "' AND descripcion = '" + prod.getDescripcion() + "'");
            rs = pps.executeQuery();

            if (rs.next()) {
                existeProducto = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
            }
            Conexion.close(pps);
            Conexion.close(rs);
        }

        return existeProducto;
    }

    @Override
    public void insertarPrecio(Producto prod) {
        Connection con = null;
        PreparedStatement pps = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("UPDATE inventario SET PRECIO_COMPRA = ?, PRECIO_VENTA = ?, GANANCIA = ?, REINVERSION = ?, PORCENTAJE_GANANCIA = ?, PORCENTAJE_REINVERSION = ?  WHERE id_producto = " + prod.getIdProducto() + ";");
            pps.setDouble(1, prod.getPrecioCompra());
            pps.setDouble(2, prod.getPrecioVenta());
            pps.setDouble(3, prod.getGanancia());
            pps.setDouble(4, prod.getReinversion());
            pps.setDouble(5, prod.getPorcentajeGanancia());
            pps.setDouble(6, prod.getPorcentajeReinversion());
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Precio Agregado");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
            }
            Conexion.close(pps);

        }
    }

    @Override
    public void surtir(Producto producto) {
        final Connection con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        final PreparedStatement pps;
        try {
            pps = con.prepareStatement("UPDATE inventario SET CANTIDAD = ?, PRECIO_COMPRA = ?, MARCA = ?, MODELO = ?, COLOR = ?  WHERE NOMBRE ='" + producto.getNombreProducto() + "'");
            try (pps) {
                pps.setInt(1, producto.getCantidad());
                pps.setDouble(2, producto.getPrecioCompra());
                pps.setString(3, producto.getMarca());
                pps.setString(4, producto.getModelo());
                pps.setString(5, producto.getColor());
                pps.executeUpdate();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
            }
        }
    }

    @Override
    public int getCantidadActual(int id, String nombre) {
        final Connection con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        final PreparedStatement pps;
        final ResultSet rs;
        int cantidadActual = 0;
        try {
            pps = con.prepareStatement("SELECT CANTIDAD FROM inventario WHERE ID = " + id + " OR NOMBRE = '" + nombre + "'");
            try (pps) {
                rs = pps.executeQuery();
                try (rs) {
                    if (rs.next()) {
                        cantidadActual = rs.getInt("cantidad");
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
        return cantidadActual;
    }

    @Override
    public float getInversion() {
        float inversionTotal = 0;
        float inversion;
        int cantidad;
        Connection con = null;
        PreparedStatement pps = null;
        ResultSet rs = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("SELECT PRECIO_COMPRA, CANTIDAD FROM inventario");
            rs = pps.executeQuery();
            while (rs.next()) {
                inversion = rs.getFloat(1);
                cantidad = rs.getInt(2);

                //Multiplicar la cantidad por el precio
                float gasto = cantidad * inversion;

                inversionTotal = inversionTotal + gasto;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
            }
            Conexion.close(pps);
            Conexion.close(rs);
        }
        return inversionTotal;
    }

    @Override
    public float getMaxVentas() {
        float ventasTotal = 0;
        float venta;
        int cantidad;
        Connection con = null;
        PreparedStatement pps = null;
        ResultSet rs = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("SELECT PRECIO_VENTA, CANTIDAD FROM inventario");
            rs = pps.executeQuery();
            while (rs.next()) {
                venta = rs.getFloat(1);
                cantidad = rs.getInt(2);

                //Multiplicar la cantidad por el precio
                float gasto = cantidad * venta;

                ventasTotal = ventasTotal + gasto;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
            }
            Conexion.close(pps);
            Conexion.close(rs);
        }
        return ventasTotal;
    }

    public List<Producto> listar() {
        this.lista = new ArrayList<>();

        final Connection con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        final PreparedStatement pps;
        final ResultSet rs;
        try (con) {
            pps = con.prepareStatement("SELECT NOMBRE, MARCA, MODELO, CANTIDAD, PRECIO_VENTA FROM inventario");
            try (pps) {
                rs = pps.executeQuery();
                try (rs) {

                    while (rs.next()) {

                        this.lista.add(new Producto(
                                rs.getString("NOMBRE"),
                                rs.getString("MARCA"),
                                rs.getString("MODELO"),
                                rs.getInt("CANTIDAD"),
                                rs.getDouble("PRECIO_VENTA")
                        ));
                    }
                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return this.lista;

    }

}
