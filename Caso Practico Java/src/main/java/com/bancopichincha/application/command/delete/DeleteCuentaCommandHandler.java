package com.bancopichincha.application.command.delete;

import com.bancopichincha.domain.interfaces.ICuentaRepository;
import io.jkratz.mediator.core.RequestHandler;
import org.springframework.stereotype.Component;

@Component
public class DeleteCuentaCommandHandler implements RequestHandler<DeleteCuentaCommand, String> {
    private final ICuentaRepository cuentaRepository;
    public DeleteCuentaCommandHandler(ICuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public String handle(DeleteCuentaCommand deleteCuentaCommand) {
        cuentaRepository.delete(deleteCuentaCommand.getId());
        return deleteCuentaCommand.getId();
    }
}
