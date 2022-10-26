package com.bancopichincha.api.controller;

import com.bancopichincha.application.command.create.CreateClienteCommand;
import com.bancopichincha.application.command.delete.DeleteClienteCommand;
import com.bancopichincha.application.command.read.ReadClientesCommand;
import com.bancopichincha.application.command.update.UpdateClienteCommand;
import com.bancopichincha.application.dto.request.CreateClienteRequest;
import com.bancopichincha.application.dto.response.CreateClienteResponse;
import com.bancopichincha.application.util.Shared;
import com.bancopichincha.domain.entities.Cliente;
import io.jkratz.mediator.core.Mediator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    private static final Logger logger = LoggerFactory.getLogger(CuentasController.class);
    public static final String SENDING_COMMAND = "------ Sending command : {} {} ";
    public static final String SENDING_QUERY = "------ Sending query in {}: {} {}";

    private Shared utils;
    private final Mediator mediator;
    @Autowired
    public ClientesController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping("/")
    public ResponseEntity<CreateClienteResponse> postCliente(@Valid @RequestBody CreateClienteCommand command) {
        try{
            CreateClienteCommand safeCommand = new CreateClienteCommand();
            safeCommand.setNombre(utils.sanitizeString(command.getNombre()));
            safeCommand.setDirección(utils.sanitizeString(command.getDirección()));
            safeCommand.setTelefono(utils.sanitizeString(command.getTelefono()));
            safeCommand.setContrasena(utils.sanitizeString(command.getContrasena()));
            safeCommand.setEstado(command.getEstado());
            return new ResponseEntity<>(this.mediator.dispatch(command), HttpStatus.OK);
        } catch (
        ResponseStatusException e) {
            logger.info(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/")
    public ResponseEntity<Void> putCliente(@Valid @RequestBody UpdateClienteCommand command) {
        try{
            UpdateClienteCommand safeCommand = new UpdateClienteCommand();
            safeCommand.setNombre(utils.sanitizeString(command.getNombre()));
            safeCommand.setDirección(utils.sanitizeString(command.getDirección()));
            safeCommand.setTelefono(utils.sanitizeString(command.getTelefono()));
            safeCommand.setContrasena(utils.sanitizeString(command.getContrasena()));
            safeCommand.setIdentificacion(utils.sanitizeString(command.getIdentificacion()));
            safeCommand.setEdad(command.getEdad());
            safeCommand.setGenero(utils.sanitizeString(command.getGenero()));
            safeCommand.setEstado(command.getEstado());
            this.mediator.dispatch(command);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (
                ResponseStatusException e) {
            logger.info(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable("id") String id) {
        try {
            var query = new ReadClientesCommand(utils.sanitizeString(id));
            return new ResponseEntity<>(this.mediator.dispatch(query), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            logger.info(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable("id") String id) {
        try {
            var query = new DeleteClienteCommand(utils.sanitizeString(id));
            this.mediator.dispatch(query);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (ResponseStatusException e) {
            logger.info(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
