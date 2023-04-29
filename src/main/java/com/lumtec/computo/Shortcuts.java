package com.lumtec.computo;

import com.lumtec.computo.Paneles.EditarPanel;
import com.lumtec.computo.Paneles.NuevoFaltantePanel;
import com.lumtec.computo.Paneles.VenderPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Shortcuts {
      static String nombre;

    public void editarProducto(JTable table) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        nombre = model.getValueAt(table.getSelectedRow(), 0).toString();

        Go.to(new EditarPanel(0, nombre));
        
    }
    
    public static void editarFaltante(JTable table) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        nombre = model.getValueAt(table.getSelectedRow(), 0).toString();

        Go.to(new NuevoFaltantePanel(0, nombre));
        
    }

    public void sell(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        
        nombre = model.getValueAt(table.getSelectedRow(), 0).toString();

        Go.to(new VenderPanel(0, nombre));
    }

}
