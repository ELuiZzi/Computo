package com.lumtec.computo.Inventario;

import com.lumtec.computo.Faltantes.FaltantesDAO;
import com.lumtec.computo.Faltantes.FaltantesDAOJDBC;
import com.lumtec.computo.Producto;
import ConexionBD.Conexion;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class InventarioDAOJDBC implements InventarioDAO {

    Producto producto;
    FaltantesDAO falt = new FaltantesDAOJDBC();
    private Connection conexionTransaccional;

    private static boolean existeProducto;

    public InventarioDAOJDBC(Connection conexion) {
        this.conexionTransaccional = conexion;
    }

    public InventarioDAOJDBC() {

    }

    @Override
    public void insertar(Producto prod) {
        Connection con = null;
        PreparedStatement pps = null;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
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
            //Cerrar Conexiones
            Conexion.close(con);
            Conexion.close(pps);

            //Resetear Producto
            prod.reset();
        }

    }

    @Override
    public void eliminarProducto(int id) {
        Connection con;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();

            PreparedStatement pps = con.prepareStatement("DELETE from inventario WHERE id_producto=" + id + "");
            pps.executeUpdate();
            pps = con.prepareStatement("alter table inventario auto_increment = " + id + "");
            pps.execute();
        } catch (SQLException ex) {
        }

    }

    @Override
    public Producto select(int idS, String nombreS) {
        producto = new Producto();
        Connection con = null;
        PreparedStatement pps = null;
        ResultSet rs = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("SELECT * FROM inventario WHERE ID = " + idS + " OR  NOMBRE = '" + nombreS + "'");
            rs = pps.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("NOMBRE");
                String marca = rs.getString("MARCA");
                String color = rs.getString("COLOR");
                String modelo = rs.getString("MODELO");
                String descripcion = rs.getString("DESCRIPCION");
                String provedor = rs.getString("PROVEDOR");
                String garantia = rs.getString("GARANTIA");
                float precioCompra = rs.getFloat("PRECIO_COMPRA");
                float precioVenta = rs.getFloat("PRECIO_VENTA");
                float porcentajeGanancia = rs.getFloat("PORCENTAJE_GANANCIA");
                float porcentajeReinversion = rs.getFloat("PORCENTAJE_REINVERSION");
                float ganancia = rs.getFloat("GANANCIA");
                float reinversion = rs.getFloat("REINVERSION");
                int cantidad = rs.getInt("CANTIDAD");
                int id = rs.getInt("ID");

                producto.setIdProducto(id);
                producto.setNombreProducto(nombre);
                producto.setMarca(marca);
                producto.setColor(color);
                producto.setModelo(modelo);
                producto.setProvedor(provedor);
                producto.setDescripcion(descripcion);
                producto.setGarantia(garantia);
                producto.setPrecioCompra(precioCompra);
                producto.setPrecioVenta(precioVenta);
                producto.setGanancia(ganancia);
                producto.setReinversion(reinversion);
                producto.setCantidad(cantidad);
                producto.setPorcentajeGanancia(porcentajeGanancia);
                producto.setPorcentajeReinversion(porcentajeReinversion);
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
        return producto;
    }

    @Override
    public void actualizar(Producto prod) {
        Connection con;
        PreparedStatement pps;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("UPDATE inventario SET NOMBRE=?, MARCA=?, MODELO=?, COLOR=?, DESCRIPCION=?, CANTIDAD=?, PRECIO_COMPRA=?, PRECIO_VENTA=?, GANANCIA=?, REINVERSION=?, PORCENTAJE_GANANCIA = ?, PORCENTAJE_REINVERSION = ?, PROVEDOR = ?, GARANTIA= ? WHERE ID = " + prod.getIdProducto() + "");
            pps.setString(1, prod.getNombreProducto());
            pps.setString(2, prod.getMarca());
            pps.setString(3, prod.getModelo());
            pps.setString(4, prod.getColor());
            pps.setString(5, prod.getDescripcion());
            pps.setInt(6, prod.getCantidad());
            pps.setDouble(7, prod.getPrecioCompra());
            pps.setDouble(8, prod.getPrecioVenta());
            pps.setDouble(9, prod.getGanancia());
            pps.setDouble(10, prod.getReinversion());
            pps.setDouble(11, prod.getPorcentajeGanancia());
            pps.setDouble(12, prod.getPorcentajeReinversion());
            pps.setString(13, prod.getProvedor());
            pps.setString(14, prod.getGarantia());
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto Actualizado");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void venderP1(int cantidadVendida, Producto prod) {
        /*
        Se encargar de quitar del inventario el número de productos vendidos
         */

        Connection con = null;
        PreparedStatement pps = null;
        int cantidadNueva = prod.getCantidad() - cantidadVendida;
        int idProducto = prod.getIdProducto();

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();

            pps = con.prepareStatement("UPDATE inventario SET cantidad = ? WHERE id = ?");
            pps.setInt(1, cantidadNueva);
            pps.setInt(2, idProducto);
            pps.executeUpdate();
            System.out.println("Cantidad en Inventario Actualizada");
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
    public boolean verificarExistencia(Producto prod) {
        existeProducto = false;
        Connection con;
        PreparedStatement pps;
        ResultSet rs;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("SELECT * FROM inventario WHERE modelo = '" + prod.getModelo() + "' AND nombre_producto = '" + prod.getNombreProducto() + "' AND descripcion = '" + prod.getDescripcion() + "'");
            rs = pps.executeQuery();

            if (rs.next()) {
                existeProducto = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return existeProducto;
    }

    @Override
    public void insertarPrecio(Producto prod) {
        Connection conn;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            PreparedStatement pps = conn.prepareStatement("UPDATE inventario SET precio_compra = ?, precio_venta = ?, ganancia = ?, reinversion = ?, porcentajeGanancia = ?, porcentajeReinversion = ?  WHERE id_producto = " + prod.getIdProducto() + ";");
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
        }
    }

    @Override
    public void surtir(int id, String nombre, int cantidad, double precioCompra, String marca, String modelo, String color) {
        Connection con = null;
        PreparedStatement pps = null;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("UPDATE inventario SET CANTIDAD = ?, PRECIO_COMPRA = ?, MARCA = ?, MODELO = ?, COLOR = ?  WHERE ID = '" + id + "' OR NOMBRE ='" + nombre + "'");
            pps.setInt(1, cantidad);
            pps.setDouble(2, precioCompra);
            pps.setString(3, marca);
            pps.setString(4, modelo);
            pps.setString(5, color);
            pps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
                Conexion.close(pps);

            }
        }
    }

    @Override
    public int cantidadActual(int id, String nombre) {
        Connection con = null;
        PreparedStatement pps = null;
        ResultSet rs = null;
        int cantidadActual = 0;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("SELECT cantidad FROM inventario WHERE ID = " + id + " OR NOMBRE = '" + nombre + "'");
            rs = pps.executeQuery();
            if (rs.next()) {
                cantidadActual = rs.getInt("cantidad");
            }
        } catch (SQLException ex) {
            System.out.println("Error en método cantidadActual(), seleccionando la cantidad");
        } finally {
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
                Conexion.close(pps);
                Conexion.close(rs);
            }
        }
        return cantidadActual;
    }

    @Override
    public float getInversion() {
        float inversionTotal = 0;
        float inversion;
        int cantidad;
        Connection con;
        PreparedStatement pps;
        ResultSet rs;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("SELECT precio_compra, cantidad FROM inventario");
            rs = pps.executeQuery();
            while (rs.next()) {
                inversion = rs.getFloat(1);
                cantidad = rs.getInt(2);

                //Multiplicar la cantidad por el precio
                float gasto = cantidad * inversion;

                inversionTotal = inversionTotal + gasto;

            }
        } catch (SQLException ex) {

        }
        return inversionTotal;
    }

    @Override
    public float getMaxVentas() {
        float ventasTotal = 0;
        float venta;
        int cantidad;
        Connection con;
        PreparedStatement pps;
        ResultSet rs;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("SELECT precio_venta, cantidad FROM inventario");
            rs = pps.executeQuery();
            while (rs.next()) {
                venta = rs.getFloat(1);
                cantidad = rs.getInt(2);

                //Multiplicar la cantidad por el precio
                float gasto = cantidad * venta;

                ventasTotal = ventasTotal + gasto;

            }
        } catch (SQLException ex) {

        }
        return ventasTotal;
    }
    
       

}
