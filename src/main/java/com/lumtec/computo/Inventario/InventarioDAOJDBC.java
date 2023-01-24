package com.lumtec.computo.Inventario;

import com.lumtec.computo.Faltantes.FaltantesDAO;
import com.lumtec.computo.Faltantes.FaltantesDAOJDBC;
import com.lumtec.computo.Producto;
import com.lumtec.computo.test;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InventarioDAOJDBC implements InventarioDAO {

    Producto prod;
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
            con = this.conexionTransaccional != null ? this.conexionTransaccional : test.getConnection();
            pps = con.prepareStatement("INSERT INTO inventario (nombre_producto,marca,cantidad,color,modelo,descripcion,provedor,precio_compra, precio_venta, ganancia, reinversion, porcentajeGanancia, porcentajeReinversion, garantia) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

            pps.setString(1, prod.getNombreProducto());
            pps.setString(2, prod.getMarca());
            pps.setInt(3, prod.getCantidad());
            pps.setString(4, prod.getColor());
            pps.setString(5, prod.getModelo());
            pps.setString(6, prod.getDescripcion());
            pps.setString(7, prod.getProvedor());
            pps.setFloat(8, prod.getPrecioCompra());
            pps.setFloat(9, prod.getPrecioVenta());
            pps.setFloat(10, prod.getGanancia());
            pps.setFloat(11, prod.getReinversion());
            pps.setFloat(12, prod.getPorcentajeGanancia());
            pps.setFloat(13, prod.getPorcentajeReinversion());
            pps.setString(14, prod.getGarantia());

            pps.execute();

            JOptionPane.showMessageDialog(null, "Producto Agregado Exitosamente");
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            //Cerrar Conexiones
            test.close(con);
            test.close(pps);

            //Resetear Producto
            prod.reset();
        }

    }

    @Override
    public void eliminarProducto(int id) {
        Connection con;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : test.getConnection();

            PreparedStatement pps = con.prepareStatement("DELETE from inventario WHERE id_producto=" + id + "");
            pps.executeUpdate();
            pps = con.prepareStatement("alter table inventario auto_increment = " + id + "");
            pps.execute();
        } catch (SQLException ex) {
        }

    }

    @Override
    public Producto select(Producto produ) {
        prod = new Producto();
        Connection con;
        PreparedStatement pps;
        ResultSet rs;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : test.getConnection();
            pps = con.prepareStatement("SELECT * FROM inventario WHERE id_producto= " + produ.getIdProducto() + "");
            rs = pps.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre_producto");
                String marca = rs.getString("marca");
                String color = rs.getString("color");
                String modelo = rs.getString("modelo");
                String descripcion = rs.getString("descripcion");
                String provedor = rs.getString("provedor");
                String garantia = rs.getString("garantia");
                float precioCompra = rs.getFloat("precio_compra");
                float precioVenta = rs.getFloat("precio_venta");
                float porcentajeGanancia = rs.getFloat("porcentajeGanancia");
                float porcentajeReinversion = rs.getFloat("porcentajeReinversion");
                float ganancia = rs.getFloat("ganancia");
                float reinversion = rs.getFloat("reinversion");
                int cantidad = rs.getInt("cantidad");
                int idds = rs.getInt("id_producto");

                prod.setIdProducto(idds);
                prod.setNombreProducto(nombre);
                prod.setMarca(marca);
                prod.setColor(color);
                prod.setModelo(modelo);
                prod.setProvedor(provedor);
                prod.setDescripcion(descripcion);
                prod.setGarantia(garantia);
                prod.setPrecioCompra(precioCompra);
                prod.setPrecioVenta(precioVenta);
                prod.setGanancia(ganancia);
                prod.setReinversion(reinversion);
                prod.setCantidad(cantidad);
                prod.setPorcentajeGanancia(porcentajeGanancia);
                prod.setPorcentajeReinversion(porcentajeReinversion);
            }

        } catch (SQLException ex) {
        }
        return prod;
    }

    @Override
    public void actualizar(Producto prod) {
        Connection con;
        PreparedStatement pps;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : test.getConnection();
            pps = con.prepareStatement("UPDATE inventario SET nombre_producto=?, marca=?, modelo=?, color=?, descripcion=?, cantidad=?, precio_compra=?, precio_venta=?, ganancia=?, reinversion=?, porcentajeGanancia = ?, porcentajeReinversion = ?, provedor = ?, garantia= ? WHERE id_producto = " + prod.getIdProducto() + "");
            pps.setString(1, prod.getNombreProducto());
            pps.setString(2, prod.getMarca());
            pps.setString(3, prod.getModelo());
            pps.setString(4, prod.getColor());
            pps.setString(5, prod.getDescripcion());
            pps.setInt(6, prod.getCantidad());
            pps.setFloat(7, prod.getPrecioCompra());
            pps.setFloat(8, prod.getPrecioVenta());
            pps.setFloat(9, prod.getGanancia());
            pps.setFloat(10, prod.getReinversion());
            pps.setFloat(11, prod.getPorcentajeGanancia());
            pps.setFloat(12, prod.getPorcentajeReinversion());
            pps.setString(13, prod.getProvedor());
            pps.setString(14, prod.getGarantia());
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto Actualizado");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void vender(int cantidad, Producto prod) {
        Connection con = null;
        PreparedStatement pps = null;
        int cantidad_actual = prod.getCantidad() - cantidad;
        int idProducto = prod.getIdProducto();
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : test.getConnection();
            //Restar de inventario
            pps = con.prepareStatement("UPDATE inventario SET cantidad= ? WHERE id_producto = ?");
            pps.setInt(1, cantidad_actual);
            pps.setInt(2, idProducto);
            pps.executeUpdate();
            //Sumar en faltantes
            pps = con.prepareStatement("INSERT INTO faltantes (nombre_producto, marca, color, modelo, cantidad, descripcion, precio_compra, provedor) VALUES (?,?,?,?,?,?,?,?)");
            pps.setString(1, prod.getNombreProducto());
            pps.setString(2, prod.getMarca());
            pps.setString(3, prod.getColor());
            pps.setString(4, prod.getModelo());
            pps.setInt(5, cantidad);
            pps.setString(6, prod.getDescripcion());
            pps.setFloat(7, prod.getPrecioCompra());
            pps.setString(8, prod.getProvedor());
            pps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (this.conexionTransaccional == null) {
                test.close(con);
            }
            test.close(pps);
        }

    }

    @Override
    public void venderP1(int cant, Producto prod) {
        /*
        Se encargar de quitar del inventario el número de productos vendidos
         */

        Connection con = null;
        PreparedStatement pps = null;
        int cantidadActual = prod.getCantidad() - cant;
        int idProducto = prod.getIdProducto();
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : con;

            pps = con.prepareStatement("UPDATE inventario SET cantidad= ? WHERE id_producto = ?");
            pps.setInt(1, cantidadActual);
            pps.setInt(2, idProducto);
            pps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (this.conexionTransaccional == null) {
                test.close(con);
            }
        }
    }

    @Override
    public void venderP2(int cantidad, int id, Producto prod) {
        /*
        Agregar o actualiza la lista de faltantes
         */

        Connection con = null;
        PreparedStatement pps = null;
        int cantidad_actual = prod.getCantidad() - cantidad;

        float totalVenta = cantidad * prod.getPrecioCompra();

        ResultSet rs;

        try {
            //Comprobar si en el registro de Faltantes ya está el producto
            con = conexionTransaccional != null ? this.conexionTransaccional : test.getConnection();
            pps = con.prepareStatement("SELECT * FROM faltantes WHERE id_producto = '" + id + "'");
            rs = pps.executeQuery();
            if (rs.next()) {
                try {
                    con = this.conexionTransaccional != null ? this.conexionTransaccional : con;
                    pps = con.prepareStatement("UPDATE faltantes SET  cantidad = ?  WHERE id_producto = '" + id + "'");
                    pps.setInt(1, (falt.getCantidad(prod.getIdProducto()) + cantidad));
                    pps.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            } else {
                try {
                    con = this.conexionTransaccional != null ? this.conexionTransaccional : con;
                    pps = con.prepareStatement("INSERT INTO faltantes (nombre_producto, marca, color, modelo, cantidad, descripcion, precio_compra, id_producto, provedor) VALUES (?,?,?,?,?,?,?,?,?)");
                    pps.setString(1, prod.getNombreProducto());
                    pps.setString(2, prod.getMarca());
                    pps.setString(3, prod.getColor());
                    pps.setString(4, prod.getModelo());
                    pps.setInt(5, cantidad);
                    pps.setString(6, prod.getDescripcion());
                    pps.setFloat(7, totalVenta);
                    pps.setInt(8, prod.getIdProducto());
                    pps.setString(9, prod.getProvedor());
                    pps.executeUpdate();

                } catch (SQLException ex1) {
                    Logger.getLogger(InventarioDAOJDBC.class
                            .getName()).log(Level.SEVERE, null, ex1);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        }
    }

    @Override
    public boolean verificarExistencia(Producto prod) {
        existeProducto = false;
        Connection con;
        PreparedStatement pps;
        ResultSet rs;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : test.getConnection();
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
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : test.getConnection();
            PreparedStatement pps = conn.prepareStatement("UPDATE inventario SET precio_compra = ?, precio_venta = ?, ganancia = ?, reinversion = ?, porcentajeGanancia = ?, porcentajeReinversion = ?  WHERE id_producto = " + prod.getIdProducto() + ";");
            pps.setFloat(1, prod.getPrecioCompra());
            pps.setFloat(2, prod.getPrecioVenta());
            pps.setFloat(3, prod.getGanancia());
            pps.setFloat(4, prod.getReinversion());
            pps.setFloat(5, prod.getPorcentajeGanancia());
            pps.setFloat(6, prod.getPorcentajeReinversion());
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Precio Agregado");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void surtir(int id, int cantidad) {
        Connection con;
        PreparedStatement pps;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : test.getConnection();
            pps = con.prepareStatement("UPDATE inventario SET cantidad = ? WHERE id_producto = '" + id + "'");
            pps.setInt(1, cantidad);
            pps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int cantidadActual(int id) {
        Connection con;
        PreparedStatement pps;
        ResultSet rs;
        int cantidadActual = 0;
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : test.getConnection();
            pps = con.prepareStatement("SELECT cantidad FROM inventario WHERE id_producto = " + id + "");
            rs = pps.executeQuery();
            if (rs.next()) {
                cantidadActual = rs.getInt("cantidad");
            }
        } catch (SQLException ex) {
            System.out.println("Error en método cantidadActual(), seleccionando la cantidad");
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
            con = this.conexionTransaccional != null ? this.conexionTransaccional : test.getConnection();
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
            con = this.conexionTransaccional != null ? this.conexionTransaccional : test.getConnection();
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
