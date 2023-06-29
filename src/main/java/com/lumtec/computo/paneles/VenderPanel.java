package com.lumtec.computo.paneles;

import com.lumtec.computo.infra.Colors;
import com.lumtec.computo.infra.Go;
import com.lumtec.computo.infra.Imagenes.Images;
import com.lumtec.computo.infra.model.Carrito;
import com.lumtec.computo.infra.model.Producto;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;

public class VenderPanel extends javax.swing.JPanel {

    static int cantidad = 1;

    DefaultTableCellRenderer alinear;
    Go go = new Go();

    DefaultTableModel modelo;

    Producto prod;

    public VenderPanel() {

        initComponents();
        initOwnComponents();

        modeloTabla();
        //Rellenar la tabla con el historial
        for (int n = 0; n < Carrito.carrito.size(); n++) {
            modelo.addRow(Carrito.carrito.get(n));
        }
        idBox.requestFocus();
    }

    public VenderPanel(int id, String nombre) {

        initComponents();
        initOwnComponents();
        modeloTabla();
        //Rellenar la tabla con el historial
        for (int n = 0; n < Carrito.carrito.size(); n++) {
            modelo.addRow(Carrito.carrito.get(n));
        }

        /*prod = inve.select(id, nombre);

        idBox.setForeground(Colors.text);
        idBox.setText(Integer.toString(prod.getId()));*/
        rellenar();

        cantidadBox.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idBox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        producto_box = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        modeloBox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        precio_label = new javax.swing.JLabel();
        precioBox = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTabla = new javax.swing.JTable();
        totalLabel = new javax.swing.JLabel();
        precioTotal = new javax.swing.JLabel();
        añadirButton = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        venderButton = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cantidadBox = new javax.swing.JTextField();
        vaciButton = new javax.swing.JPanel();
        inveButton = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(860, 410));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(200, 200, 200));
        jPanel1.setMinimumSize(new java.awt.Dimension(860, 410));
        jPanel1.setPreferredSize(new java.awt.Dimension(860, 410));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Id:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 60, 20));

        idBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        idBox.setForeground(new java.awt.Color(255, 255, 255));
        idBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        idBox.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        idBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idBoxActionPerformed(evt);
            }
        });
        idBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idBoxKeyPressed(evt);
            }
        });
        jPanel1.add(idBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 190, 25));

        jLabel2.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Producto:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 25));

        producto_box.setEditable(false);
        producto_box.setBackground(new java.awt.Color(230, 230, 230));
        producto_box.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        producto_box.setForeground(new java.awt.Color(255, 255, 255));
        producto_box.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        producto_box.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        producto_box.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                producto_boxMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                producto_boxMouseExited(evt);
            }
        });
        jPanel1.add(producto_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 190, 25));

        jLabel3.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Modelo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 25));

        modeloBox.setEditable(false);
        modeloBox.setBackground(new java.awt.Color(230, 230, 230));
        modeloBox.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        modeloBox.setForeground(new java.awt.Color(255, 255, 255));
        modeloBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        modeloBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        modeloBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                modeloBoxMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                modeloBoxMouseExited(evt);
            }
        });
        jPanel1.add(modeloBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 190, 25));

        jLabel4.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad Vendida:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 20));

        precio_label.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        precio_label.setForeground(new java.awt.Color(255, 255, 255));
        precio_label.setText("Precio:");
        jPanel1.add(precio_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 50, 25));

        precioBox.setEditable(false);
        precioBox.setBackground(new java.awt.Color(230, 230, 230));
        precioBox.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        precioBox.setForeground(new java.awt.Color(255, 255, 255));
        precioBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        precioBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        precioBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                precioBoxMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                precioBoxMouseExited(evt);
            }
        });
        jPanel1.add(precioBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 190, 25));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        listaTabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {},
                        {},
                        {},
                        {}
                },
                new String[]{

                }
        ));
        jScrollPane1.setViewportView(listaTabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 350, 250));

        totalLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        totalLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalLabel.setText("Total:");
        jPanel1.add(totalLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 295, -1, -1));

        precioTotal.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        precioTotal.setForeground(new java.awt.Color(255, 255, 255));
        precioTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        precioTotal.setText("$-----");
        jPanel1.add(precioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 295, 60, -1));

        añadirButton.setBackground(new java.awt.Color(245, 245, 243));
        añadirButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        añadirButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                añadirButtonMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                añadirButtonMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                añadirButtonMouseExited(evt);
            }
        });
        añadirButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Añadir");
        añadirButton.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 7, -1, -1));

        jPanel1.add(añadirButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 270, 30));

        venderButton.setBackground(new java.awt.Color(245, 245, 243));
        venderButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        });
        venderButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Vender");
        venderButton.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 13, -1, -1));

        jPanel1.add(venderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 350, 40));

        cantidadBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cantidadBox.setForeground(new java.awt.Color(255, 255, 255));
        cantidadBox.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadBox.setText("1");
        cantidadBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        cantidadBox.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                cantidadBoxMouseWheelMoved(evt);
            }
        });
        cantidadBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cantidadBoxKeyPressed(evt);
            }
        });
        jPanel1.add(cantidadBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 60, 100, 25));

        vaciButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        vaciButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vaciButtonMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vaciButtonMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                vaciButtonMouseExited(evt);
            }
        });
        vaciButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(vaciButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 50, 50));

        inveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        inveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inveButtonMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inveButtonMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                inveButtonMouseExited(evt);
            }
        });
        jPanel1.add(inveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 50, 50));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 410));
    }// </editor-fold>//GEN-END:initComponents

    private void idBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idBoxActionPerformed

    }//GEN-LAST:event_idBoxActionPerformed

    private void idBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idBoxKeyPressed
        /*
        Caja de texto encargada de llamar la información del producto según la ID
         */

        int id = 0;
        String nombre = null;
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                id = Integer.parseInt(idBox.getText());

            } catch (NumberFormatException ex) {
                nombre = idBox.getText();
            }

            /*        prod = inve.select(id, nombre);*/
            rellenar();

            cantidadBox.requestFocus();
        }
    }//GEN-LAST:event_idBoxKeyPressed

    private void producto_boxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_producto_boxMouseEntered
        producto_box.setBackground(Colors.textBoxActivated);
    }//GEN-LAST:event_producto_boxMouseEntered

    private void producto_boxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_producto_boxMouseExited
        producto_box.setBackground(Colors.textBox);
    }//GEN-LAST:event_producto_boxMouseExited

    private void modeloBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modeloBoxMouseEntered
        modeloBox.setBackground(Colors.textBoxActivated);
    }//GEN-LAST:event_modeloBoxMouseEntered

    private void modeloBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modeloBoxMouseExited
        modeloBox.setBackground(Colors.textBox);
    }//GEN-LAST:event_modeloBoxMouseExited

    private void precioBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_precioBoxMouseEntered
        precioBox.setBackground(Colors.textBoxActivated);
    }//GEN-LAST:event_precioBoxMouseEntered

    private void precioBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_precioBoxMouseExited
        precioBox.setBackground(Colors.textBox);
    }//GEN-LAST:event_precioBoxMouseExited

    private void añadirButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_añadirButtonMouseClicked
        /*
        Este método se encarga de agregar un producto a la lista de compra
         */

        //Declarar todas las variables
       /* String[] variable = new String[4];
        int cantVend = Integer.parseInt(cantidadBox.getText());
       *//* double importe = prod.getPrecioVenta() * cantVend;*//*

        //Llenar la tabla con las variables
        variable[0] = Integer.toString(cantVend);
        variable[1] = prod.getNombreProducto();
        variable[2] = Double.toString(importe);

        //Se añade la información a una lista estática
        Carrito.carrito.add(variable);

        modelo.addRow(variable);*/

        //Mostrar total actual
        totalActual();

        //Limpiar cajas y clase Producto
        limpiarCajas();

    }//GEN-LAST:event_añadirButtonMouseClicked

    private void añadirButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_añadirButtonMouseEntered
        buttonEntered(añadirButton);
    }//GEN-LAST:event_añadirButtonMouseEntered

    private void añadirButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_añadirButtonMouseExited
        buttonExited(añadirButton);
    }//GEN-LAST:event_añadirButtonMouseExited

    private void venderButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_venderButtonMouseClicked
