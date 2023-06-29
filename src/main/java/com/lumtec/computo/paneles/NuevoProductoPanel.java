package com.lumtec.computo.paneles;

import com.lumtec.computo.controllers.CommonController;
import com.lumtec.computo.controllers.NuevoProductoController;
import com.lumtec.computo.infra.Colors;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;

public class NuevoProductoPanel extends javax.swing.JPanel {

    private final NuevoProductoController nuevoProductoController;
    private final CommonController commonController;
    private javax.swing.JTextField precioCompraBox;
    private javax.swing.JComboBox<String> provedorBox;

    public NuevoProductoPanel() {
        commonController = new CommonController();
        initComponents();

        nuevoProductoController = new NuevoProductoController(this.nombreBox,
                this.marcaBox,
                this.modeloBox,
                this.cantidadBox,
                this.garantiaBox,
                this.descripcionBox,
                this.precioCompraBox,
                this.porcentajeBox,
                this.gananciaBox,
                this.reinversionBox,
                this.precioVentaBox,
                this.provedorBox,
                this.reinversion_label,
                this.ganancia_label,
                this.porcentaje_label,
                this.transporteCheck);
        initOwnComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombreBox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        marcaBox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        modeloBox = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcionBox = new javax.swing.JTextArea();
        provedorLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        precioCompraBox = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel9 = new javax.swing.JLabel();
        gananciaBox = new javax.swing.JTextField();
        ganancia_label = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        reinversionBox = new javax.swing.JTextField();
        reinversion_label = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        porcentajeBox = new javax.swing.JTextField();
        porcentaje_label = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        transporteCheck = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        precioVentaBox = new javax.swing.JTextField();
        agregarButton = new javax.swing.JPanel();
        cantidadBox = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        garantiaBox = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        provedorBox = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(860, 410));
        jPanel1.setPreferredSize(new java.awt.Dimension(860, 410));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 70, 30));

        nombreBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nombreBox.setForeground(new java.awt.Color(255, 255, 255));
        nombreBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombreBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        nombreBox.setMinimumSize(new java.awt.Dimension(7, 29));
        nombreBox.setNextFocusableComponent(marcaBox);
        jPanel1.add(nombreBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 250, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Marca:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 65, 53, 30));

        marcaBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        marcaBox.setForeground(new java.awt.Color(255, 255, 255));
        marcaBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        marcaBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        marcaBox.setNextFocusableComponent(modeloBox);
        marcaBox.setPreferredSize(new java.awt.Dimension(7, 2));
        jPanel1.add(marcaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 65, 250, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cantidad:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 155, 80, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Modelo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 53, 30));

        modeloBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        modeloBox.setForeground(new java.awt.Color(255, 255, 255));
        modeloBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        modeloBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        modeloBox.setNextFocusableComponent(cantidadBox);
        jPanel1.add(modeloBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 250, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Descripción:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 90, 30));

        jScrollPane1.setBackground(new java.awt.Color(70, 70, 70));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        descripcionBox.setColumns(20);
        descripcionBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        descripcionBox.setForeground(new java.awt.Color(255, 255, 255));
        descripcionBox.setRows(5);
        descripcionBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        descripcionBox.setNextFocusableComponent(precioCompraBox);
        descripcionBox.setSelectionColor(new java.awt.Color(70, 70, 70));
        descripcionBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descripcionBoxKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(descripcionBox);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 250, 100));

        provedorLabel.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        provedorLabel.setForeground(new java.awt.Color(255, 255, 255));
        provedorLabel.setText("Provedor:");
        jPanel1.add(provedorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Precio de Compra:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, 30));

        precioCompraBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        precioCompraBox.setForeground(new java.awt.Color(255, 255, 255));
        precioCompraBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        precioCompraBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        precioCompraBox.setNextFocusableComponent(gananciaBox);
        precioCompraBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioCompraBoxActionPerformed(evt);
            }
        });
        precioCompraBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                precioCompraBoxKeyPressed(evt);
            }

            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioCompraBoxKeyTyped(evt);
            }
        });
        jPanel1.add(precioCompraBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 240, 30));

        jToggleButton1.setText("IVA");
        jToggleButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToggleButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jToggleButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 30, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Ganancia:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 90, 30));

        gananciaBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        gananciaBox.setForeground(new java.awt.Color(255, 255, 255));
        gananciaBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gananciaBox.setText("20");
        gananciaBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gananciaBox.setNextFocusableComponent(reinversionBox);
        gananciaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gananciaBoxActionPerformed(evt);
            }
        });
        gananciaBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gananciaBoxKeyPressed(evt);
            }
        });
        jPanel1.add(gananciaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 80, 25));

        ganancia_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ganancia_label.setForeground(new java.awt.Color(255, 255, 255));
        ganancia_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ganancia_label.setText("-");
        jPanel1.add(ganancia_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, 90, 25));

        jLabel10.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Reinversión:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, -1, 30));

        reinversionBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        reinversionBox.setForeground(new java.awt.Color(255, 255, 255));
        reinversionBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        reinversionBox.setText("80");
        reinversionBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        reinversionBox.setNextFocusableComponent(porcentajeBox);
        reinversionBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                reinversionBoxKeyPressed(evt);
            }
        });
        jPanel1.add(reinversionBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 80, 25));

        reinversion_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        reinversion_label.setForeground(new java.awt.Color(255, 255, 255));
        reinversion_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reinversion_label.setText("-");
        jPanel1.add(reinversion_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, 90, 25));

        jLabel11.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Aumento Total:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 120, 30));

        porcentajeBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        porcentajeBox.setForeground(new java.awt.Color(255, 255, 255));
        porcentajeBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        porcentajeBox.setText("100");
        porcentajeBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        porcentajeBox.setNextFocusableComponent(transporteCheck);
        porcentajeBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                porcentajeBoxKeyPressed(evt);
            }
        });
        jPanel1.add(porcentajeBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 80, 25));

        porcentaje_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        porcentaje_label.setForeground(new java.awt.Color(255, 255, 255));
        porcentaje_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        porcentaje_label.setText("-");
        jPanel1.add(porcentaje_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, 90, 25));

        jLabel12.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Transporte:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 90, 30));

        transporteCheck.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        transporteCheck.setForeground(new java.awt.Color(255, 255, 255));
        transporteCheck.setText("$ 20");
        transporteCheck.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        transporteCheck.setFocusPainted(false);
        transporteCheck.setHideActionText(true);
        transporteCheck.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transporteCheck.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        transporteCheck.setNextFocusableComponent(precioVentaBox);
        transporteCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transporteCheckActionPerformed(evt);
            }
        });
        jPanel1.add(transporteCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 240, 25));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Precio de Venta:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, -1, 30));

        precioVentaBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        precioVentaBox.setForeground(new java.awt.Color(255, 255, 255));
        precioVentaBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        precioVentaBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        precioVentaBox.setNextFocusableComponent(agregarButton);
        jPanel1.add(precioVentaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 240, 30));

        agregarButton.setBackground(new java.awt.Color(210, 210, 210));
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
        });
        agregarButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(agregarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 350, 110, 30));

        cantidadBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cantidadBox.setForeground(new java.awt.Color(255, 255, 255));
        cantidadBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cantidadBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cantidadBox.setNextFocusableComponent(provedorBox);
        cantidadBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cantidadBoxKeyPressed(evt);
            }
        });
        jPanel1.add(cantidadBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 155, 250, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Garantía:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 245, -1, 30));

        garantiaBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        garantiaBox.setForeground(new java.awt.Color(255, 255, 255));
        garantiaBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        garantiaBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        garantiaBox.setNextFocusableComponent(descripcionBox);
        jPanel1.add(garantiaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 245, 250, 30));

        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, 390));

        provedorBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        provedorBox.setForeground(new java.awt.Color(255, 255, 255));
        provedorBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(provedorBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 250, 30));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 410));
    }// </editor-fold>//GEN-END:initComponents

    private void precioCompraBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioCompraBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioCompraBoxActionPerformed

    private void precioCompraBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioCompraBoxKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            nuevoProductoController.calcularAumento();
        }
    }//GEN-LAST:event_precioCompraBoxKeyPressed

    private void gananciaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gananciaBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gananciaBoxActionPerformed

    private void gananciaBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gananciaBoxKeyPressed

    }//GEN-LAST:event_gananciaBoxKeyPressed

    private void reinversionBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reinversionBoxKeyPressed

    }//GEN-LAST:event_reinversionBoxKeyPressed

    private void precioCompraBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioCompraBoxKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_precioCompraBoxKeyTyped

    private void agregarButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarButtonMouseEntered
        agregarButton.setBackground(Colors.buttonPressed);
        agregarButton.setCursor(new Cursor(12));
    }//GEN-LAST:event_agregarButtonMouseEntered

    private void agregarButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarButtonMouseExited
        agregarButton.setBackground(Colors.button);
    }//GEN-LAST:event_agregarButtonMouseExited

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

        nuevoProductoController.asignarIVA(new BigDecimal(precioCompraBox.getText()));
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void transporteCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transporteCheckActionPerformed
        nuevoProductoController.sumarTransporte();
    }//GEN-LAST:event_transporteCheckActionPerformed

    private void cantidadBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadBoxKeyPressed


    }//GEN-LAST:event_cantidadBoxKeyPressed

    private void descripcionBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripcionBoxKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            evt.consume();
            precioCompraBox.requestFocus();
        }
    }//GEN-LAST:event_descripcionBoxKeyPressed

    private void agregarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarButtonMouseClicked
        /**
         * Agregar un Producto a la base de datos
         */
        nuevoProductoController.nuevoProducto();


    }//GEN-LAST:event_agregarButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel agregarButton;
    private javax.swing.JTextField cantidadBox;
    public javax.swing.JTextArea descripcionBox;
    private javax.swing.JTextField gananciaBox;
    private javax.swing.JLabel ganancia_label;
    private javax.swing.JTextField garantiaBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField marcaBox;
    private javax.swing.JTextField modeloBox;
    private javax.swing.JTextField nombreBox;
    private javax.swing.JTextField porcentajeBox;
    private javax.swing.JLabel porcentaje_label;

    private void porcentajeBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_porcentajeBoxKeyPressed


    }//GEN-LAST:event_porcentajeBoxKeyPressed
    private javax.swing.JTextField precioVentaBox;

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked


    }//GEN-LAST:event_jToggleButton1MouseClicked
    private javax.swing.JLabel provedorLabel;
    private javax.swing.JTextField reinversionBox;
    private javax.swing.JLabel reinversion_label;
    private javax.swing.JCheckBox transporteCheck;
    // End of variables declaration//GEN-END:variables

    private void initOwnComponents() {
        //Colorizacion
        jPanel1.setBackground(Colors.panel);

        agregarButton.setBackground(Colors.button);

        nombreBox.setBackground(Colors.textBox);
        marcaBox.setBackground(Colors.textBox);
        modeloBox.setBackground(Colors.textBox);
        cantidadBox.setBackground(Colors.textBox);
        provedorBox.setForeground(new Color(0, 0, 0));
        garantiaBox.setBackground(Colors.textBox);
        descripcionBox.setBackground(Colors.textBox);
        precioCompraBox.setBackground(Colors.textBox);
        porcentajeBox.setBackground(Colors.textBox);
        gananciaBox.setBackground(Colors.textBox);
        reinversionBox.setBackground(Colors.textBox);
        transporteCheck.setBackground(Colors.panel);
        precioVentaBox.setBackground(Colors.textBox);

        commonController.cargarListaProvedores(provedorBox);
    }
}
