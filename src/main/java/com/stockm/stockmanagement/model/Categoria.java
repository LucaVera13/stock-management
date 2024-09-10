package com.stockm.stockmanagement.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Categoria {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String nombre;
        private String descripcion;

        @CreationTimestamp
        private LocalDateTime fechaCreacion;

        @UpdateTimestamp
        private LocalDateTime fechaModificacion;

    public Categoria() {
    }

    public Categoria(int id, String nombre, String descripcion, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }
}
