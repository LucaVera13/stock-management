package com.stockm.stockmanagement.service;

import com.stockm.stockmanagement.model.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {

    List<Producto> GetAllProductos();

    Optional<Producto> GetProductosById(int id);

    Producto createProducto(Producto producto);

    Producto updateProducto(int id,Producto producto);

    void deleteProducto(int id);
}
