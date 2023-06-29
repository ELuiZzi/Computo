package com.lumtec.computo.paneles;

import com.lumtec.computo.controllers.InventarioController;
import com.lumtec.computo.infra.Colors;
import com.lumtec.computo.infra.HerramientasTabla;
import com.lumtec.computo.infra.Shortcuts;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.KeyEvent;

public class InventarioPanel extends javax.swing.JPanel {

    private final InventarioController inventarioController;
    private final HerramientasTabla conf;
    private final Shortcuts sc;

    public InventarioPanel() {

        conf = new HerramientasTabla();
        sc = new Shortcuts();

        initComponents();
        inventarioController = new InventarioController(tablaInventario);
        initOwnComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInventario = new javax.swing.JTable();
        searchBar = new javax.swing.JPanel();
        barraBusqueda = new javax.swing.JTextField();
        rowsCountLabel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(70, 70, 70));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tablaInventario.setBackground(new java.awt.Color(250, 250, 250));
        tablaInventario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tablaInventario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablaInventario.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {},
                        {},
                        {},
                        {}
                },
                new String[]{

                }
        ));
        tablaInventario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaInventarioKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaInventario);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 57, 835, 340));

        searchBar.setBackground(new java.awt.Color(102, 102, 102));
        searchBar.setPreferredSize(new java.awt.Dimension(840, 100));
        searchBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraBusqueda.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        barraBusqueda.setForeground(new java.awt.Color(170, 170, 170));
        barraBusqueda.setText("Buscar");
        barraBusqueda.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        barraBusqueda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                barraBusquedaFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                barraBusquedaFocusLost(evt);
            }
        });
        barraBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barraBusquedaMouseClicked(evt);
            }
        });
        barraBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                barraBusquedaKeyPressed(evt);
            }
        });
        searchBar.add(barraBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 7, 410, 30));

        rowsCountLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rowsCountLabel.setForeground(new java.awt.Color(255, 255, 255));
        rowsCountLabel.setText("Número de Productos: 50");
        searchBar.add(rowsCountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 7, -1, 30));

        jPanel1.add(searchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 45));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 410));
    }// </editor-fold>//GEN-END:initComponents

    private void tablaInventarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaInventarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            conf.eliminarId("inventario", tablaInventario);
            inventarioController.rellenarTabla();
        } else if (evt.getKeyCode() == KeyEvent.VK_E) {
            sc.editarProducto(tablaInventario);
        } else if (evt.getKeyCode() == KeyEvent.VK_V) {
            sc.sell(tablaInventario);
        }


    }//GEN-LAST:event_tablaInventarioKeyPressed

    private void barraBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraBusquedaMouseClicked

    }//GEN-LAST:event_barraBusquedaMouseClicked

    private void barraBusquedaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_barraBusquedaFocusGained
        if (barraBusqueda.getText().equals("Buscar")) {
            barraBusqueda.setText(null);

        }
        //Finalmente el texto se ilumina
        barraBusqueda.setForeground(Colors.text);
    }//GEN-LAST:event_barraBusquedaFocusGained

    private void barraBusquedaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_barraBusquedaFocusLost
        if (barraBusqueda.getText().equals("")) {
            barraBusqueda.setText("Buscar");

        }
        //Finalmente el texto se vuelve a opacar
        barraBusqueda.setForeground(Colors.textBlocked);
    }//GEN-LAST:event_barraBusquedaFocusLost

    private void barraBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barraBusquedaKeyPressed

        String textoBusqueda = barraBusqueda.getText().toLowerCase();
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tablaInventario.getModel());
        tablaInventario.setRowSorter(rowSorter);
        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + textoBusqueda, 0));


        inventarioController.numeroDeResultados(rowsCountLabel, tablaInventario, conf);
    }//GEN-LAST:event_barraBusquedaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barraBusqueda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel rowsCountLabel;
    private javax.swing.JPanel searchBar;
    private javax.swing.JTable tablaInventario;
    // End of variables declaration//GEN-END:variables


    //Inicia todos los componentes del panel
    private void initOwnComponents() {
        //Colorizacion
        jPanel1.setBackground(Colors.panel);

        searchBar.setBackground(Colors.banner2);

        barraBusqueda.setBackground(Colors.textBox);
        barraBusqueda.setForeground(Colors.textBlocked);
        tablaInventario.setBackground(Colors.textBox);
        tablaInventario.setForeground(Colors.text);
        tablaInventario.setSelectionBackground(Colors.textBoxActivated);


        //Primero de inicia la tabla, ya que en base a los valores de definen algunos métodos.
        inventarioController.rellenarTabla();
        //Selecciona el número de filas que tiene la tabla de inventario.
        inventarioController.numeroDeResultados(rowsCountLabel, tablaInventario, conf);
    }

}
