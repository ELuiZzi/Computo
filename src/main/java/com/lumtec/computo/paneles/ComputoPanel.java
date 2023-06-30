package com.lumtec.computo.paneles;

import com.lumtec.computo.infra.Colors;
import com.lumtec.computo.infra.Go;
import com.lumtec.computo.infra.Imagenes.newProduct;

import javax.swing.*;

public class ComputoPanel extends javax.swing.JPanel {

    private JPanel p;
    static JPanel mesa, background;
    Home home;

    newProduct b = new newProduct();

    public ComputoPanel(JPanel mesa, JPanel bc) {
        home = new Home("");
        ComputoPanel.mesa = mesa;
        ComputoPanel.background = bc;
        initComponents();
        initOwnComponents();
    }

    public ComputoPanel() {
        initComponents();
        initOwnComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        agregarButton = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inventarioButton = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        editarButton = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        venderButton = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        faltantesButton = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        finanzasButton = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(860, 410));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agregarButton.setBackground(new java.awt.Color(204, 204, 204));
        agregarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agregarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarButtonMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                agregarButtonMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                agregarButtonMouseExited(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                agregarButtonMousePressed(evt);
            }
        });
        agregarButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar");
        agregarButton.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 110, 80, -1));

        add(agregarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 40, 266, 140));

        inventarioButton.setBackground(new java.awt.Color(204, 204, 204));
        inventarioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inventarioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventarioButtonMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inventarioButtonMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                inventarioButtonMouseExited(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                inventarioButtonMousePressed(evt);
            }
        });
        inventarioButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Inventario");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        inventarioButton.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 266, -1));

        add(inventarioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 40, 266, 140));

        editarButton.setBackground(new java.awt.Color(204, 204, 204));
        editarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarButtonMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editarButtonMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                editarButtonMouseExited(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                editarButtonMousePressed(evt);
            }
        });
        editarButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Editar");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editarButton.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 110, 80, -1));

        add(editarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 40, 266, 140));

        venderButton.setBackground(new java.awt.Color(204, 204, 204));
        venderButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        venderButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                venderButtonMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                venderButtonMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                venderButtonMouseExited(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                venderButtonMousePressed(evt);
            }
        });
        venderButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Vender");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        venderButton.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 110, 80, -1));

        add(venderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 220, 266, 140));

        faltantesButton.setBackground(new java.awt.Color(204, 204, 204));
        faltantesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        faltantesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                faltantesButtonMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                faltantesButtonMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                faltantesButtonMouseExited(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                faltantesButtonMousePressed(evt);
            }
        });
        faltantesButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Faltantes");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        faltantesButton.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 110, 80, -1));

        add(faltantesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 220, 266, 140));

        finanzasButton.setBackground(new java.awt.Color(204, 204, 204));
        finanzasButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        finanzasButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finanzasButtonMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                finanzasButtonMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                finanzasButtonMouseExited(evt);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                finanzasButtonMousePressed(evt);
            }
        });
        finanzasButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Finanzas");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        finanzasButton.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 110, 80, -1));

        add(finanzasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 220, 266, 140));
    }// </editor-fold>//GEN-END:initComponents

    private void agregarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarButtonMouseClicked
        Go.to(new NuevoProductoPanel());
    }//GEN-LAST:event_agregarButtonMouseClicked

    private void agregarButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarButtonMouseEntered
        mouseEntered(agregarButton);
    }//GEN-LAST:event_agregarButtonMouseEntered

    private void inventarioButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventarioButtonMouseClicked
        Go.to(new InventarioPanel());
    }//GEN-LAST:event_inventarioButtonMouseClicked

    private void finanzasButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finanzasButtonMouseClicked
        Go.to(new FinanzasPanel());
    }//GEN-LAST:event_finanzasButtonMouseClicked

    private void venderButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_venderButtonMouseClicked
        Go.to(new VenderPanel());
    }//GEN-LAST:event_venderButtonMouseClicked

    private void faltantesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faltantesButtonMouseClicked
        Go.to(new FaltantesPanel());
    }//GEN-LAST:event_faltantesButtonMouseClicked

    private void editarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarButtonMouseClicked

        Go.to(Home.editarProdutcoPanel);


    }//GEN-LAST:event_editarButtonMouseClicked

    private void agregarButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarButtonMouseExited
        mouseExited(agregarButton);
    }//GEN-LAST:event_agregarButtonMouseExited

    private void inventarioButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventarioButtonMouseEntered
        mouseEntered(inventarioButton);
    }//GEN-LAST:event_inventarioButtonMouseEntered

    private void inventarioButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventarioButtonMouseExited
        mouseExited(inventarioButton);
    }//GEN-LAST:event_inventarioButtonMouseExited

    private void editarButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarButtonMouseEntered
        mouseEntered(editarButton);
    }//GEN-LAST:event_editarButtonMouseEntered

    private void editarButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarButtonMouseExited
        mouseExited(editarButton);
    }//GEN-LAST:event_editarButtonMouseExited

    private void venderButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_venderButtonMouseEntered
        mouseEntered(venderButton);
    }//GEN-LAST:event_venderButtonMouseEntered

    private void venderButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_venderButtonMouseExited
        mouseExited(venderButton);
    }//GEN-LAST:event_venderButtonMouseExited

    private void faltantesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faltantesButtonMouseEntered
        mouseEntered(faltantesButton);
    }//GEN-LAST:event_faltantesButtonMouseEntered

    private void faltantesButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faltantesButtonMouseExited
        mouseExited(faltantesButton);
    }//GEN-LAST:event_faltantesButtonMouseExited

    private void finanzasButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finanzasButtonMouseEntered
        mouseEntered(finanzasButton);
    }//GEN-LAST:event_finanzasButtonMouseEntered

    private void finanzasButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finanzasButtonMouseExited
        mouseExited(finanzasButton);
    }//GEN-LAST:event_finanzasButtonMouseExited

    private void agregarButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarButtonMousePressed
        mousePressed(agregarButton);
    }//GEN-LAST:event_agregarButtonMousePressed

    private void inventarioButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventarioButtonMousePressed
        mousePressed(inventarioButton);
    }//GEN-LAST:event_inventarioButtonMousePressed

    private void editarButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarButtonMousePressed
        mousePressed(editarButton);
    }//GEN-LAST:event_editarButtonMousePressed

    private void venderButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_venderButtonMousePressed
        mousePressed(venderButton);
    }//GEN-LAST:event_venderButtonMousePressed

    private void faltantesButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faltantesButtonMousePressed
        mousePressed(faltantesButton);
    }//GEN-LAST:event_faltantesButtonMousePressed

    private void finanzasButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finanzasButtonMousePressed
        mousePressed(finanzasButton);
    }//GEN-LAST:event_finanzasButtonMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel agregarButton;
    private javax.swing.JPanel editarButton;
    private javax.swing.JPanel faltantesButton;
    private javax.swing.JPanel finanzasButton;
    private javax.swing.JPanel inventarioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel venderButton;
    // End of variables declaration//GEN-END:variables

    private void mouseEntered(JPanel panel) {
        panel.setBackground(Colors.buttonPressed);
    }

    private void mouseExited(JPanel panel) {
        panel.setBackground(Colors.button);
    }

    private void mousePressed(JPanel panel) {
        panel.setBackground(Colors.button);
    }

    private void initOwnComponents() {
        //Colorizacion
        this.setBackground(Colors.panel);

        agregarButton.setBackground(Colors.button);
        inventarioButton.setBackground(Colors.button);
        editarButton.setBackground(Colors.button);
        venderButton.setBackground(Colors.button);
        faltantesButton.setBackground(Colors.button);
        finanzasButton.setBackground(Colors.button);

    }

}
