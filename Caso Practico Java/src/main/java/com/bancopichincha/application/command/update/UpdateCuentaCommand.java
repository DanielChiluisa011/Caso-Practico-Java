package com.bancopichincha.application.command.update;

import com.bancopichincha.application.dto.request.UpdateCuentaRequest;
import io.jkratz.mediator.core.Command;

public class UpdateCuentaCommand extends UpdateCuentaRequest implements Command {
    public UpdateCuentaCommand(){
        super();
    }
}
