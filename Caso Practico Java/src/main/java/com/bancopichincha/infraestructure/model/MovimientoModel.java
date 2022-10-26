package com.bancopichincha.infraestructure.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Accessors(chain = true)
@Entity
@Table(name = "movimiento")
@Getter
@Setter
public class MovimientoModel {
    @Id
    private String id;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "valor")
    private float valor;
    @Column(name = "saldo")
    private float saldo;
    @Column(name="fechaCreacion")
    private Date fechaCreacion;
    @PrePersist
    public void prePersist(){
        this.fechaCreacion = new Date(System.currentTimeMillis());
        this.id = UUID.randomUUID().toString();
    }
}
