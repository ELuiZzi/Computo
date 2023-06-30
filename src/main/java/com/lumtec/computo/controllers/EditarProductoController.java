package com.lumtec.computo.controllers;

import com.lumtec.computo.infra.Go;
import com.lumtec.computo.infra.dao.ProductoDAO;
import com.lumtec.computo.infra.dao.ProductoDAOJDBC;
import com.lumtec.computo.infra.dao.ProvedorDAO;
import com.lumtec.computo.infra.dao.ProvedorDAOJDBC;
import com.lumtec.computo.infra.dto.NuevoProductoDTO;
import com.lumtec.computo.infra.model.Producto;
import com.lumtec.computo.infra.model.Provedor;
import com.lumtec.computo.paneles.Home;
import com.lumtec.computo.paneles.InventarioPanel;
import com.lumtec.computo.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.math.BigDecimal;

public class EditarProductoController {

    private final ProductoDAO productoDAO;
    private final ProvedorDAO provedorDAO;
    private final JTextField busquedaBox;
    private final JTextField nombreProductoBox;
    private final JTextField marcaBox;
    private final JTextField modeloBox;
    private final JTextField cantidadBox;
    private final JTextField precioCompraBox;
    private final JTextField precioVentaBox;
    private final JTextField gananciaBox;
    private final JTextField reinversionBox;
    private final JTextField porcentajeGananciaBox;
    private final JTextField porcentajeReinversionBox;
    private final JSlider sliderPorcentaje;
    private final JTextArea descripcionBox;
    private final JComboBox provedorBox;
    private final JTextField garantiaBox;
    private EntityManager em;
    private Producto producto;

    public EditarProductoController(JTextField busquedaBox, JTextField nombreProductoBox, JTextField marcaBox, JTextField modeloBox, JTextField cantidadBox, JComboBox provedorBox, JTextArea descripcionBox, JTextField precioCompraBox, JTextField precioVentaBox, JTextField gananciaBox, JTextField reinversionBox, JTextField porcentajeGananciaBox, JTextField porcentajeReinversionBox, JSlider sliderPorcentaje, JTextField garantiaBox) {
        this.busquedaBox = busquedaBox;

        this.nombreProductoBox = nombreProductoBox;
        this.marcaBox = marcaBox;
        this.modeloBox = modeloBox;
        this.cantidadBox = cantidadBox;
        this.precioCompraBox = precioCompraBox;
        this.precioVentaBox = precioVentaBox;
        this.gananciaBox = gananciaBox;
        this.reinversionBox = reinversionBox;
        this.porcentajeGananciaBox = porcentajeGananciaBox;
        this.porcentajeReinversionBox = porcentajeReinversionBox;
        this.sliderPorcentaje = sliderPorcentaje;
        this.descripcionBox = descripcionBox;
        this.provedorBox = provedorBox;
        this.garantiaBox = garantiaBox;

        em = JPAUtils.getEntityManger();

        productoDAO = new ProductoDAOJDBC(em);
        provedorDAO = new ProvedorDAOJDBC(em);
    }

    public void cargarProducto(String nombre) {

        ProductoDAO productoDAO = new ProductoDAOJDBC(JPAUtils.getEntityManger());


            producto = productoDAO.getProductoPorNombre(nombre);


        llenarCajas(producto.getId().toString(), producto.getNombre(), producto.getMarca(), producto.getModelo(), producto.getCantidad().toString(), producto.getPrecioCompra().toString(), producto.getPrecioVenta().toString(), producto.getGanancia().toString(), producto.getReinversion().toString(), null, null, producto.getGanancia().add(producto.getReinversion()), producto.getDescripcion(), producto.getGarantia());

    }

    private void llenarCajas(String id, String nombre, String marca, String modelo, String cantidad, String precioCompra, String precioVenta, String cantidadGanancia, String cantidadReinversion, String porcentajeGanancia, String porcentajeReinversion, BigDecimal porcentajeTotal, String descripcion, String garantia) {
        busquedaBox.setText(id);
        nombreProductoBox.setText(nombre);
        marcaBox.setText(marca);
        modeloBox.setText(modelo);
        cantidadBox.setText(cantidad);
        precioCompraBox.setText(precioCompra);
        precioVentaBox.setText(precioVenta);
        gananciaBox.setText(cantidadGanancia);
        reinversionBox.setText(cantidadReinversion);
        porcentajeGananciaBox.setText(porcentajeGanancia);
        porcentajeReinversionBox.setText(porcentajeReinversion);
        sliderPorcentaje.setValue(porcentajeTotal.toBigInteger().intValue());
        descripcionBox.setText(descripcion);

        garantiaBox.setText(garantia);
    }


    public void actualizarProducto() {
        em.getTransaction().begin();

        NuevoProductoDTO nuevoProductoDTO = nuevoProductoDTO();
        Provedor provedor = provedorDAO.getProvedorPorNombre(nuevoProductoDTO.provedor());

        nuevosValoresProducto(producto, nuevoProductoDTO);
        producto.setProvedor(provedor);
        productoDAO.actualizarProducto(producto);

        em.getTransaction().commit();

        funcionesPostAgregarProducto();
    }

