package com.example.ExamenMocDMH.controller;

import com.example.ExamenMocDMH.entity.Producto;
import com.example.ExamenMocDMH.service.ProductoServiceImpl;
import com.example.ExamenMocDMH.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class ProductoController {
    @Autowired
    private ProductoServiceImpl productoServiceImpl;

    @PostMapping(value = "/productos")
    public Producto addProducto(@RequestBody Producto producto) {
        return productoServiceImpl.addProducto(producto);
    }

    @DeleteMapping(value = "/producto/{productoId}")
    public void deleteProducto(@PathVariable Long productoId) {
        productoServiceImpl.eliminarProductoById(productoId);
    }

    @PutMapping(value = "/producto/{productoId}")
    public Producto modificarProducto(@PathVariable Long productoId, @RequestBody Producto producto) {
        productoServiceImpl.modificarProducto(productoId,producto);
        return producto;
    }

    @GetMapping(value = "/productos")
    public List<Producto> getProductos(@RequestParam(defaultValue = "0.0") Float precio,
                                       @RequestParam(defaultValue = "") String categoria) {
        if(precio>0){
            productoServiceImpl.findByPrecio(precio);

        }else if(!categoria.equals("")){
            productoServiceImpl.findByCategoria(categoria);
        }else{
            productoServiceImpl.findAllProductos();
        }
        /*
            - Si no se indica ni precio ni categoría -> obtener todos los productos.
            - Si se indica el precio -> obtener los productos con ese precio.
            - Si se indica la categoria -> obtener los productos con esa categoria.
         */
        return getProductos(precio,categoria);
    }

    @GetMapping(value = "/producto/{productoId}")
    public Optional<Producto> getProducto(@PathVariable Long productoId) {
        return productoServiceImpl.findProducto(productoId);
    }
}
