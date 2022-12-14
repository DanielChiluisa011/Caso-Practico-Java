package com.bancopichincha.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
public class CreateMovimientoRequest {
    private Date fecha;
    @NotBlank(message = "tipo field can't be empty.")
    private String tipo;
    private float valor;
}
