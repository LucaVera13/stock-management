package com.stockm.stockmanagement.service;
import com.stockm.stockmanagement.model.Orden;
import org.aspectj.weaver.ast.Or;

import java.util.List;
import java.util.Optional;

public interface IOrdenService {

        Orden createOrden(Orden orden);
        void deleteOrden(int id);
        List<Orden> getAllOrdenes();
        Optional<Orden> getOrdenById(int id);
        Orden updateOrden(int id,Orden orden);
        Orden saveOrden(Orden orden);
}
