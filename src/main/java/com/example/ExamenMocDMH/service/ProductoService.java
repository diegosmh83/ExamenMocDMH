package com.example.ExamenMocDMH.service;

import com.example.ExamenMocDMH.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> findAllProductos();
    Optional<Producto> findProducto(Long id);
    List<Producto> findByCategoria(String categoria);
    List<Producto> findByPrecio(float precio);

    List<Producto> findByPrecioAndCategoria(float precio, String categoria);

    Producto addProducto(Producto producto);
    Optional eliminarProductoById(Long productoId);
    Optional modificarProducto(Long productoId, Producto producto);
}
