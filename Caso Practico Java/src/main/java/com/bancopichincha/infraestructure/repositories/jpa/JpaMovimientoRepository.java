package com.bancopichincha.infraestructure.repositories.jpa;

import com.bancopichincha.infraestructure.model.MovimientoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaMovimientoRepository extends JpaRepository<MovimientoModel, String> {
    Optional<MovimientoModel> findById(String id);
}
