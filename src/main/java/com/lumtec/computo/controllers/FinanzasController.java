package com.lumtec.computo.controllers;

import com.lumtec.computo.infra.Tiempo;
import com.lumtec.computo.infra.dao.VentaDAO;
import com.lumtec.computo.infra.dao.VentaDAOJDBC;
import com.lumtec.computo.infra.model.Venta;
import com.lumtec.computo.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.util.List;

public class FinanzasController {

    private VentaDAO ventaDAO;

    private final DefaultTableModel modelVentas, modelVentaMensual;
    private final JTable tablaVentas;
    private final JTable tablaVentasMensual;

    public FinanzasController(JTable tablaVentas, JTable tablaVentasMensual) {
        this.tablaVentas = tablaVentas;
        this.tablaVentasMensual = tablaVentasMensual;
        modelVentas = new DefaultTableModel();
        modelVentaMensual = new DefaultTableModel();
    }

    public void cargarVentas() {
        EntityManager em = JPAUtils.getEntityManger();

        ventaDAO = new VentaDAOJDBC(em);
        List<Venta> listaVentasMensual = ventaDAO.getVentasFinanzasMensual(Tiempo.getMes());
        List<Venta> listaVentas = ventaDAO.getVentasFinanzas();


        listaVentasMensual.forEach(venta -> modelVentaMensual.addRow(
                new Object[]{
                        venta.getProducto().getNombre(),
                        venta.getPrecioVenta().multiply(new BigDecimal(venta.getCantidad())),
                        venta.getReinversion().multiply(new BigDecimal(venta.getCantidad())),
                        venta.getGanancia().multiply(new BigDecimal(venta.getCantidad())),
                        venta.getFecha()

                }
        ));

        listaVentas.forEach(venta -> modelVentas.addRow(
                new Object[]{
                        venta.getProducto().getNombre(),
                        venta.getProducto().getModelo(),
                        venta.getFecha(),
                        venta.getProducto().getPrecioVenta().multiply(new BigDecimal(venta.getCantidad()))
                }
        ));

    }


    private void modeloTabla() {

        modelVentas.addColumn("Producto");
        modelVentas.addColumn("Modelo");
        modelVentas.addColumn("Fecha de Venta");
        modelVentas.addColumn("Venta");

        tablaVentas.setModel(modelVentas);

        modelVentaMensual.addColumn("Producto");
        modelVentaMensual.addColumn("Venta");
        modelVentaMensual.addColumn("Reinversión");
        modelVentaMensual.addColumn("Ganancia");
        modelVentaMensual.addColumn("Fecha de Venta");

        tablaVentasMensual.setModel(modelVentaMensual);
    }

    public void cargarTablas() {
        modeloTabla();

        cargarVentas();
    }


}
