package com.bancopichincha.infraestructure.repositories.jpa;

import com.bancopichincha.infraestructure.model.ClienteModel;
import com.bancopichincha.infraestructure.model.CuentaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaCuentaRepository extends JpaRepository<CuentaModel, String> {
    Optional<CuentaModel> findById(String id);
}
