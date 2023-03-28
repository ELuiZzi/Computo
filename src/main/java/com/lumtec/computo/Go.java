package com.lumtec.computo;

import com.lumtec.computo.Home.Home;
import com.lumtec.computo.Paneles.*;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class Go {

    //Se crea este home, para el método de add,
    Home home;
    static JPanel p;

    //Lo primero es crear el método que va a borrar el contenido que actualmente se muestra en la mesa de trabajo
    public static void vaciarPanel() {
        //Se remueve el panel actual
        Home.contenidoPanel.removeAll();
        Home.background.revalidate();
        Home.background.repaint();
    }


    public static void to(JPanel panel) {
        //Eliminar contenido Actual
        vaciarPanel();
        //Agregar nuevo contenido
        Home.contenidoPanel.add(panel, new AbsoluteConstraints(0, 0, 860, 410));
        Home.background.revalidate();
        Home.background.repaint();
    }

    //Ventana para shortcuts
    public void editarProductoSelec(int id) {
        p = new EditarPanel(id);
        to(p);
    }

    public void venderProductoSelec(int id) {
        p = new VenderPanel(id);
        to(p);
    }
}
