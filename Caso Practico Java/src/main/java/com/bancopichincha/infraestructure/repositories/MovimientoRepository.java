package com.bancopichincha.infraestructure.repositories;

import com.bancopichincha.domain.entities.Movimiento;
import com.bancopichincha.domain.interfaces.IMovimientoRepository;
import com.bancopichincha.infraestructure.mappers.MovimientoMapper;
import com.bancopichincha.infraestructure.repositories.jpa.JpaMovimientoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovimientoRepository implements IMovimientoRepository {
    public static final String SENDING_COMMAND = "------ Sending command: {} {}";
    private static final Logger logger = LoggerFactory.getLogger(MovimientoRepository.class);
    @Autowired
    private JpaMovimientoRepository jpaMovimientoRepository;
    @Autowired
    private MovimientoMapper mapper;


    @Override
    public String save(Movimiento movimiento){
        return this.jpaMovimientoRepository.save(mapper.toModel(movimiento)).getId();
    }
    @Override
    public Movimiento getById(String id){
        var obj = jpaMovimientoRepository.findById(id).map(model -> mapper.toEntity(model));
        if (obj.isPresent())
            return obj.get();
        else
            return null;
    }
    @Override
    public void update(Movimiento movimiento){
        var movimientoModel = mapper.toModel(movimiento);
        //Save changes
        jpaMovimientoRepository.save(movimientoModel);
    }
    @Override
    public void delete(String id){
        jpaMovimientoRepository.deleteById(id);
    }
}
