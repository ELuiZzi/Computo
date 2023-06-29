package com.lumtec.computo.infra.model;


public class ConexionMultiple {

    public void surtir(Producto producto, int cantidad) {


       /* InventarioDAO inventario;
        FaltantesDAO faltantes = new FaltantesDAOJDBC(con);

        int cantidadInventario = inventario.getCantidadActual(0, producto.getNombreProducto()) + cantidad;
        int cantidadFaltantes = faltantes.getCantidadActual(0, producto.getNombreProducto()) - cantidad;

        try (con) {
            con.setAutoCommit(false);
            //Agregar producto al inventario
            producto.setCantidad(cantidadInventario);
            inventario.surtir(producto);
            //Restar producto de faltantes
            producto.setCantidad(cantidadFaltantes);
            faltantes.surtir(producto);

            //Comprobar cantidad de faltantes en la tabla faltantes
            if (faltantes.getCantidadActual(0, producto.getNombreProducto()) <= 0) {
                faltantes.eliminarFaltante(0, producto.getNombreProducto());
            }

            con.commit();

        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

    }

    public void vender(String nombre, int cantidad) {
        final Connection con = Conexion.getConnection();

        InventarioDAO inventario = new InventarioDAOJDBC(con);
        FaltantesDAO faltantes = new FaltantesDAOJDBC(con);
        VentaDAO ventas = new VentaDAOJDBC(con);

        var producto = inventario.select(0, nombre);

        int cantidadInventario = inventario.getCantidadActual(0, producto.getNombreProducto()) - cantidad;
        int cantidadFaltantes = faltantes.getCantidadActual(0, producto.getNombreProducto()) + cantidad;
        try (con) {
            con.setAutoCommit(false);

            // Quita del inve los productos vendidos.
            inventario.vender(producto, cantidadInventario);

            //Acumular la cantidad en faltantes
            faltantes.vender(producto, cantidadFaltantes);

            ventas.vender(producto, cantidad);

            con.commit();
            JOptionPane.showMessageDialog(null, "Venta Exitosa");
        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    */
    }
}