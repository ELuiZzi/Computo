package com.lumtec.computo.paneles;

import com.lumtec.computo.controllers.CommonController;
import com.lumtec.computo.controllers.EditarProductoController;
import com.lumtec.computo.infra.Colors;


public class EditarPanel extends javax.swing.JPanel {
    private final EditarProductoController editarProductoController;

    private final CommonController commonController;
    private javax.swing.JComboBox<String> provedorBox;

    public EditarPanel() {
        commonController = new CommonController();
        initComponents();

        editarProductoController = new EditarProductoController(
                this.busquedaBox,
                this.nombreProductoBox,
                this.marcaBox,
                this.modeloBox,
                this.cantidadBox,
                this.provedorBox,
                this.descripcionBox,
                this.precioCompraBox,
                this.precioVentaBox,
                this.gananciaBox,
                this.reinversionBox,
                this.porcentajeGananciaBox,
                this.porcentajeReinversionBox,
                this.sliderPorcentaje,
                this.garantiaBox

        );
        initOwnComponents();

    }

    //Este constructor precarga las cajas.
    public EditarPanel(String nombre) {
        commonController = new CommonController();
        initComponents();

        editarProductoController = new EditarProductoController(
                this.busquedaBox,
                this.nombreProductoBox,
                this.marcaBox,
                this.modeloBox,
                this.cantidadBox,
                this.provedorBox,
                this.descripcionBox,
                this.precioCompraBox,
                this.precioVentaBox,
                this.gananciaBox,
                this.reinversionBox,
                this.porcentajeGananciaBox,
                this.porcentajeReinversionBox,
                this.sliderPorcentaje,
                this.garantiaBox

        );

        editarProductoController.cargarProducto(nombre);

        initOwnComponents();
    }

