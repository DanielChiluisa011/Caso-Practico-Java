package com.bancopichincha.application.command.create;

import com.bancopichincha.application.dto.request.CreateMovimientoRequest;
import com.bancopichincha.application.dto.response.CreateMovimientoResponse;
import io.jkratz.mediator.core.Request;

public class CreateMovimientoCommand  extends CreateMovimientoRequest implements Request<CreateMovimientoResponse> {

    public CreateMovimientoCommand(){
        super();
    }
}
