package com.bancopichincha.application.command.create;

import com.bancopichincha.application.dto.request.CreateClienteRequest;
import com.bancopichincha.application.dto.response.CreateClienteResponse;
import io.jkratz.mediator.core.Request;

public class CreateClienteCommand extends CreateClienteRequest implements Request<CreateClienteResponse> {

    public CreateClienteCommand(){
        super();
    }
}