/*

        //Contar el número de productos listados
        int numProductosListados = listaTabla.getRowCount();

        //Crear un ciclo en donde se venda cada producto, fila por fila.
        for (int i = 0; i < numProductosListados; i++) {

            ConexionMultiple conexionMultiple = new ConexionMultiple();
            conexionMultiple.vender(listaTabla.getValueAt(i, 1).toString(), Integer.parseInt(listaTabla.getValueAt(i, 0).toString()));

            // Agregar a la base de datos ventas, en donde se guardan las finanzas
            
            Carrito.carrito.clear();
            Go.to(Home.computoPanel);


        }
        //Una vez vendidos los productos, se debe de eliminar el carritp
*/

    }//GEN-LAST:event_venderButtonMouseClicked

    private void venderButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_venderButtonMouseEntered
        buttonEntered(venderButton);
    }//GEN-LAST:event_venderButtonMouseEntered

    private void venderButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_venderButtonMouseExited
        buttonExited(venderButton);
    }//GEN-LAST:event_venderButtonMouseExited

    private void cantidadBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadBoxKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_UP && cantidad < prod.getCantidad()) {
            cantidad++;
            cantidadBox.setText(Integer.toString(cantidad));
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN && cantidad > 1) {
            cantidad--;
            cantidadBox.setText(Integer.toString(cantidad));
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            idBox.requestFocus();
        }

    }//GEN-LAST:event_cantidadBoxKeyPressed

    private void cantidadBoxMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_cantidadBoxMouseWheelMoved
        if (evt.getWheelRotation() == 1 && cantidad > 1) {
            cantidad--;
            cantidadBox.setText(Integer.toString(cantidad));
        } else if (evt.getWheelRotation() == -1 && cantidad < prod.getCantidad()) {
            cantidad++;
            cantidadBox.setText(Integer.toString(cantidad));
        }
    }//GEN-LAST:event_cantidadBoxMouseWheelMoved

    private void vaciButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vaciButtonMouseClicked
        Carrito.carrito.clear();
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
        precioTotal.setText("$-----");
    }//GEN-LAST:event_vaciButtonMouseClicked

    private void vaciButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vaciButtonMouseEntered
        vaciButton.setBackground(Colors.buttonPressed);
    }//GEN-LAST:event_vaciButtonMouseEntered

    private void vaciButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vaciButtonMouseExited
        vaciButton.setBackground(Colors.button);
    }//GEN-LAST:event_vaciButtonMouseExited

    private void inveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inveButtonMouseClicked
        Go.to(new InventarioPanel());
    }//GEN-LAST:event_inveButtonMouseClicked

    private void inveButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inveButtonMouseEntered
        inveButton.setBackground(Colors.buttonPressed);
    }//GEN-LAST:event_inveButtonMouseEntered

    private void inveButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inveButtonMouseExited
        inveButton.setBackground(Colors.button);
    }//GEN-LAST:event_inveButtonMouseExited

    //Este método sirve cuando se coloca el mouse dentro de un boton
    private void buttonEntered(JPanel panel) {
        panel.setBackground(Colors.buttonPressed);
    }

    //Este método sirve cuando se coloca el mouse fuera de un boton
    private void buttonExited(JPanel panel) {
        panel.setBackground(Colors.button);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel añadirButton;
    private javax.swing.JTextField cantidadBox;
    private javax.swing.JTextField idBox;
    private javax.swing.JPanel inveButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaTabla;
    private javax.swing.JTextField modeloBox;
    private javax.swing.JTextField precioBox;
    private javax.swing.JLabel precioTotal;
    private javax.swing.JLabel precio_label;
    private javax.swing.JTextField producto_box;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JPanel vaciButton;
    private javax.swing.JPanel venderButton;
    // End of variables declaration//GEN-END:variables

    private void rellenar() {
        //Rellenar el campo de cantVend, si es cero, entonces será cero
        if (prod.getCantidad() > 0) {
            cantidadBox.setText("1");
        } else {
            cantidadBox.setText("0");
        }

        producto_box.setText(prod.getNombre());
        modeloBox.setText(prod.getModelo());
        /* precioBox.setText("$ " + Double.toString(prod.getPrecioVenta()));*/
    }

    private void totalActual() {
        int var = listaTabla.getRowCount();
        float total = 0;
        for (int i = 0; i < var; i++) {
            String precioPA = listaTabla.getValueAt(i, 2).toString();
            float precioProductoActual = Float.parseFloat(precioPA);
            total = precioProductoActual + total;
        }

        precioTotal.setText(Float.toString(total));
    }

    private void modeloTabla() {

        modelo = new DefaultTableModel();
        alinear = new DefaultTableCellRenderer();
        alinear.setHorizontalAlignment(SwingConstants.CENTER);
        modelo.addColumn("Cantidad");
        modelo.addColumn("Producto");
        modelo.addColumn("Total");

        listaTabla.setModel(modelo);

        listaTabla.getColumnModel().getColumn(0).setMaxWidth(70);
        listaTabla.getColumnModel().getColumn(2).setMaxWidth(70);
        listaTabla.getColumnModel().getColumn(2).setCellRenderer(alinear);
        listaTabla.setRowHeight(18);
    }

    private void initOwnComponents() {
        //Colorizacion
        jPanel1.setBackground(Colors.panel);

        añadirButton.setBackground(Colors.button);
        venderButton.setBackground(Colors.button);
        vaciButton.setBackground(Colors.button);
        inveButton.setBackground(Colors.button);

        idBox.setBackground(Colors.textBox);
        cantidadBox.setBackground(Colors.textBox);
        producto_box.setBackground(Colors.textBox);
        modeloBox.setBackground(Colors.textBox);
        precioBox.setBackground(Colors.textBox);

        //Imagenes
        vaciButton.add(Images.carriIcon, new AbsoluteConstraints(0, 0, 50, 50));

        //Métodos
        //Se crea un nuevo producto para
        prod = new Producto();

    }

    private void limpiarCajas() {
        prod.reset();
        idBox.setText(null);
        producto_box.setText(null);
        modeloBox.setText(null);
        precioBox.setText(null);
        cantidadBox.setText("1");
    }
}
