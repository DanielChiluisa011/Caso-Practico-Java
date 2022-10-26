package com.bancopichincha.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateCuentaRequest {
    @NotBlank(message = "tipo field can't be empty.")
    private String tipo;

    @NotBlank(message = "numero field can't be empty.")
    private String numero;
    private float saldoInicial;
    private Boolean estado;
}
