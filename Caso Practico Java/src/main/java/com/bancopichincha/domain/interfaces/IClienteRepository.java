package com.bancopichincha.domain.interfaces;

import com.bancopichincha.domain.entities.Cliente;

public interface IClienteRepository {
    String save(Cliente cliente);
    Cliente getById(String id);
    void update(Cliente cliente);
    void delete(String id);
}
