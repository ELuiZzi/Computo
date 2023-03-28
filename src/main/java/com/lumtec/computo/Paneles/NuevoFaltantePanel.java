package com.lumtec.computo.Paneles;

import com.lumtec.computo.Colors;
import com.lumtec.computo.Faltante;
import com.lumtec.computo.Faltantes.*;
import com.lumtec.computo.Imagenes.Images;
import java.awt.event.KeyEvent;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class NuevoFaltantePanel extends javax.swing.JPanel {

    FaltantesDAO faltDAO = new FaltantesDAOJDBC();
    Faltante falt = new Faltante();
    ;
    AbsoluteConstraints posi = new AbsoluteConstraints(0, 0);

    public NuevoFaltantePanel() {
        initComponents();
        initOwnComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombreBox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        marcaBox = new javax.swing.JTextField();
        modeloBox = new javax.swing.JTextField();
        colorBox = new javax.swing.JTextField();
        cantidadBox = new javax.swing.JTextField();
        precioBox = new javax.swing.JTextField();
        provedorLabel = new javax.swing.JLabel();
        provedorBox = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        busquedaBox = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        aplicarButton = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        ivaButton = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcionBox = new javax.swing.JTextArea();

        setMinimumSize(new java.awt.Dimension(860, 410));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(860, 410));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel1.setPreferredSize(new java.awt.Dimension(860, 410));
        Panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");
        Panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 25));

        nombreBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nombreBox.setForeground(new java.awt.Color(255, 255, 255));
        nombreBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombreBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        nombreBox.setNextFocusableComponent(marcaBox);
        Panel1.add(nombreBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 60, 230, 25));

        jLabel2.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Marca:");
        Panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 25));

        jLabel3.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Modelo:");
        Panel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, 25));

        jLabel4.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Color:");
        Panel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, 25));

        jLabel5.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cantidad:");
        Panel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 25));

        jLabel6.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Descripcion:");
        Panel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, 25));

        jLabel7.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Precio de Compra:");
        Panel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, 25));

        marcaBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        marcaBox.setForeground(new java.awt.Color(255, 255, 255));
        marcaBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        marcaBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        marcaBox.setNextFocusableComponent(modeloBox);
        marcaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcaBoxActionPerformed(evt);
            }
        });
        Panel1.add(marcaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 100, 230, 25));

        modeloBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        modeloBox.setForeground(new java.awt.Color(255, 255, 255));
        modeloBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        modeloBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        modeloBox.setNextFocusableComponent(colorBox);
        Panel1.add(modeloBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 140, 230, 25));

        colorBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        colorBox.setForeground(new java.awt.Color(255, 255, 255));
        colorBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        colorBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        colorBox.setNextFocusableComponent(cantidadBox);
        Panel1.add(colorBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 180, 230, 25));

        cantidadBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cantidadBox.setForeground(new java.awt.Color(255, 255, 255));
        cantidadBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cantidadBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cantidadBox.setNextFocusableComponent(precioBox);
        Panel1.add(cantidadBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 220, 230, 25));

        precioBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        precioBox.setForeground(new java.awt.Color(255, 255, 255));
        precioBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        precioBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        precioBox.setNextFocusableComponent(provedorBox);
        precioBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioBoxActionPerformed(evt);
            }
        });
        Panel1.add(precioBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 230, 25));

        provedorLabel.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        provedorLabel.setForeground(new java.awt.Color(255, 255, 255));
        provedorLabel.setText("Provedor:");
        Panel1.add(provedorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, 25));

        provedorBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        provedorBox.setForeground(new java.awt.Color(255, 255, 255));
        provedorBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        provedorBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        provedorBox.setNextFocusableComponent(descripcionBox);
        Panel1.add(provedorBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 260, 230, 25));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial", 3, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Editar Producto:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 7, 110, 30));

        busquedaBox.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        busquedaBox.setForeground(new java.awt.Color(200, 200, 200));
        busquedaBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        busquedaBox.setText("ID");
        busquedaBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        busquedaBox.setNextFocusableComponent(nombreBox);
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

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 43, 860, 10));

        Panel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 45));

        aplicarButton.setBackground(new java.awt.Color(210, 210, 210));
        aplicarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aplicarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aplicarButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aplicarButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aplicarButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                aplicarButtonMousePressed(evt);
            }
        });
        aplicarButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Aplicar");
        aplicarButton.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 30));

        Panel1.add(aplicarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 365, 110, 30));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Panel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 45, -1, 368));

        ivaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ivaButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Panel1.add(ivaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, 25, 25));

        jScrollPane1.setBackground(new java.awt.Color(70, 70, 70));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        descripcionBox.setColumns(20);
        descripcionBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        descripcionBox.setForeground(new java.awt.Color(255, 255, 255));
        descripcionBox.setRows(5);
        jScrollPane1.setViewportView(descripcionBox);

        Panel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 300, 230, 96));

        add(Panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 410));
    }// </editor-fold>//GEN-END:initComponents

    private void precioBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioBoxActionPerformed
    }//GEN-LAST:event_precioBoxActionPerformed

    private void busquedaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaBoxActionPerformed

    }//GEN-LAST:event_busquedaBoxActionPerformed

    private void busquedaBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_busquedaBoxKeyPressed
        /*
        Si la tecla presionada es la asiganda para buscar, podemos comenzar el proceso de busqueda.
         */
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            /*
            Asigamos el id del producto con la ayuda de un try-catch, en caso de algun error,
            del cual se seleccionara todo la infromación de la base de datos.
             */
            try {
                falt.setId_producto(Integer.parseInt(busquedaBox.getText()));
            } catch (NumberFormatException ex) {
                busquedaBox.setText("Ingresar ID Válido");
            }

            /*
            Al objeto faltante se completa con los datos obtenidos en la busqueda.
             */
            falt = faltDAO.select(falt.getId_producto());

            /*
            Se llenan las Cajas
             */
            llenarCajas(falt);
        }
    }//GEN-LAST:event_busquedaBoxKeyPressed

    private void busquedaBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_busquedaBoxFocusGained
        /*
        Vaciar la caja en caso de que el texto sea ID
         */
        if (getBusquedaBox().equals("ID")) {
            busquedaBox.setText(null);
            busquedaBox.setForeground(Colors.text);
        }

    }//GEN-LAST:event_busquedaBoxFocusGained

    private void busquedaBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_busquedaBoxFocusLost
        if (getBusquedaBox().equals("")) {
            busquedaBox.setText("ID");
            busquedaBox.setForeground(Colors.textBlocked);
        }
    }//GEN-LAST:event_busquedaBoxFocusLost

    private void marcaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcaBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marcaBoxActionPerformed

    /*
    Botón de agregar o actualizar Faltante
     */
    private void aplicarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aplicarButtonMouseClicked

        int id = 0;
        int cantidad = 0;
        float precioCompra = 0f;
        /*
        Asignar valores de las cajas al Faltante, ya sea nuevo o actualizacion
         */
        falt.setNombre_producto(nombreBox.getText());
        falt.setMarca(marcaBox.getText());
        falt.setModelo(modeloBox.getText());
        falt.setColor(colorBox.getText());
        falt.setMarca(marcaBox.getText());
        falt.setProvedor(provedorBox.getText());
        falt.setDescripcion(descripcionBox.getText());

        /*
        Los valores númericos van en un try-catch, en caso de que den un error, no se lleva a cabo la actualización en la Base de Datos
         */
        try {
            id = Integer.parseInt(getBusquedaBox());
            cantidad = Integer.parseInt(cantidadBox.getText());
            precioCompra = Float.parseFloat(precioBox.getText());
            falt.setCantidad(cantidad);
            falt.setPrecio_compra(precioCompra);

            /*
            Si el ID es exitente, se actualiza, de lo contario y en caso de que el id producto sea nulo se agrega
             */
            if (falt.getId_producto() == id) {
                faltDAO.editar(id, falt);
            } else {
                faltDAO.nuevoFaltante(falt);
            }

        } catch (java.lang.NumberFormatException ex) {
            cantidadBox.setText(("Dato Inválido"));
            precioBox.setText("Dato Inválido");
        }

    }//GEN-LAST:event_aplicarButtonMouseClicked

    private void aplicarButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aplicarButtonMouseEntered
        aplicarButton.setBackground(Colors.buttonPressed);
    }//GEN-LAST:event_aplicarButtonMouseEntered

    private void aplicarButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aplicarButtonMouseExited
        aplicarButton.setBackground(Colors.button);
    }//GEN-LAST:event_aplicarButtonMouseExited

    private void aplicarButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aplicarButtonMousePressed
        aplicarButton.setBackground(Colors.button);
    }//GEN-LAST:event_aplicarButtonMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel aplicarButton;
    private javax.swing.JTextField busquedaBox;
    private javax.swing.JTextField cantidadBox;
    private javax.swing.JTextField colorBox;
    private javax.swing.JTextArea descripcionBox;
    private javax.swing.JPanel ivaButton;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField marcaBox;
    private javax.swing.JTextField modeloBox;
    private javax.swing.JTextField nombreBox;
    private javax.swing.JTextField precioBox;
    private javax.swing.JTextField provedorBox;
    private javax.swing.JLabel provedorLabel;
    // End of variables declaration//GEN-END:variables

    /*
    Devuelve el string que esta dentro de la caja de busqueda.
     */
    private String getBusquedaBox() {

        return busquedaBox.getText();

    }

    /*
    Llenar las cajas con los datos de un ubjeto tipo Faltante
     */
    private void llenarCajas(Faltante falt) {
        nombreBox.setText(falt.getNombre_producto());
        marcaBox.setText(falt.getMarca());
        modeloBox.setText(falt.getModelo());
        colorBox.setText(falt.getColor());
        cantidadBox.setText(Integer.toString(falt.getCantidad()));
        precioBox.setText(Float.toString(falt.getPrecio_compra()));
        descripcionBox.setText(falt.getDescripcion());
        provedorBox.setText(falt.getProvedor());
    }

    private void activarBotonIva() {
        ivaButton.removeAll();
        ivaButton.setBackground(Colors.button);
        ivaButton.add(Images.getIvaDisable(), posi);
        Panel1.revalidate();
        Panel1.repaint();
    }

    private void desactivarBotonIva() {
        ivaButton.removeAll();
        ivaButton.setBackground(Colors.buttonPressed);
        ivaButton.add(Images.getIvaEnable(), posi);
        Panel1.revalidate();
        Panel1.repaint();
    }

    private void initOwnComponents() {
        //Colorizacion
        Panel1.setBackground(Colors.panel);
        ivaButton.setBackground(Colors.button);
        jPanel1.setBackground(Colors.banner2);

        busquedaBox.setBackground(Colors.textBox);
        busquedaBox.setForeground(Colors.textBlocked);

        nombreBox.setBackground(Colors.textBox);
        marcaBox.setBackground(Colors.textBox);
        modeloBox.setBackground(Colors.textBox);
        colorBox.setBackground(Colors.textBox);
        cantidadBox.setBackground(Colors.textBox);
        provedorBox.setBackground(Colors.textBox);
        descripcionBox.setBackground(Colors.textBox);
        precioBox.setBackground(Colors.textBox);

        aplicarButton.setBackground(Colors.button);
        //Ajustar mas tarde
        ivaButton.add(Images.getIvaEnable(), posi);
    }
}
