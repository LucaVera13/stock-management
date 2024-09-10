package com.stockm.stockmanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String estado;
    private int total;

    @CreationTimestamp
    private LocalDateTime fecha_orden;

    @Lob
    private String productosJson;

    public Orden() {
    }

    public Orden(int id, String estado, int total, LocalDateTime fecha_orden) {
        this.id = id;
        this.estado = estado;
        this.total = total;
        this.fecha_orden = fecha_orden;
    }
}
