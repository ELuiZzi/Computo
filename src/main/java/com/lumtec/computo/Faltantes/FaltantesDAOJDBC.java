package com.lumtec.computo.Faltantes;

import ConexionBD.Conexion;
import com.lumtec.computo.Producto;
import java.sql.*;
import javax.swing.JOptionPane;

public class FaltantesDAOJDBC implements FaltantesDAO {

    Connection conexionTransaccional;

    public FaltantesDAOJDBC() {
    }

    public FaltantesDAOJDBC(Connection con) {
        this.conexionTransaccional = con;
    }

    @Override
    public Producto select(int id, String nombre) {
        Producto prod = new Producto();
        Connection con = null;
        PreparedStatement pps;
        ResultSet rs;

        try {
            con = conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("SELECT * FROM faltantes WHERE id_producto = '" + id + "' OR nombre = '" + nombre + "'");

            rs = pps.executeQuery();
            if (rs.next()) {
                prod.setIdProducto(rs.getInt("id_producto"));
                prod.setNombreProducto(rs.getString("nombre"));
                prod.setMarca(rs.getString("marca"));
                prod.setColor(rs.getString("color"));
                prod.setModelo(rs.getString("modelo"));
                prod.setCantidad(rs.getInt("cantidad"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecioCompra(rs.getDouble("precio_compra"));
                prod.setProvedor(rs.getString("provedor"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
            }
        }
        return prod;
    }

    @Override
    public int getCantidad(int id, String nombre) {

        Connection con = null;
        PreparedStatement pps = null;
        ResultSet rs = null;
        int cantidad = 0;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();;
            pps = con.prepareStatement("SELECT cantidad FROM faltantes WHERE id_producto = " + id + " OR nombre = '" + nombre + "'");
            rs = pps.executeQuery();
            if (rs.next()) {
                cantidad = rs.getInt("cantidad");
            }
        } catch (SQLException ex) {
            System.out.println("Error en el método getCantidad(), obteniendo de 'faltantes' la cantidad");
        } finally {
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
                Conexion.close(pps);
                Conexion.close(rs);
            }

        }
        return cantidad;
    }

    @Override
    public void nuevoFaltante(Producto prod) {
        Connection con;
        PreparedStatement pps;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("INSERT INTO faltantes (nombre, marca, color, modelo, cantidad, descripcion, precio_compra, provedor, id_producto) VALUES(?,?,?,?,?,?,?,?,?)");

            pps.setString(1, prod.getNombreProducto());
            pps.setString(2, prod.getMarca());
            pps.setString(3, prod.getColor());
            pps.setString(4, prod.getModelo());
            pps.setInt(5, prod.getCantidad());
            pps.setString(6, prod.getDescripcion());
            pps.setDouble(7, prod.getPrecioCompra());
            pps.setString(8, prod.getProvedor());
            pps.setInt(9, prod.getIdProducto());
            System.out.println("1");
            pps.execute();
            System.out.println("2");
            JOptionPane.showMessageDialog(null, "Faltante Agregado");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void editar(int id, Producto prod) {
        Connection con;
        PreparedStatement pps;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("UPDATE faltantes SET nombre = ?, marca = ? , color = ?, modelo = ?, cantidad = ?, descripcion = ?, precio_compra = ?, provedor = ?  WHERE id_producto = '" + id + "'");
            pps.setString(1, prod.getNombreProducto());
            pps.setString(2, prod.getMarca());
            pps.setString(3, prod.getColor());
            pps.setString(4, prod.getModelo());
            pps.setInt(5, prod.getCantidad());
            pps.setString(6, prod.getDescripcion());
            pps.setDouble(7, prod.getPrecioCompra());
            pps.setString(8, prod.getProvedor());
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Faltante Actualizado");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void calcularGasto(int id, String nombre) {

        Connection con = null;
        PreparedStatement pps;

        Producto prod = select(id, nombre);

        double totalCompra = prod.getCantidad() * prod.getPrecioCompra();
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("UPDATE faltantes SET precio_total = ? WHERE id_producto = '" + id + "'");
            pps.setDouble(1, totalCompra);
            pps.executeUpdate();
        } catch (SQLException ex) {

        } finally {
            Conexion.close(con);
        }
    }

    @Override
    public void eliminarFaltante(int id, String nombre) {
        Connection con;
        PreparedStatement pps;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("DELETE FROM faltantes WHERE id_producto = '" + id + "' OR nombre = '" + nombre + "'");
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Faltante Eliminado");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void calcularGastoTotal() {
        Connection con;
        PreparedStatement pps;
        ResultSet rs;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("SELECT * FROM faltantes");
            rs = pps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_producto");
                int cantidad = rs.getInt("cantidad");

                float precioCompra = rs.getFloat("precio_compra");
                float totalCompra = cantidad * precioCompra;
                pps = con.prepareStatement("UPDATE faltantes SET precio_total = ? WHERE id_producto = '" + id + "'");
                pps.setFloat(1, totalCompra);
                pps.executeUpdate();

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }

    /*
    Verificar Cambios
     */
    @Override
    public void acumularCantidad(int id, String nombre, int cantidad) {
        Connection con = null;
        PreparedStatement pps = null;

        int cantidadAcumulada = getCantidad(id, nombre) + cantidad;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("UPDATE faltantes SET cantidad = ?  WHERE id_Producto = " + id + " OR nombre = '" + nombre + "'");
            pps.setInt(1, cantidadAcumulada);
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Faltante Actualizado");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
                Conexion.close(pps);
            }
        }
    }

