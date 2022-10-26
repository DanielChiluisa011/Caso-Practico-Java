package com.bancopichincha.application.command.delete;

import io.jkratz.mediator.core.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteMovimientoCommand implements Request<String> {
    private String id;
    public DeleteMovimientoCommand(String id){
        this.id = id;
    }
}
