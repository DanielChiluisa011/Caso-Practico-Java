package com.bancopichincha.application.command.delete;

import com.bancopichincha.application.command.read.ReadClientesCommand;
import com.bancopichincha.domain.entities.Cliente;
import com.bancopichincha.domain.interfaces.IClienteRepository;
import io.jkratz.mediator.core.CommandHandler;
import io.jkratz.mediator.core.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
@Component
public class DeleteClienteCommandHandler implements RequestHandler<DeleteClienteCommand, String> {
    private final IClienteRepository clienteRepository;
    public DeleteClienteCommandHandler(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public String handle(DeleteClienteCommand deleteClienteCommand) {
        clienteRepository.delete(deleteClienteCommand.getId());
        return deleteClienteCommand.getId();
    }
}
