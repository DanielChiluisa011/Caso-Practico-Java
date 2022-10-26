package com.bancopichincha.application.command.delete;

import com.bancopichincha.domain.interfaces.ICuentaRepository;
import com.bancopichincha.domain.interfaces.IMovimientoRepository;
import io.jkratz.mediator.core.RequestHandler;
import org.springframework.stereotype.Component;

@Component
public class DeleteMovimientoCommandHandler implements RequestHandler<DeleteMovimientoCommand, String> {
    private final IMovimientoRepository movimientoRepository;
    public DeleteMovimientoCommandHandler(IMovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    @Override
    public String handle(DeleteMovimientoCommand deleteMovimientoCommand) {
        movimientoRepository.delete(deleteMovimientoCommand.getId());
        return deleteMovimientoCommand.getId();
    }
}
