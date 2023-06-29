package com.lumtec.computo.infra.dao;


import com.lumtec.computo.infra.model.Producto;

import java.util.List;

public class FaltantesDAOJDBC implements FaltantesDAO {


    private List<Producto> listaFaltantes;

    public FaltantesDAOJDBC() {
    }

/*
    @Override
    public Producto select(int id, String nombre) {
        Producto prod = new Producto();


        try {
            con = conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("SELECT * FROM faltantes WHERE id_producto = '" + id + "' OR nombre = '" + nombre + "'");

            rs = pps.executeQuery();
            if (rs.next()) {
                prod.setId(rs.getLong("id_producto"));
                prod.setNombreProducto(rs.getString("nombre"));
                prod.setMarca(rs.getString("marca"));
                prod.setModelo(rs.getString("modelo"));
                prod.setCantidad(rs.getInt("cantidad"));
                prod.setPrecioCompra(rs.getDouble("precio_compra"));
                prod.setProvedor(rs.getString("provedor"));
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
        return prod;
    }

    @Override
    public int getCantidadActual(int id, String nombre) {

        final Connection con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        final PreparedStatement pps;
        final ResultSet rs;
        int cantidadActual = 0;
        try {
            pps = con.prepareStatement("SELECT CANTIDAD FROM faltantes WHERE id_producto = " + id + " OR NOMBRE = '" + nombre + "'");
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
    public void nuevoFaltante(Producto producto) {
        Connection con = null;
        final PreparedStatement pps;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("INSERT INTO faltantes (nombre, marca, modelo, cantidad, precio_compra, provedor, id_producto) VALUES(?,?,?,?,?,?,?)");
            try (pps) {
                pps.setString(1, producto.getNombreProducto());
                pps.setString(2, producto.getMarca());
                pps.setString(3, producto.getModelo());
                pps.setInt(4, producto.getCantidad());
                pps.setDouble(5, producto.getPrecioCompra());
                pps.setString(6, producto.getProvedor());
                pps.setInt(7, producto.getId());
                pps.execute();
                System.out.println("Faltante Agregado");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
            }
        }
    }

    @Override
    public void editar(int id, Producto prod) {
        Connection con = null;
        PreparedStatement pps = null;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("UPDATE faltantes SET nombre = ?, marca = ? , modelo = ?, cantidad = ?, precio_compra = ?, provedor = ?  WHERE id_producto = '" + id + "'");
            pps.setString(1, prod.getNombreProducto());
            pps.setString(2, prod.getMarca());
            pps.setString(4, prod.getModelo());
            pps.setInt(5, prod.getCantidad());
            pps.setDouble(7, prod.getPrecioCompra());
            pps.setString(8, prod.getProvedor());
            pps.executeUpdate();
            System.out.println("Faltante Actualizado");
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
    public void calcularGasto(int id, String nombre) {

        Connection con = null;
        PreparedStatement pps = null;

        Producto prod = select(id, nombre);

        double totalCompra = prod.getCantidad() * prod.getPrecioCompra();
        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("UPDATE faltantes SET precio_total = ? WHERE id_producto = '" + id + "'");
            pps.setDouble(1, totalCompra);
            pps.executeUpdate();
        } catch (SQLException ex) {

        } finally {
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
            }
            Conexion.close(pps);
        }
    }

    @Override
    public void eliminarFaltante(int id, String nombre) {
        Connection con = null;
        PreparedStatement pps = null;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("DELETE FROM faltantes WHERE id_producto = '" + id + "' OR nombre = '" + nombre + "'");
            pps.executeUpdate();
            System.out.println("Faltante Eliminado");
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
    public void calcularGastoTotal() {
        Connection con = null;
        PreparedStatement pps = null;
        ResultSet rs = null;

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
        } finally {
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
            }
            Conexion.close(pps);
            Conexion.close(rs);
        }

    }

    @Override
    public void updateCantidad(int id, String nombre, int cantidad) {
        Connection con = null;
        PreparedStatement pps = null;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pps = con.prepareStatement("UPDATE faltantes SET cantidad = ?  WHERE id_Producto = " + id + " OR nombre = '" + nombre + "'");
            pps.setInt(1, cantidad);
            pps.executeUpdate();
            System.out.println("Faltante Actualizado");
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
    public void disminuirCantidad(int id, String nombre, int cantidad) {
        final Connection con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        final PreparedStatement pps;

        int cantidadDisminuida = getCantidadActual(id, nombre) - cantidad;

        try {
            pps = con.prepareStatement("UPDATE faltantes SET cantidad = ?  WHERE id_Producto = " + id + " OR nombre = '" + nombre + "'");
            try (pps) {
                pps.setInt(1, cantidadDisminuida);
                System.out.println("Faltante Actualizado");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
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
            }
            Conexion.close(pps);
            Conexion.close(rs);
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
            }
            Conexion.close(pps);
            Conexion.close(rs);
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
            }
            Conexion.close(pps);
            Conexion.close(rs);
        }

        return color;
    }

    @Override
    public void vender(Producto producto, int cantidad) {

        final PreparedStatement pps;
        final ResultSet rs;

        try {
            pps = this.conexionTransaccional.prepareStatement("SELECT * FROM faltantes WHERE nombre = '" + producto.getNombreProducto() + "'");
            try (pps) {
                rs = pps.executeQuery();
                try (rs) {
                    if (rs.next()) {
                        updateCantidad(0, producto.getNombreProducto(), cantidad);
                    } else {
                        producto.setCantidad(cantidad);
                        nuevoFaltante(producto);
                    }
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public List<Producto> listar() {
        listaFaltantes = new ArrayList<>();

        final Connection con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        final PreparedStatement pps;
        final ResultSet rs;
        try (con) {
            pps = con.prepareStatement("SELECT nombre, provedor, modelo, cantidad, precio_compra FROM faltantes");
            try (pps) {
                rs = pps.executeQuery();
                try (rs) {
                    while (rs.next()) {
                        listaFaltantes.add(new Producto(
                                rs.getString("nombre"),
                                rs.getString("provedor"),
                                rs.getString("modelo"),
                                rs.getInt("cantidad"),
                                rs.getDouble("precio_compra"),
                                rs.getInt("cantidad") * rs.getDouble("precio_compra")
                        ));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return listaFaltantes;
    }

    @Override
    public void surtir(Producto producto) {
        final Connection con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        final PreparedStatement pps;
        try {
            pps = con.prepareStatement("UPDATE faltantes SET CANTIDAD = ? WHERE nombre ='" + producto.getNombreProducto() + "'");
            try (pps) {
                pps.setInt(1, producto.getCantidad());
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
    public String getFaltanteTotal() {
        Connection con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        String reinversionTotal = null;
        final PreparedStatement pps;
        final ResultSet rs;
        try {
            pps = con.prepareStatement("SELECT SUM(precio_total) FROM faltantes");
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
    }*/

}
