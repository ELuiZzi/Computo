package com.lumtec.computo;

import ConexionBD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class HerramientasTabla {

    public void eliminarId(String tableName, JTable tabla) {
        final Connection con = Conexion.getConnection();
        final PreparedStatement pps;

        String nombreColuma = "NOMBRE"; //Nomre de la columna, en la que se buscará el campo a eliminar
        int y = tabla.getSelectedRow();
        String nombre = tabla.getValueAt(y, 0).toString();
        System.out.println(nombre);

        int eliminar = JOptionPane.showConfirmDialog(null, "¿Eliminar Campo?");

        if (eliminar == 0) {
            try (con) {
                pps = con.prepareStatement("DELETE FROM " + tableName + " WHERE " + nombreColuma + " = '" + nombre + "'");
                try (pps) {
                    pps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Faltante Eliminado");
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

    }

    /*
    Este método te devuelve el número de filas que tiene una tabla.
    Usos: Saber el número de productos, o faltantes de una tabla.
     */
    public int numberRows(JTable table) {

        int numbRows;

        numbRows = table.getRowCount();

        return numbRows;
    }

    public static void vaciarCajasTexto(List<JTextField> lista) {
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).setText(null);
        }
    }
}
