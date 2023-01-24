package com.lumtec.computo.Faltantes;

import com.lumtec.computo.Faltante;
import com.lumtec.computo.test;
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
    public Faltante select(int id) {
        Faltante falt = new Faltante();
        Connection con = null;
        PreparedStatement pps;
        ResultSet rs;

        try {
            con = conexionTransaccional != null ? this.conexionTransaccional : test.getConnection();
            pps = con.prepareStatement("SELECT * FROM faltantes WHERE id_producto = ?");
            pps.setInt(1, id);
            rs = pps.executeQuery();
            if (rs.next()) {
                falt.setId_producto(rs.getInt("id_producto"));
                falt.setNombre_producto(rs.getString("nombre_producto"));
                falt.setMarca(rs.getString("marca"));
                falt.setColor(rs.getString("color"));
                falt.setModelo(rs.getString("modelo"));
                falt.setCantidad(rs.getInt("cantidad"));
                falt.setDescripcion(rs.getString("descripcion"));
                falt.setPrecio_compra(rs.getFloat("precio_compra"));
                falt.setProvedor(rs.getString("provedor"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (this.conexionTransaccional == null) {
                test.close(con);
            }
        }
        return falt;
    }

    @Override
    public int getCantidad(int id) {

        Connection con = null;
        PreparedStatement pps;
        ResultSet rs;
        int cantidad = 0;
        try {
            con = test.getConnection();
            pps = con.prepareStatement("SELECT cantidad FROM faltantes WHERE id_producto = " + id + "");
            rs = pps.executeQuery();
            if (rs.next()) {
                cantidad = rs.getInt("cantidad");
            }
        } catch (SQLException ex) {
            System.out.println("Error en el método getCantidad(), obteniendo de 'faltantes' la cantidad");
        } finally {

            test.close(con);

        }
        return cantidad;
    }

    @Override
    public void nuevoFaltante(Faltante falt) {
        Connection con;
        PreparedStatement pps;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : test.getConnection();
            pps = con.prepareStatement("INSERT INTO faltantes (nombre_producto, marca, color, modelo, cantidad, descripcion, precio_compra, provedor) VALUES(?,?,?,?,?,?,?,?)");

            pps.setString(1, falt.getNombre_producto());
            pps.setString(2, falt.getMarca());
            pps.setString(3, falt.getColor());
            pps.setString(4, falt.getModelo());
            pps.setInt(5, falt.getCantidad());
            pps.setString(6, falt.getDescripcion());
            pps.setFloat(7, falt.getPrecio_compra());
            pps.setString(8, falt.getProvedor());
            System.out.println("1");
            pps.execute();
            System.out.println("2");
            JOptionPane.showMessageDialog(null, "Faltante Agregado");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void editar(int id, Faltante falt) {
        Connection con;
        PreparedStatement pps;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : test.getConnection();
            pps = con.prepareStatement("UPDATE faltantes SET nombre_producto = ?, marca = ? , color = ?, modelo = ?, cantidad = ?, descripcion = ?, precio_compra = ?, provedor = ?  WHERE id_producto = '" + id + "'");
            pps.setString(1, falt.getNombre_producto());
            pps.setString(2, falt.getMarca());
            pps.setString(3, falt.getColor());
            pps.setString(4, falt.getModelo());
            pps.setInt(5, falt.getCantidad());
            pps.setString(6, falt.getDescripcion());
            pps.setFloat(7, falt.getPrecio_compra());
            pps.setString(8, falt.getProvedor());
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Faltante Actualizado");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void calcularGasto(int id) {

        Connection con = null;
        PreparedStatement pps;

        Faltante falt = select(id);

        float totalCompra = falt.getCantidad() * falt.getPrecio_compra();
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : test.getConnection();
            pps = con.prepareStatement("UPDATE faltantes SET precio_total = ? WHERE id_producto = '" + id + "'");
            pps.setFloat(1, totalCompra);
            pps.executeUpdate();
        } catch (SQLException ex) {

        } finally {
            test.close(con);
        }
    }

    @Override
    public void eliminarFaltante(int id) {
        Connection con;
        PreparedStatement pps;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : test.getConnection();
            pps = con.prepareStatement("DELETE FROM faltantes WHERE id_producto = '" + id + "'");
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
            con = this.conexionTransaccional != null ? this.conexionTransaccional : test.getConnection();
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
    public void editarCantidad(int id, int cantidad) {
        Connection con;
        PreparedStatement pps;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : test.getConnection();
            pps = con.prepareStatement("UPDATE faltantes SET cantidad = ?  WHERE id_Producto = " + id + "");
            pps.setInt(1, cantidad);
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Faltante Actualizado");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
