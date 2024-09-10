package com.stockm.stockmanagement.controller;


import com.stockm.stockmanagement.model.Producto;
import com.stockm.stockmanagement.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.GetAllProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable int id) {
        return productoService.GetProductosById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.createProducto(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable int id, @RequestBody Producto producto) {
        Producto productoUpdated = productoService.updateProducto(id, producto);
        if (productoUpdated != null) {
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable int id) {
        productoService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }

}
