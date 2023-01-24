package com.lumtec.computo;

import com.lumtec.computo.Home.Home;
import com.lumtec.computo.Paneles.*;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class goTo {

    //Se crea este home, para el método de add,
    Home home;
    static JPanel p;

    //Lo primero es crear el método que va a borrar el contenido que actualmente se muestra en la mesa de trabajo
    public void vaciarPanel() {
        //Se remueve el panel actual
        Home.contenidoPanel.removeAll();
        Home.background.revalidate();
        Home.background.repaint();
    }

    public void agregarProducto() {
        p = new AgregarProductoPanel();
        agregarPanel(p);
    }

    public void home() {
        vaciarPanel();
    }

    public void editarProducto() {
        p = new EditarPanel();
        agregarPanel(p);
    }

    public void inventario() {
        p = new InventarioPanel();
        agregarPanel(p);
    }

    public void faltantes() {
        p = new FaltantesPanel();
        agregarPanel(p);
    }

    public void vender() {
        p = new VenderPanel();
        agregarPanel(p);
    }

    public void agregarFaltante() {

    }

    public void finanzas() {
        p = new FinanzasPanel();
        agregarPanel(p);
    }

    public void computo() {
        p = new ComputoPanel();
        agregarPanel(p);
    }

    public void nuevoFaltante() {
        p = new NuevoFaltantePanel();
        agregarPanel(p);
    }

    private void agregarPanel(JPanel panel) {
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
        agregarPanel(p);
    }

    public void venderProductoSelec(int id) {
        p = new VenderPanel(id);
        agregarPanel(p);
    }
}
