package com.bancopichincha.application.command.read;

import com.bancopichincha.domain.entities.Cuenta;
import io.jkratz.mediator.core.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReadCuentaCommand implements Request<Cuenta> {
    private String numero;
    public ReadCuentaCommand(String id){
        this.numero = numero;
    }
}
