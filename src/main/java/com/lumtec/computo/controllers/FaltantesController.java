package com.lumtec.computo.controllers;

import com.lumtec.computo.infra.dao.FaltantesDAO;
import com.lumtec.computo.infra.dao.FaltantesDAOJDBC;
import com.lumtec.computo.infra.dao.ProvedorDAO;
import com.lumtec.computo.infra.dao.ProvedorDAOJDBC;
import com.lumtec.computo.infra.model.Faltante;
import com.lumtec.computo.infra.model.Producto;
import com.lumtec.computo.infra.model.Provedor;
import com.lumtec.computo.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.math.BigDecimal;
import java.util.List;


public class FaltantesController {

    private FaltantesDAO faltantesDAO;
    private ProvedorDAO provedorDAO;

    private DefaultTableModel modeloTablaFaltantes, modeloTablaProvedores;
    private DefaultTableCellRenderer alinear;
    private TableRowSorter<TableModel> tableRowSorter;
    private JTable tablaFaltantes, tablaProvedores;

    private final Font Arial = new java.awt.Font("Arial", 0, 12);

    public FaltantesController(JTable tablaFaltantes, JTable tablaProvedores) {
        this.tablaFaltantes = tablaFaltantes;
        this.tablaProvedores = tablaProvedores;
        modeloTablaFaltantes = new DefaultTableModel();
        modeloTablaProvedores = new DefaultTableModel();
        alinear = new DefaultTableCellRenderer();
    }

    public FaltantesController() {

    }


    private void modeloTabla() {
        alinear.setHorizontalAlignment(SwingConstants.CENTER);

        modeloTablaFaltantes.addColumn("Producto");
        modeloTablaFaltantes.addColumn("Provedor");
        modeloTablaFaltantes.addColumn("Modelo");
        modeloTablaFaltantes.addColumn("Faltantes");
        modeloTablaFaltantes.addColumn("Precio Compra");
        modeloTablaFaltantes.addColumn("Total");

        tableRowSorter = new TableRowSorter<>(modeloTablaFaltantes);
        tablaFaltantes.setModel(modeloTablaFaltantes);
        tablaFaltantes.setRowSorter(tableRowSorter);
        tablaFaltantes.setFont(Arial);

        tablaFaltantes.getColumnModel().getColumn(0).setMaxWidth(250);
        tablaFaltantes.getColumnModel().getColumn(0).setMinWidth(250);
        tablaFaltantes.getColumnModel().getColumn(0).setResizable(false);
        tablaFaltantes.getColumnModel().getColumn(0).setCellRenderer(alinear);
        tablaFaltantes.getColumnModel().getColumn(1).setMaxWidth(60);
        tablaFaltantes.getColumnModel().getColumn(1).setMinWidth(60);
        tablaFaltantes.getColumnModel().getColumn(1).setResizable(false);
        tablaFaltantes.getColumnModel().getColumn(1).setCellRenderer(alinear);
        tablaFaltantes.getColumnModel().getColumn(2).setMaxWidth(110);
        tablaFaltantes.getColumnModel().getColumn(2).setMinWidth(110);
        tablaFaltantes.getColumnModel().getColumn(2).setResizable(false);
        tablaFaltantes.getColumnModel().getColumn(2).setCellRenderer(alinear);
        tablaFaltantes.getColumnModel().getColumn(3).setResizable(false);
        tablaFaltantes.getColumnModel().getColumn(3).setCellRenderer(alinear);
        tablaFaltantes.getColumnModel().getColumn(4).setMaxWidth(70);
        tablaFaltantes.getColumnModel().getColumn(4).setMinWidth(70);
        tablaFaltantes.getColumnModel().getColumn(4).setResizable(false);
        tablaFaltantes.getColumnModel().getColumn(4).setCellRenderer(alinear);
        tablaFaltantes.getColumnModel().getColumn(5).setCellRenderer(alinear);
        tablaFaltantes.setRowHeight(17);


        modeloTablaProvedores.addColumn("Provedor");
        modeloTablaProvedores.addColumn("Costo");
        alinear.setHorizontalAlignment(SwingConstants.CENTER);
        tablaProvedores.setModel(modeloTablaProvedores);
        tablaFaltantes.setFont(Arial);
        tablaProvedores.getColumnModel().getColumn(0).setCellRenderer(alinear);
        tablaProvedores.getColumnModel().getColumn(1).setCellRenderer(alinear);
    }


    public void cargarTablas() {
        modeloTabla();
        cargarFaltantes();
        cargarProvedores();
    }

    private void cargarFaltantes() {
        EntityManager em = JPAUtils.getEntityManger();
        faltantesDAO = new FaltantesDAOJDBC(em);

        List<Faltante> listaFaltantes = faltantesDAO.getListaFaltantes();

        listaFaltantes.forEach(faltante -> modeloTablaFaltantes.addRow(
                new Object[]{
                        faltante.getProducto().getNombre(),
                        faltante.getProducto().getProvedor(),
                        faltante.getProducto().getModelo(),
                        faltante.getCantidad(),
                        faltante.getProducto().getPrecioCompra(),
                        faltante.getProducto().getPrecioCompra().multiply(new BigDecimal(faltante.getCantidad()))


                }
        ));

    }

    private void cargarProvedores() {
        EntityManager em = JPAUtils.getEntityManger();
        provedorDAO = new ProvedorDAOJDBC(em);

        List<Provedor> listaProvedores = provedorDAO.getProvedores();

        listaProvedores.forEach(provedor -> modeloTablaProvedores.addRow(
                new Object[]{
                        provedor.toString()
                }
        ));
    }


    public void agregarFaltante(Integer cantidad, Producto producto) {
        EntityManager em = JPAUtils.getEntityManger();
        faltantesDAO = new FaltantesDAOJDBC(em);
        Faltante faltante = null;
        em.getTransaction().begin();
        try {

            faltante = faltantesDAO.getFaltantePorNombre(producto.getNombre());
            faltante.setCantidad(faltante.getCantidad() + cantidad);
            faltantesDAO.actualizarFaltante(faltante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            faltante = new Faltante();
            faltante.setCantidad(cantidad);
            faltante.setProducto(producto);
            faltantesDAO.nuevoFaltante(faltante);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }


}
