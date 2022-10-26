package com.bancopichincha.application.command.read;

import com.bancopichincha.domain.entities.Cliente;
import com.bancopichincha.domain.interfaces.IClienteRepository;
import io.jkratz.mediator.core.RequestHandler;
import org.springframework.stereotype.Component;

@Component
public class ReadClientesCommandHandler implements RequestHandler<ReadClientesCommand, Cliente> {
    private final IClienteRepository clienteRepository;
    public ReadClientesCommandHandler(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente handle(ReadClientesCommand readClientesCommand) {
        return clienteRepository.getById(readClientesCommand.getId());
    }
}
