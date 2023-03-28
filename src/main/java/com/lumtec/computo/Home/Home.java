package com.lumtec.computo.Home;

import com.lumtec.computo.Colors;
import com.lumtec.computo.Imagenes.Images;
import com.lumtec.computo.Paneles.ComputoPanel;
import com.lumtec.computo.Producto;
import com.lumtec.computo.Go;
import ConexionBD.Conexion;
import com.lumtec.computo.Paneles.AgregarProductoPanel;
import com.lumtec.computo.Paneles.EditarPanel;
import com.lumtec.computo.Paneles.FaltantesPanel;
import com.lumtec.computo.Paneles.FinanzasPanel;
import com.lumtec.computo.Paneles.InventarioPanel;
import com.lumtec.computo.Paneles.VenderPanel;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class Home extends javax.swing.JFrame {

    JPanel menuIcon, minIcon;
    Producto prod;
    Images img = new Images();
    AbsoluteLayout layout = new AbsoluteLayout();

    //Creacion de goto, nos permite cambiar el contenido
    //Variables que almacenan las coordenadas originales al mover la ventana
    int x, y;

    public Home() {

        //Creamos un producto para poder reiniciarlo, de esta forma nos aseguramos no conservar información del agun producto utilizado
        prod = new Producto();
        prod.reset();

        //Accedemos a  la base de datos, para precargar
        Connection con = null;
        con = Conexion.getConnection();
        Conexion.close(con);

        initComponents();
        initOwnComponents();

        setTitulo("Bienvenido Luis");
        background.requestFocus();
        minBoton();

    }

    public Home(String h) {

    }

    private void minBoton() {
        minIcon = new JPanel();
        minIcon.setLayout(layout);

        minIcon.add(Images.getMinimizeIcon(), new AbsoluteConstraints(0, 0));
        minIcon.setBackground(Colors.menuBackground);
        minIcon.setVisible(true);
        minIcon.setCursor(new Cursor(12));
        minIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                minIcon.setBackground(Colors.menuButtonPressed);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                minimizarMenu();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                minIcon.setBackground(Colors.menuBackground);
            }
        });
        Menu.add(minIcon, new AbsoluteConstraints(180, 0, 30, 30));
        Menu.revalidate();
        Menu.repaint();
    }

    private void setTitulo(String titulo) {
        tituloVentana.setText(titulo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        computoButton = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lumtecButton = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        configButton = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        menuTitulo = new javax.swing.JLabel();
        cerrarButton = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Barra = new javax.swing.JPanel();
        tituloVentana = new javax.swing.JLabel();
        contenidoPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Computo");
        setUndecorated(true);
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(270, 211));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setBackground(new java.awt.Color(102, 102, 102));
        Menu.setMinimumSize(new java.awt.Dimension(210, 440));
        Menu.setPreferredSize(new java.awt.Dimension(210, 440));
        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        computoButton.setBackground(new java.awt.Color(204, 204, 204));
        computoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                computoButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                computoButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                computoButtonMouseExited(evt);
            }
        });
        computoButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Computo");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        computoButton.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 15, 200, 25));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        computoButton.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 10));

        Menu.add(computoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 210, 50));

        lumtecButton.setBackground(new java.awt.Color(204, 204, 204));
        lumtecButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lumtecButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lumtecButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lumtecButtonMouseExited(evt);
            }
        });
        lumtecButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Lumtec");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lumtecButton.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 15, 200, 25));

        Menu.add(lumtecButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 210, 50));

        configButton.setBackground(new java.awt.Color(204, 204, 204));
        configButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                configButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                configButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                configButtonMouseExited(evt);
            }
        });
        configButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Configuración");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        configButton.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 15, 200, 25));

        Menu.add(configButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 210, 50));

        menuTitulo.setFont(new java.awt.Font("DialogInput", 2, 18)); // NOI18N
        menuTitulo.setForeground(new java.awt.Color(255, 255, 255));
        menuTitulo.setText("Menú");
        menuTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuTituloMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuTituloMouseEntered(evt);
            }
        });
        Menu.add(menuTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, -2, 50, 30));

        cerrarButton.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        cerrarButton.setForeground(new java.awt.Color(255, 255, 255));
        cerrarButton.setText("Cerrar");
        cerrarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cerrarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarButtonMouseClicked(evt);
            }
        });
        Menu.add(cerrarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 50, 20));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("V. 1.0.15");
        Menu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 412, 50, -1));

        background.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 440));

        Barra.setBackground(new java.awt.Color(220, 220, 220));
        Barra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BarraMouseDragged(evt);
            }
        });
        Barra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BarraMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BarraMousePressed(evt);
            }
        });
        Barra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloVentana.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        tituloVentana.setForeground(new java.awt.Color(255, 255, 255));
        tituloVentana.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tituloVentana.setText("Título");
        tituloVentana.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 8));
        Barra.add(tituloVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 150, 30));

        background.add(Barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 830, 30));

        contenidoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        background.add(contenidoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 860, 410));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entradaMouse(JPanel actual) {
        actual.setBackground(Colors.buttonPressed);
        actual.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void salidaMouse(JPanel actual) {
        actual.setBackground(Colors.menuBackground);
    }

    private void menuIconMouseEntered(MouseEvent e) {
        menuIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menuIcon.setBackground(Colors.buttonPressed);
    }

    private void menuIconMouseClicked(MouseEvent e) {
        menuIcon.setVisible(false);
        Menu.setVisible(true);
    }

    private void menuIconMouseExited(MouseEvent e) {
        menuIcon.setBackground(Colors.banner1);
    }

    private void minimizarMenu() {
        menuIcon = new JPanel();
        menuIcon.setLayout(layout);

        menuIcon.setBackground(Colors.banner1);
        menuIcon.add(Images.getMenuIcon(), new AbsoluteConstraints(0, 0));

        menuIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                menuIconMouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                menuIconMouseExited(evt);
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                menuIconMouseClicked(evt);
            }

        });
        Menu.setVisible(false);
        background.add(menuIcon, new AbsoluteConstraints(0, 0, 30, 30));
        background.revalidate();
        background.repaint();
    }


    private void computoButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_computoButtonMouseEntered
        entradaMouse(computoButton);
    }//GEN-LAST:event_computoButtonMouseEntered

    private void computoButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_computoButtonMouseExited
        salidaMouse(computoButton);
    }//GEN-LAST:event_computoButtonMouseExited

    private void lumtecButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lumtecButtonMouseEntered
        entradaMouse(lumtecButton);
    }//GEN-LAST:event_lumtecButtonMouseEntered

    private void lumtecButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lumtecButtonMouseExited
        salidaMouse(lumtecButton);
    }//GEN-LAST:event_lumtecButtonMouseExited

    private void configButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configButtonMouseClicked
        minimizarMenu();
        setTitulo("Configuración");
    }//GEN-LAST:event_configButtonMouseClicked

    private void configButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configButtonMouseEntered
        entradaMouse(configButton);
    }//GEN-LAST:event_configButtonMouseEntered

    private void configButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configButtonMouseExited
        salidaMouse(configButton);

    }//GEN-LAST:event_configButtonMouseExited

    private void computoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_computoButtonMouseClicked
        prod.reset();
        minimizarMenu();
        Go.to(Home.computoPanel);
        llenarPanel("computo");
    }//GEN-LAST:event_computoButtonMouseClicked

    private void lumtecButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lumtecButtonMouseClicked
        minimizarMenu();
        setTitulo("LumTec");
    }//GEN-LAST:event_lumtecButtonMouseClicked

    private void menuTituloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuTituloMouseClicked
        Go.vaciarPanel();
        setTitulo("Bienvenido Luis");
    }//GEN-LAST:event_menuTituloMouseClicked

    private void menuTituloMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuTituloMouseEntered
        menuTitulo.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuTituloMouseEntered

    private void BarraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraMouseClicked
        minimizarMenu();
    }//GEN-LAST:event_BarraMouseClicked

    private void cerrarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_cerrarButtonMouseClicked

    private void BarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraMousePressed
        //Seleccionamos las coordenadas actuales
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_BarraMousePressed

    private void BarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraMouseDragged
        //Movemos la ventana a las nuevas coordenadas
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_BarraMouseDragged

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Barra;
    private javax.swing.JPanel Menu;
    public static javax.swing.JPanel background;
    private javax.swing.JLabel cerrarButton;
    private javax.swing.JPanel computoButton;
    private javax.swing.JPanel configButton;
    public static javax.swing.JPanel contenidoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel lumtecButton;
    private javax.swing.JLabel menuTitulo;
    private javax.swing.JLabel tituloVentana;
    // End of variables declaration//GEN-END:variables

    private void llenarPanel(String panel) {

        Component p = null;
        switch (panel) {
            case "computo":
                p = new ComputoPanel(contenidoPanel, background);
                setTitulo("Computo");

        }
        contenidoPanel.add(p, new AbsoluteConstraints(0, 0, 860, 410));
    }

    /*
    Este metodo carga colores, textos y objetos propios
     */
    private void initOwnComponents() {
        //Propiedades del frame
        this.setLocationRelativeTo(null);
        this.setIconImage(img.getLogo());
        this.setMaximumSize(new Dimension(860, 440));

        //Colorización
        Barra.setBackground(Colors.banner1);

        Menu.setBackground(Colors.menuBackground);
        computoButton.setBackground(Colors.menuBackground);
        lumtecButton.setBackground(Colors.menuBackground);
        configButton.setBackground(Colors.menuBackground);

        contenidoPanel.setBackground(Colors.panel);
    }

    //Cargar Todas las ventanas
    public static final JPanel computoPanel = new ComputoPanel();
    public static final JPanel agregarProdutcoPanel = new AgregarProductoPanel();
    public static final JPanel inventarioPanel = new InventarioPanel();
    public static final JPanel editarProdutcoPanel = new EditarPanel();
    public static final JPanel venderProdutcoPanel = new VenderPanel();
    public static final JPanel faltantesPanel = new FaltantesPanel();
    public static final JPanel finanzasPanel = new FinanzasPanel();

}
