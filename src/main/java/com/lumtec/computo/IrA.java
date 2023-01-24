package com.lumtec.computo;

import com.lumtec.computo.Home.Home;
import com.lumtec.computo.Paneles.*;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class IrA {

    Home home;
    static JPanel mesa, background, p;

    public IrA(JPanel mesa, JPanel background) {
        home = new Home("");
        IrA.mesa = mesa;
        IrA.background = background;
    }

    public IrA() {
        home = new Home("");
    }

    public void agregarProducto() {
        p = new AgregarProductoPanel();
        agregarPanel(p);
    }

    public void home() {

        p = home.contenidoPanel;
        agregarPanel(p);
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

    public void finanzasLumtec() {

    }
    goTo go = new goTo();

    private void agregarPanel(JPanel panel) {
        System.out.println("1");
        go.vaciarPanel();
        System.out.println("2");
        IrA.mesa.add(panel, new AbsoluteConstraints(0, 0, 860, 410));
        System.out.println("3");
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