    @Override
    public void disminuirCantidad(int id, String nombre, int cantidad) {
        Connection con = null;
        PreparedStatement pps = null;

        int cantidadDisminuida = getCantidad(id, nombre) - cantidad;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("UPDATE faltantes SET cantidad = ?  WHERE id_Producto = " + id + " OR nombre = '" + nombre + "'");
            pps.setInt(1, cantidadDisminuida);
            JOptionPane.showMessageDialog(null, "Faltante Actualizado");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
                Conexion.close(pps);
            }
        }
    }

    @Override
    public String getMarca(int id, String nombre) {
        Connection con = null;
        PreparedStatement pps = null;
        ResultSet rs = null;
        String marca = null;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("SELECT marca FROM faltantes WHERE id_producto = '" + id + "' OR nombre = '" + nombre + "'");
            rs = pps.executeQuery();
            if (rs.next()) {
                marca = rs.getString("marca");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
                Conexion.close(pps);
                Conexion.close(rs);
            }

        }

        return marca;
    }

    @Override
    public String getModelo(int id, String nombre) {
        Connection con = null;
        PreparedStatement pps = null;
        ResultSet rs = null;
        String modelo = null;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("SELECT modelo FROM faltantes WHERE id_producto = '" + id + "' OR nombre = '" + nombre + "'");
            rs = pps.executeQuery();
            if (rs.next()) {
                modelo = rs.getString("modelo");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
                Conexion.close(pps);
                Conexion.close(rs);
            }

        }

        return modelo;
    }

    @Override
    public String getColor(int id, String nombre) {
        Connection con = null;
        PreparedStatement pps = null;
        ResultSet rs = null;
        String color = null;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("SELECT color FROM faltantes WHERE id_producto = '" + id + "' OR nombre = '" + nombre + "'");
            rs = pps.executeQuery();
            if (rs.next()) {
                color = rs.getString("color");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
                Conexion.close(pps);
                Conexion.close(rs);
            }

        }

        return color;
    }

    @Override
    public void venderP2(int id, Producto prod, int cantidad) {
        /*
        Agregar o actualiza la lista de faltantes
         */

        Connection con = null;
        PreparedStatement pps = null;
        ResultSet rs = null;

        double totalVenta = cantidad * prod.getPrecioCompra();

        try {
            //Comprobar si en el registro de Faltantes ya está el producto
            con = conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("SELECT * FROM faltantes WHERE id_producto = '" + id + "'");
            rs = pps.executeQuery();
            if (rs.next()) {
                acumularCantidad(id, prod.getNombreProducto(), cantidad);
            } else {
                prod.setCantidad(cantidad);
                nuevoFaltante(prod);
            }

        } catch (SQLException ex) {

        } finally {
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
                Conexion.close(pps);
                Conexion.close(rs);
            }

        }
    }

}
