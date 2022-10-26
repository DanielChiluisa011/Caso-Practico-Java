package com.bancopichincha.api.controller;

import com.bancopichincha.application.command.create.CreateCuentaCommand;
import com.bancopichincha.application.command.delete.DeleteClienteCommand;
import com.bancopichincha.application.command.delete.DeleteCuentaCommand;
import com.bancopichincha.application.command.read.ReadCuentaCommand;
import com.bancopichincha.application.command.update.UpdateClienteCommand;
import com.bancopichincha.application.command.update.UpdateCuentaCommand;
import com.bancopichincha.application.dto.response.CreateCuentaResponse;
import com.bancopichincha.application.util.Shared;
import com.bancopichincha.domain.entities.Cuenta;
import io.jkratz.mediator.core.Mediator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cuentas")
public class CuentasController {
    private static final Logger logger = LoggerFactory.getLogger(CuentasController.class);
    public static final String SENDING_COMMAND = "------ Sending command : {} {} ";
    public static final String SENDING_QUERY = "------ Sending query in {}: {} {}";

    private final Mediator mediator;
    private Shared utils;
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
    @GetMapping("/{numero}")
    public ResponseEntity<Cuenta> getCuenta(@PathVariable("numero") String numero) {
        try {
            var query = new ReadCuentaCommand(utils.sanitizeString(numero));
            return new ResponseEntity<>(this.mediator.dispatch(query), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            logger.info(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/")
    public ResponseEntity<Void> putCuenta(@Valid @RequestBody UpdateCuentaCommand command) {
        try{
            UpdateCuentaCommand safeCommand = new UpdateCuentaCommand();
            safeCommand.setCuentaId(command.getCuentaId());
            safeCommand.setEstado(command.getEstado());
            safeCommand.setNumero(command.getNumero());
            safeCommand.setTipo(command.getTipo());
            this.mediator.dispatch(command);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (
                ResponseStatusException e) {
            logger.info(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable("id") String id) {
        try {
            var query = new DeleteCuentaCommand(utils.sanitizeString(id));
            this.mediator.dispatch(query);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (ResponseStatusException e) {
            logger.info(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
