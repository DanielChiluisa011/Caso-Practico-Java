package com.bancopichincha.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateClienteRequest {
    @NotBlank(message = "Name field can't be empty.")
    private String nombre;

    @NotBlank(message = "dirección field can't be empty.")
    private String dirección;

    @NotBlank(message = "telefono field can't be empty.")
    private String telefono;

    @NotBlank(message = "contraseña field can't be empty.")
    private String contrasena;

    private Boolean estado;

}
