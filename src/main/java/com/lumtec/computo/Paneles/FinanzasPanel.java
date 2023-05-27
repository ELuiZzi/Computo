package com.lumtec.computo.Paneles;

import ConexionBD.Conexion;
import com.lumtec.computo.ClipBoar;
import com.lumtec.computo.Colors;
import com.lumtec.computo.Inventario.InventarioDAO;
import com.lumtec.computo.Inventario.InventarioDAOJDBC;
import com.lumtec.computo.Tiempo;
import com.lumtec.computo.Vender.VentaDAO;
import com.lumtec.computo.Vender.VentaDAOJDBC;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class FinanzasPanel extends javax.swing.JPanel {

    InventarioDAO inv = new InventarioDAOJDBC(); //Esta variable carga el metodo de inversiÃ³n
    DefaultTableModel modelVentas, modelVentaMensual;
    DefaultComboBoxModel modelBox;
    VentaDAO ventasDAO;
    String añoActual = Tiempo.getAño();
    String mesActual = Tiempo.getMes();
    List<String> listadoFinanzas;

    public FinanzasPanel() {
        initComponents();
        initOwnComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Panel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaVentasMensual = new javax.swing.JTable();
        Banner = new javax.swing.JPanel();
        mesComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        reinversionLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        gananciaLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        seleccionarBoton = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        totalVendidoStatic = new javax.swing.JLabel();
        totalVendido_Label = new javax.swing.JLabel();
        año_ComboBox = new javax.swing.JComboBox<>();
        FinanzasPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        inverLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ventasLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        gananLabel = new javax.swing.JLabel();
        copyButton = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(860, 410));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(204, 0, 204));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(860, 410));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(860, 410));

        Panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tablaVentasMensual.setBackground(new java.awt.Color(204, 204, 204));
        tablaVentasMensual.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tablaVentasMensual.setForeground(new java.awt.Color(255, 255, 255));
        tablaVentasMensual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaVentasMensual);

        Panel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 60, 810, 300));

        Banner.setBackground(new java.awt.Color(235, 235, 235));
        Banner.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mesComboBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        mesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        mesComboBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 1, 1, 1));
        mesComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mesComboBoxItemStateChanged(evt);
            }
        });
        Banner.add(mesComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 7, 90, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Reinversión:");
        Banner.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 7, -1, 30));

        reinversionLabel.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        reinversionLabel.setForeground(new java.awt.Color(255, 255, 255));
        reinversionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reinversionLabel.setText("----------");
        Banner.add(reinversionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 7, 80, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ganancia:");
        Banner.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 7, -1, 30));

        gananciaLabel.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        gananciaLabel.setForeground(new java.awt.Color(255, 255, 255));
        gananciaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gananciaLabel.setText("----------");
        Banner.add(gananciaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 7, 80, 30));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Banner.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 7, 10, 30));

        seleccionarBoton.setBackground(new java.awt.Color(215, 215, 215));
        seleccionarBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        seleccionarBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarBotonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                seleccionarBotonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                seleccionarBotonMouseExited(evt);
            }
        });
        seleccionarBoton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Seleccionar");
        seleccionarBoton.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 12));

        Banner.add(seleccionarBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 8, 90, 30));

        totalVendidoStatic.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        totalVendidoStatic.setForeground(new java.awt.Color(255, 255, 255));
        totalVendidoStatic.setText("Total Vendido:");
        Banner.add(totalVendidoStatic, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 7, 110, 30));

        totalVendido_Label.setFont(new java.awt.Font("Arial", 3, 17)); // NOI18N
        totalVendido_Label.setForeground(new java.awt.Color(255, 255, 255));
        totalVendido_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalVendido_Label.setText("----------");
        Banner.add(totalVendido_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 7, 90, 30));

        año_ComboBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        año_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2022", "2021" }));
        Banner.add(año_ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 7, 70, 30));

        Panel2.add(Banner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 45));

        jTabbedPane1.addTab("Mensuales", Panel2);

        FinanzasPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Inversión:");
        FinanzasPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        inverLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        inverLabel.setForeground(new java.awt.Color(255, 255, 255));
        inverLabel.setText("$ 2500");
        FinanzasPanel.add(inverLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 90, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Max. Ventas:");
        FinanzasPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        ventasLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ventasLabel.setForeground(new java.awt.Color(255, 255, 255));
        ventasLabel.setText("$ 5000");
        FinanzasPanel.add(ventasLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 90, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ganancias Est:");
        FinanzasPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 90, -1));

        gananLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        gananLabel.setForeground(new java.awt.Color(255, 255, 255));
        gananLabel.setText("$ 2500");
        FinanzasPanel.add(gananLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 90, -1));

        copyButton.setBackground(new java.awt.Color(70, 73, 75));
        copyButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        copyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                copyButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                copyButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                copyButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                copyButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                copyButtonMouseReleased(evt);
            }
        });
        copyButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel7.setText("C");
        copyButton.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 6, -1, -1));

        FinanzasPanel.add(copyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 30, 30));

        jTabbedPane1.addTab("Finanzas", FinanzasPanel);

        jPanel1.setBackground(new java.awt.Color(246, 246, 246));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tablaVentas.setForeground(new java.awt.Color(255, 255, 255));
        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaVentas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 780, 320));

        jTabbedPane1.addTab("Ventas", jPanel1);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 410));
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionarBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarBotonMouseClicked
        if (seleccionarBoton.isEnabled()) {
            String mes = (String) mesComboBox.getSelectedItem();
            String año = (String) año_ComboBox.getSelectedItem();

            rellenarTablaVentasMensual(mes, año);
            completarEtiquetas(mes, año);

            seleccionarBoton.requestFocus();
            //seleccionarBoton.setEnabled(false);
        }
    }//GEN-LAST:event_seleccionarBotonMouseClicked


    private void seleccionarBotonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarBotonMouseEntered
        seleccionarBoton.setBackground(Colors.buttonPressed);
    }//GEN-LAST:event_seleccionarBotonMouseEntered

    private void seleccionarBotonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarBotonMouseExited
        seleccionarBoton.setBackground(Colors.button);
    }//GEN-LAST:event_seleccionarBotonMouseExited

    private void copyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyButtonMouseClicked
        String finanzas = "Ventas del mes: " + Tiempo.getMes() + " " + Tiempo.getAño() + '\n' + '\n'
                + "InversiÃ³n: " + inverLabel.getText() + '\n'
                + "Max. Ventas: " + ventasLabel.getText() + '\n'
                + "Ganancias Est: " + gananLabel.getText();

        ClipBoar.copy(finanzas);
    }//GEN-LAST:event_copyButtonMouseClicked

    private void copyButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyButtonMouseEntered
        copyButton.setBackground(Colors.buttonPressed);
    }//GEN-LAST:event_copyButtonMouseEntered

    private void copyButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyButtonMouseExited
        copyButton.setBackground(Colors.button);
    }//GEN-LAST:event_copyButtonMouseExited

    private void copyButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyButtonMousePressed
        copyButton.setBackground(Colors.button);
    }//GEN-LAST:event_copyButtonMousePressed

    private void copyButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyButtonMouseReleased
        copyButton.setBackground(Colors.buttonPressed);
    }//GEN-LAST:event_copyButtonMouseReleased

    private void año_ComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {
        resetTabla();
    }

    private void año_ComboBoxFocusGained(java.awt.event.FocusEvent evt) {

    }

    private void mesComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mesComboBoxItemStateChanged
        resetTabla();
    }//GEN-LAST:event_mesComboBoxItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Banner;
    private javax.swing.JPanel FinanzasPanel;
    private javax.swing.JPanel Panel2;
    private javax.swing.JComboBox<String> año_ComboBox;
    private javax.swing.JPanel copyButton;
    private javax.swing.JLabel gananLabel;
    private javax.swing.JLabel gananciaLabel;
    private javax.swing.JLabel inverLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> mesComboBox;
    private javax.swing.JLabel reinversionLabel;
    private javax.swing.JPanel seleccionarBoton;
    private javax.swing.JTable tablaVentas;
    private javax.swing.JTable tablaVentasMensual;
    private javax.swing.JLabel totalVendidoStatic;
    private javax.swing.JLabel totalVendido_Label;
    private javax.swing.JLabel ventasLabel;
    // End of variables declaration//GEN-END:variables

    private void rellenarTablaVentas() {
        modelVentas = new DefaultTableModel();

        ventasDAO = new VentaDAOJDBC();

        modelVentas.addColumn("Producto");
        modelVentas.addColumn("Modelo");
        modelVentas.addColumn("Fecha de Venta");
        modelVentas.addColumn("Venta");

        tablaVentas.setModel(modelVentas);

        var listaVentas = ventasDAO.listarVentas();

        listaVentas.forEach(venta -> modelVentas.addRow(
                new Object[]{
                    venta.getNombre(),
                    venta.getModelo(),
                    venta.getFecha(),
                    venta.getTotalVenta()
                }
        )
        );

    }

    private void rellenarTablaVentasMensual(String mes, String año) {
        modelVentaMensual = new DefaultTableModel();

        ventasDAO = new VentaDAOJDBC();

        modelVentaMensual.addColumn("Producto");
        modelVentaMensual.addColumn("Fecha de Venta");
        modelVentaMensual.addColumn("Venta");
        modelVentaMensual.addColumn("Reinversión");
        modelVentaMensual.addColumn("Ganancia");

        tablaVentasMensual.setModel(modelVentaMensual);

        var listaVentas = ventasDAO.listarVentasMensuales(mes, año);

        listaVentas.forEach(venta -> modelVentaMensual.addRow(
                new Object[]{
                    venta.getNombre(),
                    venta.getFecha(),
                    venta.getTotalVenta(),
                    venta.getReinverson(),
                    venta.getGanancia()
                }
        )
        );

    }

    private void modelMesesComboBox() {
        modelBox = new DefaultComboBoxModel();
        modelBox.addElement("Enero");
        modelBox.addElement("Febrero");
        modelBox.addElement("Marzo");
        modelBox.addElement("Abril");
        modelBox.addElement("Mayo");
        modelBox.addElement("Junio");
        modelBox.addElement("Julio");
        modelBox.addElement("Agosto");
        modelBox.addElement("Septiembre");
        modelBox.addElement("Octubre");
        modelBox.addElement("Noviembre");
        modelBox.addElement("Diciembre");
        mesComboBox.setModel(modelBox);
    }

    private void finanzasMesActual() {
        rellenarTablaVentasMensual(mesActual, añoActual);
        //completarEtiquetas(mesActual, añoActual);
        mesComboBox.setSelectedItem(mesActual);
    }

    private void resetTabla() {
        try {
            while (0 <= modelVentaMensual.getRowCount()) {
                modelVentaMensual.removeRow(0);
            }
        } catch (java.lang.ArrayIndexOutOfBoundsException ex) {

        }
        seleccionarBoton.setEnabled(true);
        totalVendido_Label.setText("----------");
        reinversionLabel.setText("----------");
        gananciaLabel.setText("----------");
        seleccionarBoton.setEnabled(true);
    }

    private void initOwnComponents() {
        //Colorizacion
        jTabbedPane1.setBackground(Colors.panel);
        Panel2.setBackground(Colors.panel);
        jPanel1.setBackground(Colors.panel);
        FinanzasPanel.setBackground(Colors.panel);
        Banner.setBackground(Colors.banner2);

        tablaVentas.setBackground(Colors.textBox);
        tablaVentasMensual.setBackground(Colors.textBox);

        copyButton.setBackground(Colors.button);
        jScrollPane1.setBackground(Colors.panel);
        jScrollPane1.getViewport().setBackground(Colors.panel);
        jScrollPane2.setBackground(Colors.panel);
        jScrollPane2.getViewport().setBackground(Colors.panel);
        seleccionarBoton.setBackground(Colors.button);

        tablaVentasMensual.setSelectionBackground(Colors.textBoxActivated);
        tablaVentas.setSelectionBackground(Colors.textBoxActivated);

        //Tablas y MÃ©todos
        rellenarTablaVentas();

        modelMesesComboBox();
        finanzasMesActual();

        //Label de inversion
        float inver = inv.getInversion();
        float maxVentas = inv.getMaxVentas();

        float ganan = maxVentas - inver;

        inverLabel.setText("$ " + inver);
        ventasLabel.setText("$ " + maxVentas);
        gananLabel.setText("$ " + ganan);

        rellenarTablaVentasMensual(Tiempo.getMes(), Tiempo.getAño());
        completarEtiquetas(Tiempo.getMes(), Tiempo.getAño());
    }

    private void completarEtiquetas(String mes, String año) {

        VentaDAO ventasDAO = new VentaDAOJDBC();

        this.listadoFinanzas = ventasDAO.listadoFinanzas(mes, año);

        totalVendido_Label.setText("$ " + this.listadoFinanzas.get(0));
        gananciaLabel.setText("$ " + this.listadoFinanzas.get(1));
        reinversionLabel.setText("$ " + this.listadoFinanzas.get(2));
    }

}
