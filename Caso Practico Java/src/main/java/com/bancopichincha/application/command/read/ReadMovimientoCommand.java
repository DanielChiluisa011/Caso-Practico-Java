package com.bancopichincha.application.command.read;

import com.bancopichincha.domain.entities.Movimiento;
import io.jkratz.mediator.core.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReadMovimientoCommand implements Request<Movimiento> {
    private String id;
    public ReadMovimientoCommand(String id){
        this.id = id;
    }
}
