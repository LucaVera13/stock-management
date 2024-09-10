package com.stockm.stockmanagement.service;

import com.stockm.stockmanagement.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {
    List<Categoria> getAllCategorias();

    Optional<Categoria> getCategoriaById(int id);

    Categoria createCategoria(Categoria categoria);

    Categoria updateCategoria(int id, Categoria categoria);

    void deleteCategoria(int id);
}
