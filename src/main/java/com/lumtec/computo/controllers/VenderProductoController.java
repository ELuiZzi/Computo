package com.lumtec.computo.controllers;

import com.lumtec.computo.infra.Go;
import com.lumtec.computo.infra.Tiempo;
import com.lumtec.computo.infra.dao.*;
import com.lumtec.computo.infra.model.Carrito;
import com.lumtec.computo.infra.model.Producto;
import com.lumtec.computo.infra.model.Venta;
import com.lumtec.computo.paneles.FinanzasPanel;
import com.lumtec.computo.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;

public class VenderProductoController {
    private ProductoDAO productoDAO;
    private VentaDAO ventaDAO;

    private final FaltantesController faltantesController;

    private FaltantesDAO faltantesDAO;
    private final Carrito carrito;


    private DefaultTableCellRenderer alinear;
    private DefaultTableModel modelo;
    private final JTextField cantidadBox;
    private final JTable listaTabla;
    private final JTextField idBox;
    private final JTextField modeloBox;
    private final JTextField precioBox;
    private final JLabel precioTotal;

    public VenderProductoController(JTextField cantidadBox, JTable listaTabla, JTextField idBox, JTextField modeloBox, JTextField precioBox, JLabel precioTotal) {
        this.cantidadBox = cantidadBox;

        this.listaTabla = listaTabla;
        this.idBox = idBox;
        this.modeloBox = modeloBox;
        this.precioBox = precioBox;
        this.precioTotal = precioTotal;
        carrito = new Carrito();
        faltantesController = new FaltantesController();
    }


    private void venderProducto(Producto producto, Integer cantidad) {

        EntityManager em = JPAUtils.getEntityManger();

        ventaDAO = new VentaDAOJDBC(em);


        Venta venta = new Venta();

        venta.setProducto(producto);
        venta.setCantidad(cantidad);
        venta.setMes(Tiempo.getMes());
        venta.setAño(Tiempo.getAño());
        venta.setPrecioVenta(producto.getPrecioVenta());
        venta.setGanancia(producto.getGanancia());
        venta.setReinversion(producto.getReinversion());

        em.getTransaction().begin();

        ventaDAO.vender(venta);

        em.getTransaction().commit();


    }

    public void venderListaProductos() {
        EntityManager em = JPAUtils.getEntityManger();
        productoDAO = new ProductoDAOJDBC(em);
        faltantesDAO = new FaltantesDAOJDBC(em);
        em.getTransaction().begin();
        for (String[] strings : Carrito.carrito) {
            String nombre = strings[0];
            Integer cantidad = Integer.parseInt(strings[1]);
            Producto producto = productoDAO.getProductoPorNombre(nombre);
            venderProducto(producto, cantidad);
            producto.setCantidad(producto.getCantidad() - cantidad);
            productoDAO.actualizarProducto(producto);
            faltantesController.agregarFaltante(cantidad, producto);
            JOptionPane.showMessageDialog(null, nombre + " vendido exitosamente.");
        }
        em.getTransaction().commit();
        em.close();
        carrito.vaciarCarrito(this.modelo, this.precioTotal);
        Go.to(new FinanzasPanel());
    }

    public void modeloTabla() {

        modelo = new DefaultTableModel();
        alinear = new DefaultTableCellRenderer();
        alinear.setHorizontalAlignment(SwingConstants.CENTER);
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Total");

        listaTabla.setModel(modelo);

        listaTabla.getColumnModel().getColumn(1).setMaxWidth(70);
        listaTabla.getColumnModel().getColumn(2).setMaxWidth(70);
        listaTabla.getColumnModel().getColumn(2).setCellRenderer(alinear);
        listaTabla.setRowHeight(18);
    }

    public void cargarProducto() {
        String nombre = idBox.getText();
        EntityManager em = JPAUtils.getEntityManger();

        productoDAO = new ProductoDAOJDBC(em);
        Producto producto = productoDAO.productoVentas(nombre);

        modeloBox.setText(producto.getModelo());
        precioBox.setText(String.valueOf(producto.getPrecioVenta()));


        cantidadBox.requestFocus();
    }

    public void agregarProductoACarrito() {
        String[] elementos = new String[3];

        elementos[0] = idBox.getText();
        elementos[1] = cantidadBox.getText();
        elementos[2] = String.valueOf(new BigDecimal(precioBox.getText()).multiply(new BigDecimal(cantidadBox.getText())));

        Carrito.añadirProducto(elementos);

        modelo.addRow(elementos);

    }

    public void cargarListaCarrito() {

        carrito.cargarCarrito(this.modelo);
    }


    public void limpiarCajas() {


        idBox.setText(null);

        modeloBox.setText(null);
        precioBox.setText(null);
        cantidadBox.setText("1");
    }
}
