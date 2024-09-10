package com.stockm.stockmanagement.service;

import com.stockm.stockmanagement.model.Producto;
import com.stockm.stockmanagement.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductoService implements IProductoService {
    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public List<Producto> GetAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> GetProductosById(int id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto createProducto(Producto producto) {

        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(int id, Producto productoActualizado) {
        Optional<Producto> productoExistente = productoRepository.findById(id);
        if (productoExistente.isPresent()) {
            Producto producto = productoExistente.get();
            producto.setNombre(productoActualizado.getNombre());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setDescripcion(productoActualizado.getDescripcion());
            producto.setCategoria(productoActualizado.getCategoria());
            producto.setStock(productoActualizado.getStock());
            return productoRepository.save(producto);
        } else {
            return null;
        }
    }

    @Override
    public void deleteProducto(int id) {
        productoRepository.deleteById(id);
    }
}
