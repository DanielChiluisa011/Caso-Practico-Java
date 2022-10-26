package com.bancopichincha.application.command.update;

import com.bancopichincha.application.dto.request.UpdateClienteRequest;
import io.jkratz.mediator.core.Command;

public class UpdateClienteCommand extends UpdateClienteRequest implements Command {
    public UpdateClienteCommand(){
        super();
    }
}
