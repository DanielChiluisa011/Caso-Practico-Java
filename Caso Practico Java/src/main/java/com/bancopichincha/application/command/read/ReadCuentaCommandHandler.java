package com.bancopichincha.application.command.read;

import com.bancopichincha.domain.entities.Cuenta;
import com.bancopichincha.domain.interfaces.ICuentaRepository;
import io.jkratz.mediator.core.RequestHandler;
import org.springframework.stereotype.Component;

@Component
public class ReadCuentaCommandHandler implements RequestHandler<ReadCuentaCommand, Cuenta> {
    private final ICuentaRepository cuentaRepository;

    public ReadCuentaCommandHandler(ICuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public Cuenta handle(ReadCuentaCommand readCuentaCommand) {
        return cuentaRepository.getByNumero(readCuentaCommand.getNumero());
    }
}