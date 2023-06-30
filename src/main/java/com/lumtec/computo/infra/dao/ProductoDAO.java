package com.lumtec.computo.infra.dao;

import com.lumtec.computo.infra.model.Producto;

import java.util.List;

public interface ProductoDAO {

    public void nuevoProducto(Producto producto);

    public List<Producto> getProductosInventario();

    public List<Producto> getProductos();

    public Producto getProductoPorNombre(String nombre);

    public Producto productoVentas(String nombre);

    public void actualizarProducto(Producto producto);

}
