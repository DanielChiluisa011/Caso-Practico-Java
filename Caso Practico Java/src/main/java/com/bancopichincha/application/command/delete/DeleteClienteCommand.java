package com.bancopichincha.application.command.delete;

import com.bancopichincha.domain.entities.Cliente;
import io.jkratz.mediator.core.Command;
import io.jkratz.mediator.core.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteClienteCommand implements Request<String> {
    private String id;
    public DeleteClienteCommand(String id){
        this.id = id;
    }
}
