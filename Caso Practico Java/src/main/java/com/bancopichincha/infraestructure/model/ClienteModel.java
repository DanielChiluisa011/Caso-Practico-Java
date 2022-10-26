package com.bancopichincha.infraestructure.model;

import com.bancopichincha.domain.entities.Persona;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Accessors(chain = true)
@Entity
@Table(name = "cliente")
@Getter
@Setter
public class ClienteModel extends Persona {
    @Id
    private String id;
    @Column(name = "contrasena")
    private String contrasena;

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
