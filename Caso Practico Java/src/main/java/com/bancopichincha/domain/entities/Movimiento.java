package com.bancopichincha.domain.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Movimiento {
    private String movimientoId;
    private Date fecha;
    private String tipo;
    private float valor;
    private float saldo;
}
