package com.bancopichincha.application.command.create;

import com.bancopichincha.application.dto.response.CreateCuentaResponse;
import com.bancopichincha.domain.entities.Cuenta;
import com.bancopichincha.domain.interfaces.ICuentaRepository;
import io.jkratz.mediator.core.Mediator;
import io.jkratz.mediator.core.RequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
@Component
public class CreateCuentaCommandHanlder implements RequestHandler<CreateCuentaCommand, CreateCuentaResponse> {
    @Autowired
    private ICuentaRepository cuentaRepository;

    @Autowired
    private Mediator mediator;

    private static final Logger logger = LoggerFactory.getLogger(CreateCuentaCommandHanlder.class);

    @Override
    @Transactional
    public CreateCuentaResponse handle(CreateCuentaCommand createCuentaCommand){
        var cuenta = new Cuenta();
        cuenta.setTipo(createCuentaCommand.getTipo());
        cuenta.setSaldoInicial(createCuentaCommand.getSaldoInicial());
        cuenta.setEstado(createCuentaCommand.getEstado());
        String cuentaId = cuentaRepository.save(cuenta);
        return new CreateCuentaResponse(cuentaId);
    }
}
