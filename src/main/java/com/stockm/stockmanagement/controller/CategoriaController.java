package com.stockm.stockmanagement.controller;

import com.stockm.stockmanagement.model.Categoria;
import com.stockm.stockmanagement.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


 @RestController
 @RequestMapping("/categorias")
 public class CategoriaController {

    @Autowired
        private ICategoriaService categoriaService;

        @GetMapping
        public List<Categoria> getAllCategorias() {
            return categoriaService.getAllCategorias();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Categoria> getCategoriaById(@PathVariable int id) {
            return categoriaService.getCategoriaById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping
        public Categoria createCategoria(@RequestBody Categoria categoria) {
            return categoriaService.createCategoria(categoria);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Categoria> updateCategoria(@PathVariable int id, @RequestBody Categoria categoria) {
            Categoria categoriaActualizada = categoriaService.updateCategoria(id, categoria);
            if (categoriaActualizada != null) {
                return ResponseEntity.ok(categoriaActualizada);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCategoria(@PathVariable int id) {
            categoriaService.deleteCategoria(id);
            return ResponseEntity.noContent().build();
        }
    }

