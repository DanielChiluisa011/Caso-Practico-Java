package com.bancopichincha.api.controller;

import com.bancopichincha.application.command.create.CreateClienteCommand;
import com.bancopichincha.application.command.create.CreateCuentaCommand;
import com.bancopichincha.application.dto.request.CreateClienteRequest;
import com.bancopichincha.application.dto.response.CreateClienteResponse;
import com.bancopichincha.application.dto.response.CreateCuentaResponse;
import com.bancopichincha.application.util.Shared;
import io.jkratz.mediator.core.Mediator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cuentas")
public class CuentasController {
    private static final Logger logger = LoggerFactory.getLogger(CuentasController.class);
    public static final String SENDING_COMMAND = "------ Sending command : {} {} ";
    public static final String SENDING_QUERY = "------ Sending query in {}: {} {}";

    private final Mediator mediator;
    @Autowired
    public CuentasController(Mediator mediator) {
        this.mediator = mediator;
    }
    @PostMapping("/")
    public ResponseEntity<CreateCuentaResponse> createCuenta(@Valid @RequestBody CreateCuentaCommand command) {
        try{
            CreateCuentaCommand safeCommand = new CreateCuentaCommand();
            logger.info("sanitize {}",Shared. sanitizeString(command.getTipo()));
            safeCommand.setTipo(Shared.sanitizeString(command.getTipo()));
            safeCommand.setEstado(command.getEstado());
            safeCommand.setSaldoInicial(command.getSaldoInicial());
            return new ResponseEntity<>(this.mediator.dispatch(safeCommand), HttpStatus.OK);
        } catch (
                ResponseStatusException e) {
            logger.info(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
