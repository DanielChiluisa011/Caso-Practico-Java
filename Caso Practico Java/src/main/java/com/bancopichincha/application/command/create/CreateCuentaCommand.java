package com.bancopichincha.application.command.create;


import com.bancopichincha.application.dto.request.CreateCuentaRequest;
import com.bancopichincha.application.dto.response.CreateCuentaResponse;
import io.jkratz.mediator.core.Request;

public class CreateCuentaCommand extends CreateCuentaRequest implements Request<CreateCuentaResponse> {

    public CreateCuentaCommand(){
        super();
    }
}
