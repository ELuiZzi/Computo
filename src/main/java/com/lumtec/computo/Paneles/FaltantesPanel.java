package com.lumtec.computo.Paneles;

import com.lumtec.computo.Colors;
import com.lumtec.computo.Faltante;
import com.lumtec.computo.Faltantes.FaltantesDAO;
import com.lumtec.computo.Faltantes.FaltantesDAOJDBC;
import com.lumtec.computo.HerramientasTabla;
import com.lumtec.computo.Inventario.InventarioDAO;
import com.lumtec.computo.Inventario.InventarioDAOJDBC;
import ConexionBD.Conexion;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FaltantesPanel extends javax.swing.JPanel {

    FaltantesDAO fal = new FaltantesDAOJDBC();
    InventarioDAO inve = new InventarioDAOJDBC();
    HerramientasTabla conf;
    static List lista = new ArrayList();
    DefaultTableModel model;
    DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
    Connection con;
    PreparedStatement pps;
    ResultSet rs;
    String[] datos;
    Faltante falt;

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
                con = Conexion.getConnection();
                conf.eliminarId("faltantes", tablaFaltantes, con, pps);
                rellenarTabla();
                vaciarTabla(tablaProvedores);
                rellenarTablaProvedores();
                Conexion.close(con);

            }
        } else if (evt.getKeyCode() == KeyEvent.VK_S) {
            //Pregunta si queremos eliminar el producto, y ademas ocupa el nombre del producto según la columa de nombre y la fila seleccionada
            int add = JOptionPane.showConfirmDialog(null, "¿Quieres surtir " + tablaFaltantes.getValueAt(tablaFaltantes.getSelectedRow(), 1).toString() + "?", "Surtir Producto", JOptionPane.YES_NO_OPTION
            );
            if (add == 0) {
                surtir();
            }

        }
    }//GEN-LAST:event_tablaFaltantesKeyPressed


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

        datos = new String[7];
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);

        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Producto");
        model.addColumn("Provedor");
        model.addColumn("Modelo");
        model.addColumn("Faltantes");
        model.addColumn("Precio Compra");
        model.addColumn("Total");

        tablaFaltantes.setModel(model);
        tablaFaltantes.setFont(Arial);

        tablaFaltantes.getColumnModel().getColumn(0).setMaxWidth(25);
        tablaFaltantes.getColumnModel().getColumn(0).setMinWidth(25);
        tablaFaltantes.getColumnModel().getColumn(0).setResizable(false);
        tablaFaltantes.getColumnModel().getColumn(0).setCellRenderer(Alinear);
        tablaFaltantes.getColumnModel().getColumn(1).setMaxWidth(250);
        tablaFaltantes.getColumnModel().getColumn(1).setMinWidth(250);
        tablaFaltantes.getColumnModel().getColumn(1).setResizable(false);
        tablaFaltantes.getColumnModel().getColumn(1).setCellRenderer(Alinear);
        tablaFaltantes.getColumnModel().getColumn(2).setMaxWidth(60);
        tablaFaltantes.getColumnModel().getColumn(2).setMinWidth(60);
        tablaFaltantes.getColumnModel().getColumn(2).setResizable(false);
        tablaFaltantes.getColumnModel().getColumn(2).setCellRenderer(Alinear);
        tablaFaltantes.getColumnModel().getColumn(3).setMaxWidth(110);
        tablaFaltantes.getColumnModel().getColumn(3).setMinWidth(110);
        tablaFaltantes.getColumnModel().getColumn(3).setResizable(false);
        tablaFaltantes.getColumnModel().getColumn(3).setCellRenderer(Alinear);
        tablaFaltantes.getColumnModel().getColumn(4).setResizable(false);
        tablaFaltantes.getColumnModel().getColumn(4).setCellRenderer(Alinear);
        tablaFaltantes.getColumnModel().getColumn(5).setMaxWidth(70);
        tablaFaltantes.getColumnModel().getColumn(5).setMinWidth(70);
        tablaFaltantes.getColumnModel().getColumn(5).setResizable(false);
        tablaFaltantes.getColumnModel().getColumn(5).setCellRenderer(Alinear);
        tablaFaltantes.getColumnModel().getColumn(6).setCellRenderer(Alinear);
        tablaFaltantes.setRowHeight(17);

        try {
            con = Conexion.getConnection();
            pps = con.prepareStatement("SELECT * FROM faltantes");
            rs = pps.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString("id_producto");
                datos[1] = rs.getString("nombre_producto");
                datos[2] = rs.getString("provedor");
                datos[3] = rs.getString("modelo");
                datos[4] = rs.getString("cantidad");
                datos[5] = rs.getString("precio_compra");
                datos[6] = rs.getString("precio_total");

                model.addRow(datos);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pps);
            Conexion.close(rs);
        }

    }

    private void rellenarTablaProvedores() {
        model = new DefaultTableModel();
        datos = new String[2];
        model.addColumn("Provedor");
        model.addColumn("Costo");
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        tablaProvedores.setModel(model);
        tablaFaltantes.setFont(new java.awt.Font("Arial", 0, 12));
        tablaProvedores.getColumnModel().getColumn(0).setCellRenderer(Alinear);
        tablaProvedores.getColumnModel().getColumn(1).setCellRenderer(Alinear);

        try {
            //Conexion abierta en método porque es temporal
            con = Conexion.getConnection();
            pps = con.prepareStatement("SELECT * FROM faltantes");
            rs = pps.executeQuery();

            while (rs.next()) {
                String provedor = rs.getString("provedor");

                if (provedor == null) {

                } else {
                    lista.add(provedor);
                }

            }
            lista = (List) lista.stream().distinct().collect(Collectors.toList());

            for (int i = 0; i < lista.size(); i++) {
                try {
                    String prove = lista.get(i).toString();
                    datos[0] = prove;
                    dineroTotal(datos, con, pps, rs);
                    model.addRow(datos);

                } catch (java.lang.NullPointerException ex) {

                }
            }

        } catch (SQLException ex) {

        } finally {
            Conexion.close(pps);
            Conexion.close(rs);
        }

    }

    private void dineroTotal(String[] datos, Connection con, PreparedStatement pps, ResultSet rs) {
        float dinero_total = 0;

        try {
            pps = con.prepareStatement("SELECT precio_total FROM faltantes WHERE provedor = '" + datos[0] + "'");
            rs = pps.executeQuery();
            while (rs.next()) {
                dinero_total = (float) (dinero_total + Math.ceil(rs.getFloat("precio_total")));
            }
            datos[1] = Float.toString(dinero_total);

            System.out.println(datos[0] + " " + dinero_total);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        try {
            dinero_total = 0;
            pps = con.prepareStatement("SELECT precio_total FROM faltantes");
            rs = pps.executeQuery();
            while (rs.next()) {
                dinero_total = (float) (dinero_total + Math.ceil(rs.getFloat("precio_total")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        dineroTotal_box.setText("$ " + dinero_total);
    }

    /*
    Método creado para agregar los nuevos productos al Inventario y a su vez restarlos de Faltantes
     */
    private void surtir() {
        /*
         Lo Primero es agregar la cantidad al Inventario
         */

        //Seleccionamos el ID que vamos a manejar, debe de ser el mismo en la tabla de Inventario como en la de Faltantes.
        //El ID se saca de la primer columna de la tabla y de la fila que esté seleccionada
        int id = Integer.parseInt(tablaFaltantes.getValueAt(tablaFaltantes.getSelectedRow(), 0).toString());

        //La cantidad nueva se encerrar en un try-catch, en caso de que se escriba un dato erroeno, o se cancele la acción
        int cantidadNueva = 0;

        try {
            cantidadNueva = Integer.parseInt(JOptionPane.showInputDialog("Cantidad"));
        } catch (NumberFormatException ex) {
            System.out.println("Cancelado/Dato no válido como cantidad");
        }

        //La cantidad que se va a agregar se saca sumando la cantidad actual mas la nueva cantidad
        int cantidadTotalInve = inve.cantidadActual(id) + cantidadNueva;

        //Antes de Surtir en Inventario, vamos a sacar la Cantidad total de Faltantes, que se logra restando a la cantidad actual la nueva cantidad
        int cantidadTotalFalt = fal.getCantidad(id) - cantidadNueva;

        //Haremos un try-catch para iniziar los métodos con la misma conexión,en caso de que haya un error, haremos Rollback. 
        Connection cone = null;
        cone = Conexion.getConnection();
        inve = new InventarioDAOJDBC(cone);
        fal = new FaltantesDAOJDBC(cone);
        //Actualizamos Inventario, sumando los nuevos productos
        inve.surtir(id, cantidadTotalInve);
        //Actualizamos Faltantes, restando los nuevos productos
        fal.editarCantidad(id, cantidadTotalFalt);
        //Una vez actualizadas las BD, y aprovechando la conexion, verificaremos si la cantidad actual del producto en Faltantes es menor a 0, en caso de que lo sea, se tendrá que eliminar
        if (fal.getCantidad(id) <= 0) {
            fal.eliminarFaltante(id);
        }
        //Finalmente rellenamos las tablas con los nuevos cambios
        rellenarTabla();
        vaciarTabla(tablaProvedores);
        rellenarTablaProvedores();
        Conexion.close(cone);

    }

    private void vaciarTabla(JTable tabla) {
        tabla.setModel(new DefaultTableModel());
    }

    private void rellenarTablas() {

        con = Conexion.getConnection();
        rellenarTabla();
        rellenarTablaProvedores();
        Conexion.close(con);

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
        fal.calcularGastoTotal();
        rellenarTablas();
    }
}
