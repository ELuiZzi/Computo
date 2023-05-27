package com.lumtec.computo;

import com.lumtec.computo.Paneles.EditarPanel;
import com.lumtec.computo.Paneles.NuevoFaltantePanel;
import com.lumtec.computo.Paneles.VenderPanel;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Shortcuts {

    static String nombre;
    private RowSorter<? extends TableModel> rowSorter;
    private DefaultTableModel model;

    public void editarProducto(JTable table) {

        rowSorter = table.getRowSorter();

        model = (DefaultTableModel) rowSorter.getModel();

        int modelIndex = table.convertRowIndexToModel(table.getSelectedRow());

        nombre = model.getValueAt(modelIndex, 0).toString();

        Go.to(new EditarPanel(0, nombre));

    }

    public void editarFaltante(JTable table) {

        rowSorter = table.getRowSorter();

        model = (DefaultTableModel) rowSorter.getModel();

        int modelIndex = table.convertRowIndexToModel(table.getSelectedRow());
        
        nombre = model.getValueAt(modelIndex, 0).toString();

        Go.to(new NuevoFaltantePanel(0, nombre));

    }

    public void sell(JTable table) {
        rowSorter = table.getRowSorter();

        model = (DefaultTableModel) rowSorter.getModel();

        int modelIndex = table.convertRowIndexToModel(table.getSelectedRow());
        
        nombre = model.getValueAt(modelIndex, 0).toString();

        Go.to(new VenderPanel(0, nombre));
    }

}
