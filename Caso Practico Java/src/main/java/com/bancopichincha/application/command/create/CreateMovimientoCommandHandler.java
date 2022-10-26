package com.bancopichincha.application.command.create;

import com.bancopichincha.application.dto.response.CreateCuentaResponse;
import com.bancopichincha.application.dto.response.CreateMovimientoResponse;
import com.bancopichincha.domain.entities.Movimiento;
import com.bancopichincha.domain.interfaces.IMovimientoRepository;
import io.jkratz.mediator.core.Mediator;
import io.jkratz.mediator.core.RequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
@Component
public class CreateMovimientoCommandHandler implements RequestHandler<CreateMovimientoCommand, CreateMovimientoResponse> {
    @Autowired
    private IMovimientoRepository movimientoRepository;

    @Autowired
    private Mediator mediator;

    private static final Logger logger = LoggerFactory.getLogger(CreateCuentaCommandHanlder.class);

    @Override
    @Transactional
    public CreateMovimientoResponse handle(CreateMovimientoCommand createMovimientoCommand){
        var movimiento = new Movimiento();
        movimiento.setFecha(createMovimientoCommand.getFecha());
        movimiento.setTipo(createMovimientoCommand.getTipo());
        movimiento.setValor(createMovimientoCommand.getValor());
        String movimientoId = movimientoRepository.save(movimiento);
        return new CreateMovimientoResponse(movimientoId);
    }
}

