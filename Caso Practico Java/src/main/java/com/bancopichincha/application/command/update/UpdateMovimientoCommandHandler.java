package com.bancopichincha.application.command.update;

import com.bancopichincha.domain.entities.Cuenta;
import com.bancopichincha.domain.entities.Movimiento;
import com.bancopichincha.domain.interfaces.ICuentaRepository;
import com.bancopichincha.domain.interfaces.IMovimientoRepository;
import io.jkratz.mediator.core.CommandHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class UpdateMovimientoCommandHandler implements CommandHandler<UpdateMovimientoCommand> {
    private static final Logger logger = LoggerFactory.getLogger(UpdateMovimientoCommandHandler.class);
    @Autowired
    private IMovimientoRepository movimientoRepository;

    @Override
    @Transactional
    public void handle(UpdateMovimientoCommand updateMovimientoCommand){
        var movimiento = getMovimiento(updateMovimientoCommand.getMovimientoId());
        movimiento.setTipo(updateMovimientoCommand.getTipo());
        movimiento.setValor(updateMovimientoCommand.getValor());
        movimiento.setFecha(updateMovimientoCommand.getFecha());
        movimientoRepository.update(movimiento);
    }

    private Movimiento getMovimiento(String id){
        return movimientoRepository.getById(id);
    }
}
