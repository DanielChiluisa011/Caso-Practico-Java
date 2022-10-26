package com.bancopichincha.application.command.delete;

import io.jkratz.mediator.core.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteCuentaCommand implements Request<String> {
    private String id;
    public DeleteCuentaCommand(String id){
        this.id = id;
    }
}
