package com.bancopichincha.infraestructure.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Accessors(chain = true)
@Entity
@Table(name = "cuenta")
@Getter
@Setter
public class CuentaModel {
    @Id
    private String id;
    @Column(name = "numero")
    private String numero;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "saldoInicial")
    private String saldoInicial;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name="fechaCreacion")
    private Date fechaCreacion;

    @PrePersist
    public void prePersist(){
        this.fechaCreacion = new Date(System.currentTimeMillis());
        this.id = UUID.randomUUID().toString();
    }
}