    private void nuevosValoresProducto(Producto producto, NuevoProductoDTO nuevoProductoDTO) {

        producto.setNombre(nuevoProductoDTO.nombre().toUpperCase());
        producto.setMarca(nuevoProductoDTO.marca().toUpperCase());
        producto.setModelo(nuevoProductoDTO.modelo().toUpperCase());
        producto.setCantidad(nuevoProductoDTO.cantidad());
        producto.setDescripcion(nuevoProductoDTO.descripcion().toUpperCase());
        producto.setPrecioCompra(nuevoProductoDTO.precioCompra());
        producto.setPrecioVenta(nuevoProductoDTO.precioVenta());
        producto.setGarantia(nuevoProductoDTO.garantia());
        producto.setReinversion(nuevoProductoDTO.reinversion());

    }

    private NuevoProductoDTO nuevoProductoDTO() {
        NuevoProductoDTO nuevoProductoDTO;

        try {
            nuevoProductoDTO = new NuevoProductoDTO(nombreProductoBox.getText(), marcaBox.getText(), modeloBox.getText(), Integer.parseInt(cantidadBox.getText()), (String) provedorBox.getSelectedItem(), garantiaBox.getText(), descripcionBox.getText(), new BigDecimal(precioCompraBox.getText()), new BigDecimal(gananciaBox.getText()), new BigDecimal(reinversionBox.getText()), new BigDecimal(precioVentaBox.getText()));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Favor de verificar el valor de los campos ");
            throw new RuntimeException(ex);
        }

        return nuevoProductoDTO;

    }



    private void siguienteQuery() {
        String[] options = {"Si", "No"};

        int agregarNuevoProducto = JOptionPane.showOptionDialog(null, "¿Deseas editar otro producto?", "Producto Actualizado Exitosamente", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (agregarNuevoProducto == 0) {
            Go.to(new InventarioPanel());
            em.close();
        } else if (agregarNuevoProducto == 1) {
            Go.to(Home.computoPanel);
        }

    }

    private void funcionesPostAgregarProducto() {
        llenarCajas("id", null, null, null, null, null, null, null, null, null, null, new BigDecimal("200"), null, null);
        siguienteQuery();
    }











   /* private void calcularPrecioVenta() {
        float precioCompra = 0;
        float porcentajeGanancia = 0, porcentajeReinversion = 0;

        try {
            precioCompra = Float.parseFloat(precioCompraBox.getText());
            porcentajeGanancia = Float.parseFloat(porcentajeGananciaBox.getText());
            porcentajeReinversion = Float.parseFloat(porcentajeReinversionBox.getText());
        } catch (NumberFormatException ex) {
            porcentajeGanancia = 0;
            porcentajeReinversion = 0;
        }

        float precioVenta = precioCompra + (precioCompra * (porcentajeGanancia / 100)) + (precioCompra * (porcentajeReinversion / 100));

        precioVentaBox.setText(Float.toString(Math.round(precioVenta)));
    }

    private void calcularGYR() {
        float precioCompra = 0, porcentajeGanancia = 0, porcentajeReinversion = 0;

        try {
            precioCompra = Float.parseFloat(precioCompraBox.getText());
            porcentajeGanancia = Float.parseFloat(porcentajeGananciaBox.getText());
            porcentajeReinversion = Float.parseFloat(porcentajeReinversionBox.getText());
        } catch (NumberFormatException ex) {
            porcentajeGanancia = 0;
            porcentajeReinversion = 0;
        }

        ganancia = precioCompra * (porcentajeGanancia / 100);
        reinversion = precioCompra * (porcentajeReinversion / 100);

        gananciaBox.setText(Float.toString(Math.round(ganancia)));
        reinversionBox.setText(Float.toString(Math.round(reinversion)));
    }

    private void ajustarPorcentajeReinversion() {

        float porcentajeGanancia = Float.parseFloat(porcentajeGananciaBox.getText());

        double porcentajeReinversion = porcentajeTotal - porcentajeGanancia;

        porcentajeReinversionBox.setText(Double.toString(porcentajeReinversion));
    }

    private void ajustarPorcentajeGanancia() {

        float porcentajeReinversion = Float.parseFloat(porcentajeReinversionBox.getText());

        double porcentajeGanancia = porcentajeTotal - porcentajeReinversion;

        porcentajeGananciaBox.setText(Double.toString(porcentajeGanancia));
    }

    private float getPrecioCompra() {
        float pC = 0;
        try {
            pC = Float.parseFloat(precioCompraBox.getText());
        } catch (NumberFormatException Ex) {

        }
        return pC;
    }

    private float getPorcentajeGanancia() {
        float porcentaje = 0;
        try {
            porcentaje = Float.parseFloat(porcentajeGananciaBox.getText());
        } catch (NumberFormatException Ex) {
            System.out.println("Valor de porcentaje inválido");
        }

        return porcentaje;
    }

    private void activarBotonIva() {
        ivaButton.removeAll();
        ivaButton.setBackground(Colors.buttonPressed);
        //El Nombre no esta conforme al método, por el cambio de color, pero no importa
        ivaButton.add(Images.getIvaDisable(), posi);
        editarProductoPanel.revalidate();
        editarProductoPanel.repaint();
    }

    private void desactivarBotonIva() {
        ivaButton.removeAll();
        ivaButton.setBackground(Colors.panel);
        //El Nombre no esta conforme al método, por el cambio de color, pero no importa
        ivaButton.add(Images.getIvaEnable(), posi);
        editarProductoPanel.revalidate();
        editarProductoPanel.repaint();
    }*/

}
