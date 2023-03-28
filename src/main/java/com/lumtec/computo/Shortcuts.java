package com.lumtec.computo;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Shortcuts {


    public void editProd(JTable table) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        int id = Integer.parseInt((String) model.getValueAt(table.getSelectedRow(), 0));

    }

    public void sell(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        int id = Integer.parseInt((String) model.getValueAt(table.getSelectedRow(), 0));

     
    }

}
