package com.lumtec.computo.controllers;

import com.lumtec.computo.infra.HerramientasTabla;
import com.lumtec.computo.infra.dao.ProductoDAO;
import com.lumtec.computo.infra.dao.ProductoDAOJDBC;
import com.lumtec.computo.infra.model.Producto;
import com.lumtec.computo.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.List;

public class InventarioController {
    private final JTable jTable;
    private DefaultTableModel model;
    private DefaultTableCellRenderer alinear;
    private TableRowSorter<TableModel> tableRowSorter;
    private EntityManager em;
    private ProductoDAO productoDAO;

    public InventarioController(JTable jTable) {
        this.jTable = jTable;
        em = JPAUtils.getEntityManger();
        productoDAO = new ProductoDAOJDBC(em);

        model = new DefaultTableModel();
        alinear = new DefaultTableCellRenderer();
    }

    public void rellenarTabla() {

        alinear.setHorizontalAlignment(SwingConstants.CENTER);

        model.addColumn("NOMBRE");
        model.addColumn("MARCA");
        model.addColumn("MODELO");
        model.addColumn("CANTIDAD");
        model.addColumn("PRECIO");

        jTable.setModel(model);
        tableRowSorter = new TableRowSorter<>(model);
        jTable.setRowSorter(tableRowSorter);

        /**
         * Alinear las columnas
         */
        alinearColumnas(jTable);


        em.getTransaction().begin();
        List<Producto> productos = this.productoDAO.getProductosInventario();

        productos.forEach(producto -> model.addRow(
                new Object[]{
                        producto.getNombre(),
                        producto.getMarca(),
                        producto.getModelo(),
                        producto.getCantidad(),
                        producto.getPrecioVenta()
                }
        ));

        em.close();


    }

    private void alinearColumnas(JTable jTable) {

        jTable.getColumnModel().getColumn(0).setMinWidth(300);
        jTable.getColumnModel().getColumn(0).setMaxWidth(300);
        jTable.getColumnModel().getColumn(0).setCellRenderer(alinear);
        jTable.getColumnModel().getColumn(1).setMinWidth(130);
        jTable.getColumnModel().getColumn(1).setMaxWidth(130);
        jTable.getColumnModel().getColumn(1).setCellRenderer(alinear);
        jTable.getColumnModel().getColumn(2).setMinWidth(120);
        jTable.getColumnModel().getColumn(2).setMaxWidth(120);
        jTable.getColumnModel().getColumn(2).setCellRenderer(alinear);
        jTable.getColumnModel().getColumn(3).setMinWidth(70);
        jTable.getColumnModel().getColumn(3).setMaxWidth(70);
        jTable.getColumnModel().getColumn(3).setCellRenderer(alinear);
        jTable.getColumnModel().getColumn(4).setCellRenderer(alinear);
        jTable.setRowHeight(17);
    }

    public void numeroDeResultados(JLabel jLabel, JTable jTable, HerramientasTabla conf) {
        jLabel.setText("Número de Resultados: " + conf.numberRows(jTable));
    }

}
