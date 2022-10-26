package com.bancopichincha.api.controller;

import com.bancopichincha.application.command.create.CreateCuentaCommand;
import com.bancopichincha.application.command.create.CreateMovimientoCommand;
import com.bancopichincha.application.dto.response.CreateCuentaResponse;
import com.bancopichincha.application.dto.response.CreateMovimientoResponse;
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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/movimientos")
public class MovimientosController {
    private static final Logger logger = LoggerFactory.getLogger(MovimientosController.class);
    public static final String SENDING_COMMAND = "------ Sending command : {} {} ";
    public static final String SENDING_QUERY = "------ Sending query in {}: {} {}";
    private final Mediator mediator;

    private Shared utils;
    @Autowired
    public MovimientosController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping("/")
    public ResponseEntity<CreateMovimientoResponse> createMovimiento(@Valid @RequestBody CreateMovimientoCommand command) {
        try{
            CreateMovimientoCommand safeCommand = new CreateMovimientoCommand();
            safeCommand.setTipo(utils.sanitizeString(command.getTipo()));
            safeCommand.setFecha(command.getFecha());
            safeCommand.setValor(command.getValor());
            return new ResponseEntity<>(this.mediator.dispatch(safeCommand), HttpStatus.OK);
        } catch (
                ResponseStatusException e) {
            logger.info(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
