package com.bancopichincha.application.command.read;

import com.bancopichincha.domain.entities.Cliente;
import io.jkratz.mediator.core.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReadClientesCommand implements Request<Cliente> {
    private String id;
    public ReadClientesCommand(String id){
        this.id = id;
    }
}
