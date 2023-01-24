package com.lumtec.computo.Paneles;

import com.lumtec.computo.Colors;
import com.lumtec.computo.HerramientasTabla;
import com.lumtec.computo.IrA;
import com.lumtec.computo.Search;
import com.lumtec.computo.Shortcuts;
import com.lumtec.computo.test;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class InventarioPanel extends javax.swing.JPanel {

    DefaultTableModel model;
    DefaultTableCellRenderer alinear;
    HerramientasTabla conf = new HerramientasTabla();
    Connection con;
    PreparedStatement pps;
    ResultSet rs;
    String[] datos;
    IrA a;
    Search sear;

    Shortcuts sc = new Shortcuts();

    public InventarioPanel() {
        initComponents();
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

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(70, 70, 70));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tablaInventario.setBackground(new java.awt.Color(250, 250, 250));
        tablaInventario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tablaInventario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablaInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

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
        searchBar.add(barraBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 7, 410, 30));

        rowsCountLabel.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        rowsCountLabel.setForeground(new java.awt.Color(255, 255, 255));
        rowsCountLabel.setText("Número de Productos: 50");
        searchBar.add(rowsCountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 6, -1, 30));

        jPanel1.add(searchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 45));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 410));
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            a = new IrA();
            a.computo();
        }
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        jPanel1.requestFocus();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void tablaInventarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaInventarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            conf.eliminarId("inventario", tablaInventario, con, pps);
            rellenarTabla();
        } else if (evt.getKeyCode() == KeyEvent.VK_E) {
            sc.editProd(tablaInventario);
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
        //Caputarmos el carácter que acabamos de presionar, el cuál se buscará en la tabla
        char c = evt.getKeyChar();

        //En caso de que se presione la tecla 'retroceso' hace una desbusqueda.
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            String texto = barraBusqueda.getText();
            int length = texto.length();
            char A = '\0';
            char B = '\0';
            try {
                A = texto.charAt(length - 3);
                B = texto.charAt(length - 2);
            } catch (StringIndexOutOfBoundsException ex) {
                try {
                    B = texto.charAt(length - 2);
                } catch (StringIndexOutOfBoundsException exs) {
                }
            }
            System.out.println("A = " + A);
            System.out.println("B = " + B);
            sear.desBusque(A, B);
        } //Método para buscar el carácter presionado
        else {
            sear.busque(c);
        }

        fillCountRowLabel(); //Nos indica el número de resulstados encontrados
    }//GEN-LAST:event_barraBusquedaKeyPressed

    private void alinearColumnas() {
        tablaInventario.getColumnModel().getColumn(0).setMinWidth(25);
        tablaInventario.getColumnModel().getColumn(0).setMaxWidth(25);
        tablaInventario.getColumnModel().getColumn(0).setCellRenderer(alinear);
        tablaInventario.getColumnModel().getColumn(1).setMinWidth(300);
        tablaInventario.getColumnModel().getColumn(1).setMaxWidth(300);
        tablaInventario.getColumnModel().getColumn(1).setCellRenderer(alinear);
        tablaInventario.getColumnModel().getColumn(2).setMinWidth(130);
        tablaInventario.getColumnModel().getColumn(2).setMaxWidth(130);
        tablaInventario.getColumnModel().getColumn(2).setCellRenderer(alinear);
        tablaInventario.getColumnModel().getColumn(3).setMinWidth(120);
        tablaInventario.getColumnModel().getColumn(3).setMaxWidth(120);
        tablaInventario.getColumnModel().getColumn(3).setCellRenderer(alinear);
        tablaInventario.getColumnModel().getColumn(4).setMinWidth(60);
        tablaInventario.getColumnModel().getColumn(4).setMaxWidth(60);
        tablaInventario.getColumnModel().getColumn(4).setCellRenderer(alinear);
        tablaInventario.getColumnModel().getColumn(5).setCellRenderer(alinear);
        tablaInventario.setRowHeight(17);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barraBusqueda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel rowsCountLabel;
    private javax.swing.JPanel searchBar;
    private javax.swing.JTable tablaInventario;
    // End of variables declaration//GEN-END:variables

    private void rellenarTabla() {

        /**
         * Verificamos si ya tiene un valor, de lo contrario se le asigna. En
         * caso de que ya tenga un valor, se omite para ahorrar memoria
         */
        model = new DefaultTableModel();
        alinear = new DefaultTableCellRenderer();
        alinear.setHorizontalAlignment(SwingConstants.CENTER);
        model.addColumn("Id");
        model.addColumn("Nombre");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Cantidad");
        model.addColumn("Precio");
        datos = new String[6];
        tablaInventario.setModel(model);

        /**
         * Alinear las columnas
         */
        alinearColumnas();

        try {

            con = test.getConnection();
            pps = con.prepareStatement("SELECT * FROM inventario");
            rs = pps.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString("id_producto");
                datos[1] = rs.getString("nombre_producto");
                datos[2] = rs.getString("marca");
                datos[3] = rs.getString("modelo");
                datos[4] = rs.getString("cantidad");
                datos[5] = rs.getString("precio_venta");
                model.addRow(datos);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            test.close(con);
            test.close(pps);
            test.close(rs);
        }
    }

    /*
    Define el texto del conteo de filas
     */
    private void fillCountRowLabel() {
        rowsCountLabel.setText("Número de Resultados: " + conf.numberRows(tablaInventario));
    }

    /*
    Inicia todos los componentes del panel
     */
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
        rellenarTabla();
        //Selecciona el número de filas que tiene la tabla de inventario.
        fillCountRowLabel();
        sear = new Search(tablaInventario);
    }
}
