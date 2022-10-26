package com.bancopichincha.application.command.create;

import com.bancopichincha.application.dto.request.CreateClienteRequest;
import com.bancopichincha.application.dto.response.CreateClienteResponse;
import com.bancopichincha.domain.entities.Cliente;
import com.bancopichincha.domain.interfaces.IClienteRepository;
import io.jkratz.mediator.core.Mediator;
import io.jkratz.mediator.core.RequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
@Component
public class CreateClienteCommandHandler implements RequestHandler<CreateClienteCommand, CreateClienteResponse> {
    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private Mediator mediator;

    private static final Logger logger = LoggerFactory.getLogger(CreateClienteCommandHandler.class);

    @Override
    @Transactional
    public CreateClienteResponse handle(CreateClienteCommand createClienteCommand){
        var cliente = new Cliente();
        cliente.setNombre(createClienteCommand.getNombre());
        cliente.setDireccion(createClienteCommand.getDirección());
        cliente.setTelefono(createClienteCommand.getTelefono());
        cliente.setContrasena(createClienteCommand.getContrasena());
        cliente.setEstado(createClienteCommand.getEstado());
        String clientId = clienteRepository.save(cliente);
        return new CreateClienteResponse(clientId);
    }
}
