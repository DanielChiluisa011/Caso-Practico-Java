package com.bancopichincha.application.command.update;

import com.bancopichincha.domain.entities.Cuenta;
import com.bancopichincha.domain.interfaces.ICuentaRepository;
import io.jkratz.mediator.core.CommandHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
@Component
public class UpdateCuentaCommandHandler implements CommandHandler<UpdateCuentaCommand> {
    private static final Logger logger = LoggerFactory.getLogger(UpdateCuentaCommandHandler.class);
    @Autowired
    private ICuentaRepository cuentaRepository;

    @Override
    @Transactional
    public void handle(UpdateCuentaCommand updateCuentaCommand){
        var cuenta = getCuenta(updateCuentaCommand.getNumero());
        cuenta.setCuentaId(updateCuentaCommand.getCuentaId());
        cuenta.setTipo(updateCuentaCommand.getTipo());
        cuenta.setNumero(updateCuentaCommand.getNumero());
        cuentaRepository.update(cuenta);
    }

    private Cuenta getCuenta(String numero){
        return cuentaRepository.getByNumero(numero);
    }
}
