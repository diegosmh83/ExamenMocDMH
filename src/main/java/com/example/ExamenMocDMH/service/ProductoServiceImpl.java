package com.example.ExamenMocDMH.service;

import com.example.ExamenMocDMH.entity.Producto;
import com.example.ExamenMocDMH.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoService productoService;

    @Override
    public List<Producto> findAllProductos() {
        return this.productoService.findAllProductos();
    }

    @Override
    public Optional<Producto> findProducto(Long id) {
        return this.productoService.findProducto(id);
    }

    @Override
    public List<Producto> findByCategoria(String categoria) {
        return this.productoService.findByCategoria(categoria);
    }

    @Override
    public List<Producto> findByPrecio(float precio) {
        return this.productoService.findByPrecio(precio);
    }


    @Override
    public List<Producto> findByPrecioAndCategoria(float precio, String categoria) {
        return this.productoService.findByPrecioAndCategoria(precio, categoria);
    }

    @Override
    public Producto addProducto(Producto producto) {
        return this.productoService.addProducto(producto);
    }

    @Override
    public Optional eliminarProductoById(Long productoId) {
        Optional<Producto> producto = this.productoService.eliminarProductoById(productoId);
        producto.ifPresent(value -> this.productoService.eliminarProductoById(productoId));
        return producto;
    }

    @Override
    public Optional modificarProducto(Long productoId, Producto producto) {
        Optional<Producto> productoBbdd = this.productoService.modificarProducto(productoId, producto);
        if (productoBbdd.isPresent()){
            return this.productoService.findProducto(productoId);
        }
        return null;
    }

}
