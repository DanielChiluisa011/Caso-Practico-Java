package com.bancopichincha.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cuenta {
    private String cuentaId;
    private String tipo;

    private String numero;
    private float saldoInicial;
    private Boolean estado;
}
