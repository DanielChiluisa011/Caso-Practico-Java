package com.bancopichincha.infraestructure.repositories;

import com.bancopichincha.domain.entities.Cliente;
import com.bancopichincha.domain.interfaces.IClienteRepository;
import com.bancopichincha.infraestructure.mappers.ClienteMapper;
import com.bancopichincha.infraestructure.repositories.jpa.JpaClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository implements IClienteRepository {
    public static final String SENDING_COMMAND = "------ Sending command: {} {}";
    private static final Logger logger = LoggerFactory.getLogger(ClienteRepository.class);
    @Autowired
    private JpaClienteRepository jpaClienteRepository;
    //@Autowired
    //private ClienteMapper mapper;
    @Override
    public String save(Cliente cliente){
        return this.jpaClienteRepository.save(ClienteMapper.toModel(cliente)).getId();
    }
    @Override
    public Cliente getById(String id){
        var obj = jpaClienteRepository.findById(id).map(model -> ClienteMapper.toEntity(model));
        if (obj.isPresent())
            return obj.get();
        else
            return null;
    }
    @Override
    public void update(Cliente cliente){
        var clienteModel = ClienteMapper.toModel(cliente);
        //Save changes
        jpaClienteRepository.save(clienteModel);
    }
    @Override
    public void delete(String id){
        logger.info("delete {}", id);
        jpaClienteRepository.deleteById(id);
    }

}
