package com.lumtec.computo.infra;

import com.lumtec.computo.infra.dao.ProvedorDAO;
import com.lumtec.computo.infra.dao.ProvedorDAOJDBC;
import com.lumtec.computo.infra.model.Provedor;
import com.lumtec.computo.paneles.EditarPanel;
import com.lumtec.computo.paneles.NuevoFaltantePanel;
import com.lumtec.computo.paneles.VenderPanel;
import com.lumtec.computo.utils.JPAUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.List;

public class Shortcuts {

    static String nombre;
    private RowSorter<? extends TableModel> rowSorter;
    private DefaultTableModel model;

    public static List<Provedor> cargarListaProvedores() {
        ProvedorDAO provedorDAO = new ProvedorDAOJDBC(JPAUtils.getEntityManger());
        return provedorDAO.getProvedores();
    }


    public void editarProducto(JTable table) {

        rowSorter = table.getRowSorter();

        model = (DefaultTableModel) rowSorter.getModel();

        int modelIndex = table.convertRowIndexToModel(table.getSelectedRow());

        nombre = model.getValueAt(modelIndex, 0).toString();


        Go.to(new EditarPanel(nombre));

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
