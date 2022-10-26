package com.bancopichincha.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UpdateMovimientoRequest {
    private String movimientoId;
    private Date fecha;
    private String tipo;
    private float valor;
}
