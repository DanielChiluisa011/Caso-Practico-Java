package com.bancopichincha.domain.interfaces;

import com.bancopichincha.domain.entities.Cuenta;

public interface ICuentaRepository {
    String save(Cuenta cuenta);
    Cuenta getById(String id);
    void update(Cuenta cuenta);
    void delete(String id);
}
