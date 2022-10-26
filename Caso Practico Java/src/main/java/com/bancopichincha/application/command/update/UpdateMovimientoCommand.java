package com.bancopichincha.application.command.update;

import com.bancopichincha.application.dto.request.UpdateMovimientoRequest;
import io.jkratz.mediator.core.Command;
public class UpdateMovimientoCommand extends UpdateMovimientoRequest implements Command {
    public UpdateMovimientoCommand(){
        super();
    }
}
