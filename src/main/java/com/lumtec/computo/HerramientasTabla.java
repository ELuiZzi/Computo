package com.lumtec.computo;

import ConexionBD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class HerramientasTabla {

    public void eliminarId(String tableName, JTable tabla, Connection con, PreparedStatement pps) {

        String nombreColuma = "NOMBRE"; //Nomre de la columna, en la que se buscará el campo a eliminar
        int y = tabla.getSelectedRow();
        String nombre = tabla.getValueAt(y, 0).toString();
        System.out.println(nombre);

        int eliminar = JOptionPane.showConfirmDialog(null, "¿Eliminar Campo?");

        if (eliminar == 0) {
            try {
                con = Conexion.getConnection();
                pps = con.prepareStatement("DELETE FROM " + tableName + " WHERE " + nombreColuma + " = '" + nombre + "'");
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Faltante Eliminado");
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            } finally {
                Conexion.close(con);
                Conexion.close(pps);
            }
        } else {

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

}
