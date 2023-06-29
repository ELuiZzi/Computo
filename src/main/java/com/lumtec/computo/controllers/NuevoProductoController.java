package com.lumtec.computo.controllers;

import com.lumtec.computo.infra.FuncionesMatematicas;
import com.lumtec.computo.infra.Ganancias;
import com.lumtec.computo.infra.Go;
import com.lumtec.computo.infra.dao.ProductoDAO;
import com.lumtec.computo.infra.dao.ProductoDAOJDBC;
import com.lumtec.computo.infra.dao.ProvedorDAO;
import com.lumtec.computo.infra.dao.ProvedorDAOJDBC;
import com.lumtec.computo.infra.dto.NuevoProductoDTO;
import com.lumtec.computo.infra.model.Producto;
import com.lumtec.computo.infra.model.Provedor;
import com.lumtec.computo.paneles.InventarioPanel;
import com.lumtec.computo.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.math.BigDecimal;
import java.math.MathContext;

public class NuevoProductoController {

    static boolean primeraVez = true;
    private static BigDecimal precioCompraSinIVA;
    private final ProductoDAO productoDAO;
    private final ProvedorDAO provedorDAO;
    private final JTextField nombreBox;
    private final JTextField marcaBox;
    private final JTextField modeloBox;
    private final JTextField cantidadBox;
    private final JTextField garantiaBox;
    private final JTextArea descripcioBox;
    private final JTextField precioCompraBox;
    private final JTextField aumentoTotalBox;
    private final JTextField gananciaBox;
    private final JTextField reinversionBox;
    private final JTextField precioVentaBox;
    private final JComboBox provedorBox;
    private final JLabel reinversionLabel;
    private final JLabel gananciaLabel;
    private final JLabel aumentoTotalLabel;
    private final JCheckBox transporteJCheckBox;
    private final BigDecimal precioVentaConTransporte = new BigDecimal("20");
    private EntityManager em;
    private BigDecimal precioVenta;

    public NuevoProductoController(JTextField nombre, JTextField marca, JTextField modelo, JTextField cantidad, JTextField garantia, JTextArea descripcion, JTextField precioCompra, JTextField aumentoTotal, JTextField ganancia, JTextField reinversion, JTextField precioVenta, JComboBox provedorBox, JLabel reinversionLabel, JLabel gananciaLabel, JLabel aumentoTotalLabel, JCheckBox transporteJCheckBox) {
        this.reinversionLabel = reinversionLabel;
        this.gananciaLabel = gananciaLabel;
        this.aumentoTotalLabel = aumentoTotalLabel;
        this.transporteJCheckBox = transporteJCheckBox;

        em = JPAUtils.getEntityManger();
        productoDAO = new ProductoDAOJDBC(em);
        provedorDAO = new ProvedorDAOJDBC(em);

        this.nombreBox = nombre;
        this.marcaBox = marca;
        this.modeloBox = modelo;
        this.cantidadBox = cantidad;
        this.provedorBox = provedorBox;
        this.garantiaBox = garantia;
        this.descripcioBox = descripcion;
        this.precioCompraBox = precioCompra;
        this.aumentoTotalBox = aumentoTotal;
        this.gananciaBox = ganancia;
        this.reinversionBox = reinversion;
        this.precioVentaBox = precioVenta;

    }

    public void nuevoProducto() {

        NuevoProductoDTO nuevoProductoDTO = nuevoProductoDTO();

        Producto producto = new Producto(nuevoProductoDTO);


        em.getTransaction().begin();

        Provedor provedor = provedorDAO.getProvedorPorNombre(nuevoProductoDTO.provedor());
        producto.setProvedor(provedor);
        productoDAO.nuevoProducto(producto);

        em.getTransaction().commit();


        funcionesPostAgregarProducto();

    }

