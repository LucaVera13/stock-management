package com.stockm.stockmanagement.controller;

import com.stockm.stockmanagement.model.Orden;
import com.stockm.stockmanagement.service.IOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    @Autowired
    private IOrdenService ordenService;

    @GetMapping
    public List<Orden> getAllOrdenes() {
        return ordenService.getAllOrdenes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orden> getOrdenById(@PathVariable int id) {
        return ordenService.getOrdenById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Orden createOrden(@RequestBody Orden orden) {
        return ordenService.createOrden(orden);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orden> updateOrden(@PathVariable int id, @RequestBody Orden orden) {
        Orden ordenActualizada = ordenService.updateOrden(id, orden);
        if (ordenActualizada != null) {
            return ResponseEntity.ok(ordenActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOrden(@PathVariable int id) {
        ordenService.deleteOrden(id);
        return ResponseEntity.noContent().build();
    }
}
