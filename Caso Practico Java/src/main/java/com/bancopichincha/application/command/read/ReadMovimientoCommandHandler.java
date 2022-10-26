package com.bancopichincha.application.command.read;

import com.bancopichincha.domain.entities.Cuenta;
import com.bancopichincha.domain.entities.Movimiento;
import com.bancopichincha.domain.interfaces.ICuentaRepository;
import com.bancopichincha.domain.interfaces.IMovimientoRepository;
import io.jkratz.mediator.core.Request;
import io.jkratz.mediator.core.RequestHandler;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class ReadMovimientoCommandHandler implements RequestHandler<ReadMovimientoCommand, Movimiento> {
    private final IMovimientoRepository movimientoRepository;

    public ReadMovimientoCommandHandler(IMovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    @Override
    public Movimiento handle(ReadMovimientoCommand readMovimientoCommand) {
        return movimientoRepository.getById(readMovimientoCommand.getId());
    }
}
