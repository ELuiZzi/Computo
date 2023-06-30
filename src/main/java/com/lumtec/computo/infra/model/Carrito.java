package com.lumtec.computo.infra.model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class Carrito {

    public static List<String[]> carrito = new ArrayList();

    public void cargarCarrito(DefaultTableModel modelo) {
        for (int n = 0; n < Carrito.carrito.size(); n++) {
            modelo.addRow(Carrito.carrito.get(n));
        }
    }

    public void vaciarCarrito(DefaultTableModel modelo, JLabel precioTotal) {
        Carrito.carrito.clear();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
        precioTotal.setText("$-----");
    }

    public static void añadirProducto(String[] elementos) {
        Carrito.carrito.add(elementos);
    }


}
