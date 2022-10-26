package com.bancopichincha.domain.interfaces;

import com.bancopichincha.domain.entities.Movimiento;

public interface IMovimientoRepository {
    String save(Movimiento movimiento);
    Movimiento getById(String id);
    void update(Movimiento movimiento);
    void delete(String id);
}
