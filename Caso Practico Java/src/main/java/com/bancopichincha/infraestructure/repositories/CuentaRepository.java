package com.bancopichincha.infraestructure.repositories;

import com.bancopichincha.domain.entities.Cuenta;
import com.bancopichincha.domain.interfaces.ICuentaRepository;
import com.bancopichincha.infraestructure.mappers.CuentaMapper;
import com.bancopichincha.infraestructure.repositories.jpa.JpaCuentaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CuentaRepository implements ICuentaRepository {
    public static final String SENDING_COMMAND = "------ Sending command: {} {}";
    private static final Logger logger = LoggerFactory.getLogger(CuentaRepository.class);

    @Autowired
    private JpaCuentaRepository jpaCuentaRepository;

    @Autowired
    private CuentaMapper mapper;


    @Override
    public String save(Cuenta cuenta){
        return this.jpaCuentaRepository.save(mapper.toModel(cuenta)).getId();
    }
    @Override
    public Cuenta getById(String id){
        var obj = jpaCuentaRepository.findById(id).map(model -> mapper.toEntity(model));
        if (obj.isPresent())
            return obj.get();
        else
            return null;
    }
    @Override
    public void update(Cuenta cuenta){
        var cuentaModel = mapper.toModel(cuenta);
        //Save changes
        jpaCuentaRepository.save(cuentaModel);
    }
    @Override
    public void delete(String id){
        jpaCuentaRepository.deleteById(id);
    }
}
