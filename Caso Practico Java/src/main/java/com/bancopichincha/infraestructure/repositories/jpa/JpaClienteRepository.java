package com.bancopichincha.infraestructure.repositories.jpa;

import com.bancopichincha.infraestructure.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaClienteRepository extends JpaRepository<ClienteModel, String> {
    Optional<ClienteModel> findById(String id);
}