    private void busquedaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaBoxActionPerformed

    }//GEN-LAST:event_busquedaBoxActionPerformed

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editarProductoPanel = new javax.swing.JPanel();
        nombreProductoBox = new javax.swing.JTextField();
        nombre_Label = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        marcaBox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        modeloBox = new javax.swing.JTextField();
        Descripcion_Label = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        precioCompraBox = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        precioVentaBox = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        gananciaBox = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        reinversionBox = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cantidadBox = new javax.swing.JTextField();
        porcentajeGananciaBox = new javax.swing.JTextField();
        porcentajeReinversionBox = new javax.swing.JTextField();
        sliderPorcentaje = new javax.swing.JSlider();
        porcentajeLabel = new javax.swing.JLabel();
        provedorLabel = new javax.swing.JLabel();
        actualizarButton = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        garantiaBox = new javax.swing.JTextField();
        ivaButton = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        busquedaBox = new javax.swing.JTextField();
        buscarProductoLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcionBox = new javax.swing.JTextArea();
        provedorBox = new javax.swing.JComboBox<>();

        setMinimumSize(new java.awt.Dimension(860, 410));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editarProductoPanel.setBackground(new java.awt.Color(200, 200, 200));
        editarProductoPanel.setAutoscrolls(true);
        editarProductoPanel.setMinimumSize(new java.awt.Dimension(860, 410));
        editarProductoPanel.setPreferredSize(new java.awt.Dimension(860, 410));
        editarProductoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreProductoBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nombreProductoBox.setForeground(new java.awt.Color(255, 255, 255));
        nombreProductoBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombreProductoBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        nombreProductoBox.setNextFocusableComponent(marcaBox);
        editarProductoPanel.add(nombreProductoBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 250, 30));

        nombre_Label.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        nombre_Label.setForeground(new java.awt.Color(255, 255, 255));
        nombre_Label.setText("Nombre:");
        editarProductoPanel.add(nombre_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 25));

        jLabel2.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Marca:");
        editarProductoPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 25));

        marcaBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        marcaBox.setForeground(new java.awt.Color(255, 255, 255));
        marcaBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        marcaBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        marcaBox.setNextFocusableComponent(modeloBox);
        editarProductoPanel.add(marcaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 250, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Modelo:");
        editarProductoPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, 25));

        modeloBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        modeloBox.setForeground(new java.awt.Color(255, 255, 255));
        modeloBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        modeloBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        editarProductoPanel.add(modeloBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 250, 30));

        Descripcion_Label.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        Descripcion_Label.setForeground(new java.awt.Color(255, 255, 255));
        Descripcion_Label.setText("Descripción:");
        editarProductoPanel.add(Descripcion_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, 25));

        jLabel6.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Precio de Compra:");
        editarProductoPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, 25));

        precioCompraBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        precioCompraBox.setForeground(new java.awt.Color(255, 255, 255));
        precioCompraBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        precioCompraBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        precioCompraBox.setNextFocusableComponent(precioVentaBox);
        precioCompraBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                precioCompraBoxKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                precioCompraBoxKeyReleased(evt);
            }
        });
        editarProductoPanel.add(precioCompraBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 230, 25));

        jLabel7.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Precio de Venta:");
        editarProductoPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, 25));

        precioVentaBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        precioVentaBox.setForeground(new java.awt.Color(255, 255, 255));
        precioVentaBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        precioVentaBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        precioVentaBox.setNextFocusableComponent(gananciaBox);
        editarProductoPanel.add(precioVentaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 230, 25));

        jLabel8.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ganancia:");
        editarProductoPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, -1, 25));

        gananciaBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        gananciaBox.setForeground(new java.awt.Color(255, 255, 255));
        gananciaBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gananciaBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gananciaBox.setNextFocusableComponent(reinversionBox);
        gananciaBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gananciaBoxKeyPressed(evt);
            }
        });
        editarProductoPanel.add(gananciaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 230, 25));

        jLabel9.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Reinversión:");
        editarProductoPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, -1, 25));

        reinversionBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        reinversionBox.setForeground(new java.awt.Color(255, 255, 255));
        reinversionBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        reinversionBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        reinversionBox.setNextFocusableComponent(porcentajeGananciaBox);
        reinversionBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                reinversionBoxKeyPressed(evt);
            }
        });
        editarProductoPanel.add(reinversionBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 230, 25));

        jLabel11.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cantidad:");
        editarProductoPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 25));

        cantidadBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cantidadBox.setForeground(new java.awt.Color(255, 255, 255));
        cantidadBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cantidadBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cantidadBox.setNextFocusableComponent(provedorBox);
        editarProductoPanel.add(cantidadBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 250, 30));

        porcentajeGananciaBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        porcentajeGananciaBox.setForeground(new java.awt.Color(153, 153, 153));
        porcentajeGananciaBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        porcentajeGananciaBox.setText("Ganancia");
        porcentajeGananciaBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        porcentajeGananciaBox.setNextFocusableComponent(porcentajeReinversionBox);
        porcentajeGananciaBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                porcentajeGananciaBoxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                porcentajeGananciaBoxFocusLost(evt);
            }
        });
        porcentajeGananciaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                porcentajeGananciaBoxActionPerformed(evt);
            }
        });
        porcentajeGananciaBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                porcentajeGananciaBoxKeyPressed(evt);
            }
        });
        editarProductoPanel.add(porcentajeGananciaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 100, 25));

        porcentajeReinversionBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        porcentajeReinversionBox.setForeground(new java.awt.Color(153, 153, 153));
        porcentajeReinversionBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        porcentajeReinversionBox.setText("Reinversión");
        porcentajeReinversionBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        porcentajeReinversionBox.setNextFocusableComponent(garantiaBox);
        porcentajeReinversionBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                porcentajeReinversionBoxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                porcentajeReinversionBoxFocusLost(evt);
            }
        });
        porcentajeReinversionBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                porcentajeReinversionBoxKeyPressed(evt);
            }
        });
        editarProductoPanel.add(porcentajeReinversionBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 100, 25));

        sliderPorcentaje.setBackground(new java.awt.Color(204, 204, 204));
        sliderPorcentaje.setForeground(new java.awt.Color(0, 0, 0));
        sliderPorcentaje.setMajorTickSpacing(20);
        sliderPorcentaje.setMaximum(200);
        sliderPorcentaje.setPaintTicks(true);
        sliderPorcentaje.setValue(100);
        sliderPorcentaje.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderPorcentajeStateChanged(evt);
            }
        });
        editarProductoPanel.add(sliderPorcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 180, 25));

        porcentajeLabel.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        porcentajeLabel.setForeground(new java.awt.Color(255, 255, 255));
        porcentajeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        porcentajeLabel.setText("100 %");
        editarProductoPanel.add(porcentajeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 260, 40, 25));

        provedorLabel.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        provedorLabel.setForeground(new java.awt.Color(255, 255, 255));
        provedorLabel.setText("Provedor:");
        editarProductoPanel.add(provedorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, 25));

        actualizarButton.setBackground(new java.awt.Color(245, 245, 243));
        actualizarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        actualizarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actualizarButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                actualizarButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                actualizarButtonMouseExited(evt);
            }
        });
        actualizarButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 204));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Actualizar");
        actualizarButton.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 30));

        editarProductoPanel.add(actualizarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 365, 110, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Garantía:");
        editarProductoPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, -1, 25));

        garantiaBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        garantiaBox.setForeground(new java.awt.Color(255, 255, 255));
        garantiaBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        garantiaBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        editarProductoPanel.add(garantiaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, 230, 25));

        ivaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ivaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ivaButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ivaButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ivaButtonMouseExited(evt);
            }
        });
        ivaButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        editarProductoPanel.add(ivaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, 25, 25));

        jPanel1.setBackground(new java.awt.Color(100, 100, 100));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        busquedaBox.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        busquedaBox.setForeground(new java.awt.Color(150, 150, 150));
        busquedaBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        busquedaBox.setText("ID");
        busquedaBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        busquedaBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                busquedaBoxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                busquedaBoxFocusLost(evt);
            }
        });
        busquedaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaBoxActionPerformed(evt);
            }
        });
        busquedaBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                busquedaBoxKeyPressed(evt);
            }
        });
        jPanel1.add(busquedaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 7, 300, 30));

        buscarProductoLabel.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        buscarProductoLabel.setForeground(new java.awt.Color(255, 255, 255));
        buscarProductoLabel.setText("Buscar Producto:");
        jPanel1.add(buscarProductoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 7, -1, 30));

        editarProductoPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 45));

        jSeparator2.setBackground(new java.awt.Color(200, 200, 200));
        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        editarProductoPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 38, -1, 370));

        jScrollPane1.setBackground(new java.awt.Color(70, 70, 70));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        descripcionBox.setColumns(20);
        descripcionBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        descripcionBox.setForeground(new java.awt.Color(255, 255, 255));
        descripcionBox.setRows(5);
        descripcionBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(descripcionBox);

        editarProductoPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 250, 96));

        provedorBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        provedorBox.setForeground(new java.awt.Color(255, 255, 255));
        provedorBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        editarProductoPanel.add(provedorBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 250, 30));

        add(editarProductoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 410));
    }// </editor-fold>//GEN-END:initComponents

    private void precioCompraBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioCompraBoxKeyPressed

    }//GEN-LAST:event_precioCompraBoxKeyPressed

    private void gananciaBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gananciaBoxKeyPressed

    }//GEN-LAST:event_gananciaBoxKeyPressed

    private void reinversionBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reinversionBoxKeyPressed

    }//GEN-LAST:event_reinversionBoxKeyPressed

    private void porcentajeGananciaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porcentajeGananciaBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_porcentajeGananciaBoxActionPerformed

    private void porcentajeGananciaBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_porcentajeGananciaBoxKeyPressed

    }//GEN-LAST:event_porcentajeGananciaBoxKeyPressed

    private void porcentajeReinversionBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_porcentajeReinversionBoxKeyPressed

    }//GEN-LAST:event_porcentajeReinversionBoxKeyPressed

    private void sliderPorcentajeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderPorcentajeStateChanged


    }//GEN-LAST:event_sliderPorcentajeStateChanged

    private void busquedaBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_busquedaBoxKeyPressed

        /*int id = 0;
        String nombre = null;

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            inve = new InventarioDAOJDBC();

            try {
                id = Integer.parseInt(busquedaBox.getText());
            } catch (NumberFormatException ex) {
                nombre = busquedaBox.getText();
            }

            prod = inve.select(id, nombre);
            llenarCajas();

        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            editarProductoPanel.requestFocus();
        }*/
    }//GEN-LAST:event_busquedaBoxKeyPressed

    private void actualizarButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarButtonMouseEntered
        actualizarButton.setBackground(Colors.buttonPressed);
    }//GEN-LAST:event_actualizarButtonMouseEntered

    private void actualizarButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarButtonMouseExited
        actualizarButton.setBackground(Colors.button);
    }//GEN-LAST:event_actualizarButtonMouseExited

    private void busquedaBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_busquedaBoxFocusGained
        if (busquedaBox.getText().equals("ID")) {
            busquedaBox.setText("");
            busquedaBox.setForeground(Colors.text);
        } else {
            busquedaBox.selectAll();
        }
    }//GEN-LAST:event_busquedaBoxFocusGained

    private void busquedaBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_busquedaBoxFocusLost
        if (busquedaBox.getText().equals("")) {
            busquedaBox.setText("ID");
            busquedaBox.setForeground(Colors.textBlocked);
        }
    }//GEN-LAST:event_busquedaBoxFocusLost

    int boo = 3;
    int doo = 0;
    static float ivaProducto = 0, precioCompraOrig = 0;

    private void ivaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ivaButtonMouseClicked


    }//GEN-LAST:event_ivaButtonMouseClicked

    private void actualizarButtonMouseClicked(java.awt.event.MouseEvent evt) {
        editarProductoController.actualizarProducto();

    }

    private void ivaButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ivaButtonMouseEntered
        if (boo == 0 || boo == 3) {
            ivaButton.setBackground(Colors.panel);
        } else if (boo == 1) {
            ivaButton.setBackground(Colors.buttonPressed);
        }
    }//GEN-LAST:event_ivaButtonMouseEntered

    private void ivaButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ivaButtonMouseExited
        if (boo == 0 || boo == 3) {
            ivaButton.setBackground(Colors.panel);
        } else if (boo == 1) {
            ivaButton.setBackground(Colors.buttonPressed);
        }


    }//GEN-LAST:event_ivaButtonMouseExited

    private void porcentajeGananciaBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_porcentajeGananciaBoxFocusGained
        if (porcentajeGananciaBox.getText().equals("Ganancia")) {
            porcentajeGananciaBox.setText(null);
            porcentajeGananciaBox.setForeground(Colors.text);
        }

    }//GEN-LAST:event_porcentajeGananciaBoxFocusGained

    private void porcentajeReinversionBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_porcentajeReinversionBoxFocusGained
        if (porcentajeReinversionBox.getText().equals("Reinversión")) {
            porcentajeReinversionBox.setText(null);
            porcentajeReinversionBox.setForeground(Colors.text);
        }
    }//GEN-LAST:event_porcentajeReinversionBoxFocusGained

    private void porcentajeGananciaBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_porcentajeGananciaBoxFocusLost
        if (porcentajeGananciaBox.getText().equals("")) {
            porcentajeGananciaBox.setText("Ganancia");
            porcentajeGananciaBox.setForeground(Colors.textBlocked);
        }
    }//GEN-LAST:event_porcentajeGananciaBoxFocusLost

    private void porcentajeReinversionBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_porcentajeReinversionBoxFocusLost
        if (porcentajeReinversionBox.getText().equals("")) {
            porcentajeReinversionBox.setText("Reinversión");
            porcentajeReinversionBox.setForeground(Colors.textBlocked);
        }
    }//GEN-LAST:event_porcentajeReinversionBoxFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Descripcion_Label;
    private javax.swing.JPanel actualizarButton;
    private javax.swing.JLabel buscarProductoLabel;
    private javax.swing.JTextField busquedaBox;
    private javax.swing.JTextField cantidadBox;
    private javax.swing.JTextArea descripcionBox;
    private javax.swing.JPanel editarProductoPanel;
    private javax.swing.JTextField gananciaBox;
    private javax.swing.JTextField garantiaBox;
    private javax.swing.JPanel ivaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField marcaBox;
    private javax.swing.JTextField modeloBox;
    private javax.swing.JTextField nombreProductoBox;
    private javax.swing.JLabel nombre_Label;
    private javax.swing.JTextField porcentajeGananciaBox;
    private javax.swing.JLabel porcentajeLabel;
    private javax.swing.JTextField porcentajeReinversionBox;
    private javax.swing.JTextField precioCompraBox;
    private javax.swing.JTextField precioVentaBox;

    private void precioCompraBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioCompraBoxKeyReleased

    }//GEN-LAST:event_precioCompraBoxKeyReleased
    private javax.swing.JLabel provedorLabel;
    private javax.swing.JTextField reinversionBox;
    private javax.swing.JSlider sliderPorcentaje;
    // End of variables declaration//GEN-END:variables

    private void initOwnComponents() {
        //Colorizacion
        editarProductoPanel.setBackground(Colors.panel);
        jPanel1.setBackground(Colors.banner2);

        //Fondos de las cajas de texto
        busquedaBox.setBackground(Colors.textBox);
        nombreProductoBox.setBackground(Colors.textBox);
        marcaBox.setBackground(Colors.textBox);
        modeloBox.setBackground(Colors.textBox);
        cantidadBox.setBackground(Colors.textBox);
        provedorBox.setBackground(Colors.textBox);
        descripcionBox.setBackground(Colors.textBox);
        precioCompraBox.setBackground(Colors.textBox);
        precioVentaBox.setBackground(Colors.textBox);
        gananciaBox.setBackground(Colors.textBox);
        reinversionBox.setBackground(Colors.textBox);
        porcentajeGananciaBox.setBackground(Colors.textBox);
        porcentajeReinversionBox.setBackground(Colors.textBox);
        garantiaBox.setBackground(Colors.textBox);

        sliderPorcentaje.setBackground(Colors.panel);
        ivaButton.setBackground(Colors.panel);

        //Color de texto
        busquedaBox.setForeground(Colors.textBlocked);
        porcentajeGananciaBox.setForeground(Colors.textBlocked);
        porcentajeReinversionBox.setForeground(Colors.textBlocked);

        actualizarButton.setBackground(Colors.button);


        commonController.cargarListaProvedores(provedorBox);

        //Métodos
        // ivaButton.add(Images.getIvaEnable(), posi);
    }


}
