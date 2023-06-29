package com.lumtec.computo.paneles;

import com.lumtec.computo.infra.Colors;
import com.lumtec.computo.infra.Go;
import com.lumtec.computo.infra.HerramientasTabla;
import com.lumtec.computo.infra.Shortcuts;
import com.lumtec.computo.infra.dao.FaltantesDAO;
import com.lumtec.computo.infra.dao.FaltantesDAOJDBC;
import com.lumtec.computo.infra.model.ConexionMultiple;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.KeyEvent;

public class FaltantesPanel extends javax.swing.JPanel {

    FaltantesDAO fal = new FaltantesDAOJDBC();
    HerramientasTabla conf;
    DefaultTableModel model;
    DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
    private TableRowSorter<TableModel> tableRowSorter;
    Shortcuts sc = new Shortcuts();

    Font Arial = new java.awt.Font("Arial", 0, 12);

    public FaltantesPanel() {
        initComponents();
        initOwnComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFaltantes = new javax.swing.JTable();
        dineroTotal_box = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProvedores = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(860, 410));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel1.setMinimumSize(new java.awt.Dimension(860, 410));
        Panel1.setPreferredSize(new java.awt.Dimension(860, 410));
        Panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaFaltantes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablaFaltantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaFaltantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFaltantesMouseClicked(evt);
            }
        });
        tablaFaltantes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaFaltantesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaFaltantes);

        Panel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 630, 340));

        dineroTotal_box.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        dineroTotal_box.setForeground(new java.awt.Color(255, 255, 255));
        dineroTotal_box.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dineroTotal_box.setText("$2340");
        Panel1.add(dineroTotal_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, 100, 20));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total:");
        Panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 290, -1, 20));

        tablaProvedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaProvedores);

        Panel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 170, 250));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        Panel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 366, 37, 37));

        add(Panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 410));
    }// </editor-fold>//GEN-END:initComponents

    private void tablaFaltantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFaltantesMouseClicked

    }//GEN-LAST:event_tablaFaltantesMouseClicked

    private void tablaFaltantesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaFaltantesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            conf = new HerramientasTabla();
            int del = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar el Producto?", "Elimnar Producto", JOptionPane.YES_NO_OPTION);
            if (del == 0) {

                conf.eliminarId("faltantes", tablaFaltantes);
                rellenarTabla();
                vaciarTabla(tablaProvedores);
                rellenarTablaProvedores();

            }
        } else if (evt.getKeyCode() == KeyEvent.VK_S) {
            //Pregunta si queremos eliminar el producto, y ademas ocupa el nombre del producto según la columa de nombre y la fila seleccionada
            int add = JOptionPane.showConfirmDialog(null, "¿Quieres surtir " + tablaFaltantes.getValueAt(tablaFaltantes.getSelectedRow(), 0).toString() + "?", "Surtir Producto", JOptionPane.YES_NO_OPTION
            );
            if (add == 0) {
                surtir();
            }

        } else if (evt.getKeyCode() == KeyEvent.VK_E) {
            sc.editarFaltante(tablaFaltantes);
        }
    }//GEN-LAST:event_tablaFaltantesKeyPressed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        Go.to(Home.nuevoFaltantePanel);
    }//GEN-LAST:event_jPanel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel1;
    private javax.swing.JLabel dineroTotal_box;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaFaltantes;
    private javax.swing.JTable tablaProvedores;
    // End of variables declaration//GEN-END:variables

    private void rellenarTabla() {

        Alinear.setHorizontalAlignment(SwingConstants.CENTER);

        model = new DefaultTableModel();

        model.addColumn("Producto");
        model.addColumn("Provedor");
        model.addColumn("Modelo");
        model.addColumn("Faltantes");
        model.addColumn("Precio Compra");
        model.addColumn("Total");

        tableRowSorter = new TableRowSorter<>(model);
        tablaFaltantes.setModel(model);
        tablaFaltantes.setRowSorter(tableRowSorter);
        tablaFaltantes.setFont(Arial);

        tablaFaltantes.getColumnModel().getColumn(0).setMaxWidth(250);
        tablaFaltantes.getColumnModel().getColumn(0).setMinWidth(250);
        tablaFaltantes.getColumnModel().getColumn(0).setResizable(false);
        tablaFaltantes.getColumnModel().getColumn(0).setCellRenderer(Alinear);
        tablaFaltantes.getColumnModel().getColumn(1).setMaxWidth(60);
        tablaFaltantes.getColumnModel().getColumn(1).setMinWidth(60);
        tablaFaltantes.getColumnModel().getColumn(1).setResizable(false);
        tablaFaltantes.getColumnModel().getColumn(1).setCellRenderer(Alinear);
        tablaFaltantes.getColumnModel().getColumn(2).setMaxWidth(110);
        tablaFaltantes.getColumnModel().getColumn(2).setMinWidth(110);
        tablaFaltantes.getColumnModel().getColumn(2).setResizable(false);
        tablaFaltantes.getColumnModel().getColumn(2).setCellRenderer(Alinear);
        tablaFaltantes.getColumnModel().getColumn(3).setResizable(false);
        tablaFaltantes.getColumnModel().getColumn(3).setCellRenderer(Alinear);
        tablaFaltantes.getColumnModel().getColumn(4).setMaxWidth(70);
        tablaFaltantes.getColumnModel().getColumn(4).setMinWidth(70);
        tablaFaltantes.getColumnModel().getColumn(4).setResizable(false);
        tablaFaltantes.getColumnModel().getColumn(4).setCellRenderer(Alinear);
        tablaFaltantes.getColumnModel().getColumn(5).setCellRenderer(Alinear);
        tablaFaltantes.setRowHeight(17);
/*
        var faltantes = this.fal.listar();

        faltantes.forEach(producto -> model.addRow(
                new Object[]{
                    producto.getNombreProducto(),
                    producto.getProvedor(),
                    producto.getModelo(),
                    producto.getCantidad(),
                    producto.getPrecioCompra(),
                    producto.getTotalCompra()
                }
        ));*/

    }

    private void rellenarTablaProvedores() {

        model = new DefaultTableModel();

        model.addColumn("Provedor");
        model.addColumn("Costo");
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        tablaProvedores.setModel(model);
        tablaFaltantes.setFont(new java.awt.Font("Arial", 0, 12));
        tablaProvedores.getColumnModel().getColumn(0).setCellRenderer(Alinear);
        tablaProvedores.getColumnModel().getColumn(1).setCellRenderer(Alinear);
        

    }

    private void surtir() {

        ConexionMultiple coonexionMultiple = new ConexionMultiple();

        //La cantidad nueva se encerrar en un try-catch, en caso de que se escriba un dato erroeno, o se cancele la acción
        int cantidadASurtir = 0;

        try {
            cantidadASurtir = Integer.parseInt(JOptionPane.showInputDialog("Cantidad"));

        } catch (NumberFormatException ex) {
            System.out.println("Cancelado/Dato no válido como cantidad");
        }

   /*     Producto producto = new Producto(tablaFaltantes.getValueAt(tablaFaltantes.getSelectedRow(), 0).toString(),
                tablaFaltantes.getValueAt(tablaFaltantes.getSelectedRow(), 2).toString(),
                Double.parseDouble(tablaFaltantes.getValueAt(tablaFaltantes.getSelectedRow(), 4).toString()));

        coonexionMultiple.surtir(producto, cantidadASurtir);*/

        //Finalmente rellenamos las tablas con los nuevos cambios
        rellenarTabla();
        vaciarTabla(tablaProvedores);
        rellenarTablaProvedores();

    }

    private void vaciarTabla(JTable tabla) {
        tabla.setModel(new DefaultTableModel());
    }

    private void rellenarTablas() {
        
        FaltantesDAO faltantesDAO = new FaltantesDAOJDBC();

        rellenarTabla();
        rellenarTablaProvedores();
        /*  dineroTotal_box.setText(faltantesDAO.getFaltanteTotal());*/

    }

    private void initOwnComponents() {
        //Colorizacion
        Panel1.setBackground(Colors.panel);

        tablaFaltantes.setBackground(Colors.textBox);
        tablaFaltantes.setForeground(Colors.text);
        tablaFaltantes.setSelectionBackground(Colors.textBoxActivated);

        tablaProvedores.setBackground(Colors.textBox);
        tablaProvedores.setForeground(Colors.text);
        tablaProvedores.setSelectionBackground(Colors.textBoxActivated);

        //Métodos
        /* fal.calcularGastoTotal();*/
        rellenarTablas();
    }
}
