package com.lumtec.computo.Paneles;

import com.lumtec.computo.Colors;
import com.lumtec.computo.FuncionesMatematicas;
import com.lumtec.computo.Ganancias;
import com.lumtec.computo.Inventario.*;
import com.lumtec.computo.Producto;
import java.awt.Cursor;
import java.awt.event.KeyEvent;

public class AgregarProductoPanel extends javax.swing.JPanel {
    
    InventarioDAO inv;
    
    Producto prod;
//Objeto Ganancias, para calcular el porcentaje de ganacia 
    Ganancias gains = new Ganancias();
    
    public AgregarProductoPanel() {
        prod = new Producto();
        initComponents();
        initOwnComponents();
        jPanel1.requestFocus();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombreBox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        marcaBox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        colorBox = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        modeloBox = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcionBox = new javax.swing.JTextArea();
        provedorLabel = new javax.swing.JLabel();
        provedorBox = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        precioBox = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();
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
        precioIVABox = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        garantiaBox = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(860, 410));
        jPanel1.setPreferredSize(new java.awt.Dimension(860, 410));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 53, 25));

        nombreBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nombreBox.setForeground(new java.awt.Color(255, 255, 255));
        nombreBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombreBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        nombreBox.setMinimumSize(new java.awt.Dimension(7, 29));
        nombreBox.setNextFocusableComponent(marcaBox);
        jPanel1.add(nombreBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 20, 230, 25));

        jLabel2.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Marca:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 53, 25));

        marcaBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        marcaBox.setForeground(new java.awt.Color(255, 255, 255));
        marcaBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        marcaBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        marcaBox.setNextFocusableComponent(modeloBox);
        marcaBox.setPreferredSize(new java.awt.Dimension(7, 2));
        jPanel1.add(marcaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 60, 230, 25));

        jLabel3.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cantidad:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 60, 25));

        jLabel4.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Color:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 53, 25));

        colorBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        colorBox.setForeground(new java.awt.Color(255, 255, 255));
        colorBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        colorBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        colorBox.setNextFocusableComponent(cantidadBox);
        colorBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorBoxActionPerformed(evt);
            }
        });
        jPanel1.add(colorBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 140, 230, 25));

        jLabel5.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Modelo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 53, 25));

        modeloBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        modeloBox.setForeground(new java.awt.Color(255, 255, 255));
        modeloBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        modeloBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        modeloBox.setNextFocusableComponent(colorBox);
        jPanel1.add(modeloBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 100, 230, 25));

        jLabel6.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Descripción:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 80, 25));

        jScrollPane1.setBackground(new java.awt.Color(70, 70, 70));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        descripcionBox.setColumns(20);
        descripcionBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        descripcionBox.setForeground(new java.awt.Color(255, 255, 255));
        descripcionBox.setRows(5);
        descripcionBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        descripcionBox.setNextFocusableComponent(precioBox);
        descripcionBox.setSelectionColor(new java.awt.Color(70, 70, 70));
        descripcionBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descripcionBoxKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(descripcionBox);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 300, 230, 96));

        provedorLabel.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        provedorLabel.setForeground(new java.awt.Color(255, 255, 255));
        provedorLabel.setText("Provedor:");
        jPanel1.add(provedorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 25));

        provedorBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        provedorBox.setForeground(new java.awt.Color(255, 255, 255));
        provedorBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        provedorBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        provedorBox.setNextFocusableComponent(garantiaBox);
        jPanel1.add(provedorBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 220, 230, 25));

        jLabel7.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Precio de Compra:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 110, 25));

        precioBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        precioBox.setForeground(new java.awt.Color(255, 255, 255));
        precioBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        precioBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        precioBox.setNextFocusableComponent(gananciaBox);
        precioBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioBoxActionPerformed(evt);
            }
        });
        precioBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                precioBoxKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioBoxKeyTyped(evt);
            }
        });
        jPanel1.add(precioBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 230, 25));

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
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 25, 25));

        jLabel8.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Precio C/ IVA:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, 25));

        jLabel9.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Ganancia:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, -1, 25));

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
        jPanel1.add(gananciaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 80, 25));

        ganancia_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ganancia_label.setForeground(new java.awt.Color(255, 255, 255));
        ganancia_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ganancia_label.setText("-");
        jPanel1.add(ganancia_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, 90, 25));

        jLabel10.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Reinversión:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, -1, 25));

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
        jPanel1.add(reinversionBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 80, 25));

        reinversion_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        reinversion_label.setForeground(new java.awt.Color(255, 255, 255));
        reinversion_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reinversion_label.setText("-");
        jPanel1.add(reinversion_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, 90, 25));

        jLabel11.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Aumento Total:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, 25));

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
        jPanel1.add(porcentajeBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 80, 25));

        porcentaje_label.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        porcentaje_label.setForeground(new java.awt.Color(255, 255, 255));
        porcentaje_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        porcentaje_label.setText("-");
        jPanel1.add(porcentaje_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, 90, 25));

        jLabel12.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Transporte:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, -1, 25));

        transporteCheck.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        transporteCheck.setForeground(new java.awt.Color(255, 255, 255));
        transporteCheck.setText("                           $ 20");
        transporteCheck.setFocusPainted(false);
        transporteCheck.setNextFocusableComponent(precioVentaBox);
        transporteCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transporteCheckActionPerformed(evt);
            }
        });
        jPanel1.add(transporteCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 150, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Precio de Venta:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, -1, 25));

        precioVentaBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        precioVentaBox.setForeground(new java.awt.Color(255, 255, 255));
        precioVentaBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        precioVentaBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        precioVentaBox.setNextFocusableComponent(agregarButton);
        jPanel1.add(precioVentaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 230, 25));

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
        jPanel1.add(agregarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 365, 110, 30));

        cantidadBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cantidadBox.setForeground(new java.awt.Color(255, 255, 255));
        cantidadBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cantidadBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cantidadBox.setNextFocusableComponent(provedorBox);
        cantidadBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cantidadBoxKeyPressed(evt);
            }
        });
        jPanel1.add(cantidadBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 180, 230, 25));

        precioIVABox.setEditable(false);
        precioIVABox.setBackground(new java.awt.Color(255, 255, 255));
        precioIVABox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        precioIVABox.setForeground(new java.awt.Color(255, 255, 255));
        precioIVABox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        precioIVABox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        precioIVABox.setDisabledTextColor(new java.awt.Color(250, 250, 250));
        precioIVABox.setEnabled(false);
        jPanel1.add(precioIVABox, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 230, 25));

        jLabel15.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Garantía:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, 25));

        garantiaBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        garantiaBox.setForeground(new java.awt.Color(255, 255, 255));
        garantiaBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        garantiaBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        garantiaBox.setNextFocusableComponent(descripcionBox);
        jPanel1.add(garantiaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 260, 230, 25));

        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, -1, 410));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 410));
    }// </editor-fold>//GEN-END:initComponents

    private void colorBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorBoxActionPerformed

    }//GEN-LAST:event_colorBoxActionPerformed

    private void precioBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioBoxActionPerformed

    private void precioBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioBoxKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            precioIVABox.setText(null);
            setPorcentage();
            crearPrecios();
        }
    }//GEN-LAST:event_precioBoxKeyPressed

    private void precioBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioBoxKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_precioBoxKeyTyped

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        double precioIva = getPrecioCompra() + FuncionesMatematicas.returnIva(getPrecioCompra());
        precioIVABox.setText(Double.toString(precioIva));
        setPorcentage();
        crearPrecios();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void gananciaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gananciaBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gananciaBoxActionPerformed

    private void gananciaBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gananciaBoxKeyPressed

    }//GEN-LAST:event_gananciaBoxKeyPressed

    private void reinversionBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reinversionBoxKeyPressed

    }//GEN-LAST:event_reinversionBoxKeyPressed

    private void transporteCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transporteCheckActionPerformed
        if (transporteCheck.isSelected()) {
            float precioVenta = getPrecioVenta() + 20f;
            precioVentaBox.setText(Float.toString(precioVenta));
        } else if (transporteCheck.isSelected() == false) {
            float precioVenta = getPrecioVenta() - 20f;
            precioVentaBox.setText(Float.toString(precioVenta));
        }
    }//GEN-LAST:event_transporteCheckActionPerformed

    private void agregarButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarButtonMouseEntered
        agregarButton.setBackground(Colors.buttonPressed);
        agregarButton.setCursor(new Cursor(12));
    }//GEN-LAST:event_agregarButtonMouseEntered

    private void agregarButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarButtonMouseExited
        agregarButton.setBackground(Colors.button);
    }//GEN-LAST:event_agregarButtonMouseExited
    
    private static int cantidad = 1;

    private void cantidadBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadBoxKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            cantidad++;
            cantidadBox.setText(Integer.toString(cantidad));
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN && cantidad > 1) {
            cantidad--;
            cantidadBox.setText(Integer.toString(cantidad));
        }
        

    }//GEN-LAST:event_cantidadBoxKeyPressed

    private void descripcionBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripcionBoxKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            precioBox.requestFocus();
        }
    }//GEN-LAST:event_descripcionBoxKeyPressed

    private void agregarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarButtonMouseClicked
        /**
         * Agregar un Producto a la base de datos
         */
        System.out.println("Click");
        inv = new InventarioDAOJDBC();
        
        crearProducto();
        inv.insertar(prod);
      

    }//GEN-LAST:event_agregarButtonMouseClicked

    private void porcentajeBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_porcentajeBoxKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            float aumento = Float.parseFloat(porcentajeBox.getText());
            float rein = aumento * .6f;
            float gana = aumento * .4f;
            
            gananciaBox.setText(Float.toString(gana));
            reinversionBox.setText(Float.toString(rein));
            
            float pReinversion = Float.parseFloat(porcentajeBox.getText()) - Float.parseFloat(gananciaBox.getText());
            reinversionBox.setText(Float.toString(pReinversion));
            crearPrecios();
        }
    }//GEN-LAST:event_porcentajeBoxKeyPressed

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
        

    }//GEN-LAST:event_jToggleButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel agregarButton;
    private javax.swing.JTextField cantidadBox;
    private javax.swing.JTextField colorBox;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JTextField precioBox;
    private javax.swing.JTextField precioIVABox;
    private javax.swing.JTextField precioVentaBox;
    private javax.swing.JTextField provedorBox;
    private javax.swing.JLabel provedorLabel;
    private javax.swing.JTextField reinversionBox;
    private javax.swing.JLabel reinversion_label;
    private javax.swing.JCheckBox transporteCheck;
    // End of variables declaration//GEN-END:variables

    private double getPrecioCompra() {
        float precioCompra = 0;
        try {
            precioCompra = Float.parseFloat(precioBox.getText());
        } catch (NumberFormatException ex) {
            System.out.println("Precio de Compra Inválido");
        }
        return precioCompra;
    }
    
    private float getPGanancia() {
        return (Float.parseFloat(gananciaBox.getText()) / 100);
    }
    
    private float getPReinversion() {
        return (Float.parseFloat(reinversionBox.getText()) / 100);
    }
    
    private float getPTotal() {
        return (Float.parseFloat(porcentajeBox.getText()) / 100);
    }
    
    private float getPrecioVenta() {
        return Float.parseFloat(precioVentaBox.getText());
    }
    
    private float getPrecioIVA() {
        float pIVA;
        try {
            pIVA = Float.parseFloat(precioIVABox.getText());
        } catch (NumberFormatException ex) {
            pIVA = 0;
        }
        
        return pIVA;
    }
    
    private double precioCompra() {
        return getPrecioIVA() != 0 ? getPrecioIVA() : getPrecioCompra();
    }
    double pTotal;
    double ganancia;
    double reinversion;
    double precioVenta;

    //Este método agrega los porcentajes a las cajas de texto
    private void setPorcentage() {
        //La caja de texto convierte un Float a Strign, el cual es el porcentaje de aumento
        double aumento = gains.getGanancia(precioCompra());
        
        porcentajeBox.setText(Double.toString(aumento));

        //Multiplicamos el aumento por .4 y por .6, el valor más grande es para reinversión y el menor para aumento
        double rein = (10 / precioCompra()) * 100;
        double gana = aumento - rein;
        
        
        //
        reinversionBox.setText(Double.toString(Math.round(rein)));
        gananciaBox.setText(Double.toString(Math.round(gana)));
    }
    
    private void crearPrecios() {
        
        pTotal = (precioCompra() * getPTotal());
        ganancia = (precioCompra() * getPGanancia());
        reinversion = (precioCompra() * getPReinversion());
        precioVenta = precioCompra() + (precioCompra() * getPTotal());
        
        porcentaje_label.setText("$ " + Double.toString(Math.round(pTotal)));
        ganancia_label.setText("$ " + Double.toString(Math.round(ganancia)));
        reinversion_label.setText("$ " + Double.toString(Math.round(reinversion)));
        precioVentaBox.setText(Integer.toString((int) Math.round(precioVenta)));
        
    }
    
    private void crearProducto() {

        //Campos String
        prod.setNombreProducto(nombreBox.getText());
        prod.setMarca(marcaBox.getText());
        prod.setModelo(modeloBox.getText());
        prod.setColor(colorBox.getText());
        prod.setProvedor(provedorBox.getText());
        prod.setDescripcion(descripcionBox.getText());
        prod.setGarantia(garantiaBox.getText());

        //Campos Numericos
        try {
            prod.setCantidad(Integer.parseInt(cantidadBox.getText()));
            prod.setPrecioCompra(precioCompra());
            prod.setPrecioVenta(Float.parseFloat(precioVentaBox.getText()));
            prod.setGanancia(ganancia);
            prod.setReinversion(reinversion);
            prod.setPorcentajeGanancia(Float.parseFloat(gananciaBox.getText()));
            prod.setPorcentajeReinversion(Float.parseFloat(reinversionBox.getText()));
            
        } catch (NumberFormatException Ex) {
        }
        
    }
    
    private void initOwnComponents() {
        //Colorizacion
        jPanel1.setBackground(Colors.panel);
        
        agregarButton.setBackground(Colors.button);
        
        nombreBox.setBackground(Colors.textBox);
        marcaBox.setBackground(Colors.textBox);
        modeloBox.setBackground(Colors.textBox);
        colorBox.setBackground(Colors.textBox);
        cantidadBox.setBackground(Colors.textBox);
        provedorBox.setBackground(Colors.textBox);
        garantiaBox.setBackground(Colors.textBox);
        descripcionBox.setBackground(Colors.textBox);
        precioBox.setBackground(Colors.textBox);
        precioIVABox.setBackground(Colors.textBox);
        porcentajeBox.setBackground(Colors.textBox);
        gananciaBox.setBackground(Colors.textBox);
        reinversionBox.setBackground(Colors.textBox);
        transporteCheck.setBackground(Colors.panel);
        precioVentaBox.setBackground(Colors.textBox);
    }
}
