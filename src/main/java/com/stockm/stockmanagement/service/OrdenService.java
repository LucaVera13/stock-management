package com.stockm.stockmanagement.service;

import com.stockm.stockmanagement.model.Orden;
import com.stockm.stockmanagement.repository.IOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenService implements IOrdenService {
    @Autowired
    private IOrdenRepository ordenRepository;

    public List<Orden> getAllOrdenes() {
        return ordenRepository.findAll();
    }

    @Override
    public Optional<Orden> getOrdenById(int id) {
        return ordenRepository.findById(id);
    }


    @Override
    public Orden updateOrden(int id, Orden ordenActualizada) {

        Optional<Orden> ordenExistente = ordenRepository.findById(id);
        if (ordenExistente.isPresent()) {
            Orden orden = ordenExistente.get();
            orden.setEstado(ordenActualizada.getEstado());
            orden.setTotal(ordenActualizada.getTotal());
            orden.setProductosJson(ordenActualizada.getProductosJson());
            return ordenRepository.save(orden);

        }else {
            return null;
        }
    }

    @Override
    public Orden saveOrden(Orden orden) {
        return ordenRepository.save(orden);
    }

    @Override
    public Orden createOrden(Orden orden) {

        return ordenRepository.save(orden);
    }

    @Override
    public void deleteOrden(int id) {
        ordenRepository.deleteById(id);
    }


}