    private NuevoProductoDTO nuevoProductoDTO() {
        NuevoProductoDTO nuevoProductoDTO;

        try {
            nuevoProductoDTO = new NuevoProductoDTO(nombreBox.getText(), marcaBox.getText(), modeloBox.getText(), Integer.parseInt(cantidadBox.getText()), (String) provedorBox.getSelectedItem(), garantiaBox.getText(), descripcioBox.getText(), new BigDecimal(precioCompraBox.getText()), new BigDecimal(gananciaBox.getText()), new BigDecimal(reinversionBox.getText()), new BigDecimal(precioVentaBox.getText()));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Favor de verificar el valor de los campos ");
            throw new RuntimeException(ex);
        }

        return nuevoProductoDTO;

    }



    private void reiniciarVentana() {

        this.nombreBox.setText(null);
        this.marcaBox.setText(null);
        this.modeloBox.setText(null);
        this.cantidadBox.setText(null);
        this.garantiaBox.setText(null);
        this.descripcioBox.setText(null);
        this.precioCompraBox.setText(null);
        this.aumentoTotalBox.setText(null);
        this.gananciaBox.setText(null);
        this.reinversionBox.setText(null);
        this.precioVentaBox.setText(null);
    }

    private void funcionesPostAgregarProducto() {
        reiniciarVentana();
        siguienteQuery();
    }

    private void siguienteQuery() {
        String[] options = {"Si", "No"};

        int agregarNuevoProducto = JOptionPane.showOptionDialog(null, "¿Deseas agregar otro producto?", "Producto Agregado Exitosamente",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (agregarNuevoProducto == 1) {
            Go.to(new InventarioPanel());
            em.close();
        }

    }

    public void calcularAumento() {
        BigDecimal precioCompra = new BigDecimal(precioCompraBox.getText());

        int aumento = Ganancias.getGanancia(precioCompra);

        BigDecimal aumentoEnDecimal = new BigDecimal(aumento).divide(new BigDecimal(100, new MathContext(5)));

        BigDecimal precioVenta = precioCompra.add(precioCompra.multiply(aumentoEnDecimal));

        BigDecimal porcentajeReinversion = calcularReinversion(precioCompra);
        BigDecimal porcentajeGanancia = calcularGanancia(aumento, porcentajeReinversion);
        BigDecimal reinversionAumentada = FuncionesMatematicas.cantidadAumentada(precioCompra, porcentajeReinversion);
        BigDecimal gananciaAumentada = FuncionesMatematicas.cantidadAumentada(precioCompra, porcentajeGanancia);
        BigDecimal aumentoTotal = reinversionAumentada.add(gananciaAumentada);

        aumentoTotalBox.setText(Integer.toString(aumento));
        aumentoTotalLabel.setText(aumentoTotal.toString());
        reinversionBox.setText(porcentajeReinversion.toString());
        reinversionLabel.setText(reinversionAumentada.toString());
        gananciaBox.setText(porcentajeGanancia.toString());
        gananciaLabel.setText(gananciaAumentada.toString());
        precioVentaBox.setText(precioVenta.toString());

    }

    private BigDecimal calcularReinversion(BigDecimal precioCompra) {
        return new BigDecimal(1000).divide(precioCompra, new MathContext(5));
    }

    private BigDecimal calcularGanancia(Integer aumentoTotal, BigDecimal porcentajeReinversion) {
        BigDecimal aumentoTotal1 = new BigDecimal(aumentoTotal);
        return aumentoTotal1.subtract(porcentajeReinversion);
    }

    public void asignarIVA(BigDecimal precioCompra) {

        if (primeraVez) {
            precioCompraSinIVA = precioCompra;
            primeraVez = false;
            BigDecimal precioIva = precioCompra.add(FuncionesMatematicas.returnIva(precioCompra));
            precioCompraBox.setText(precioIva.toString());
            calcularAumento();
        } else {
            primeraVez = true;
            precioCompraBox.setText(precioCompraSinIVA.toString());
            calcularAumento();
        }

    }

    public void sumarTransporte() {
        precioVenta = new BigDecimal(precioVentaBox.getText());
        if (transporteJCheckBox.isSelected()) {

            precioVentaBox.setText(precioVentaConTransporte.add(precioVenta).toString());
        } else if (!transporteJCheckBox.isSelected()) {
            precioVentaBox.setText(precioVenta.subtract(precioVentaConTransporte).toString());
        }
    }

}
