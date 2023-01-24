package com.lumtec.computo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class HerramientasTabla {

    public void eliminarId(String tableName, JTable tabla, Connection con, PreparedStatement pps) {
        int y = tabla.getSelectedRow();
        int id = Integer.parseInt(tabla.getValueAt(y, 0).toString());

        int eliminar = JOptionPane.showConfirmDialog(tabla, "¿Eliminar Campo?");

        if (eliminar == 0) {
            try {
                con = test.getConnection();
                pps = con.prepareStatement("DELETE FROM " + tableName + " WHERE id_producto = '" + id + "'");
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Faltante Eliminado");
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            } finally {
                test.close(con);
                test.close(pps);
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
