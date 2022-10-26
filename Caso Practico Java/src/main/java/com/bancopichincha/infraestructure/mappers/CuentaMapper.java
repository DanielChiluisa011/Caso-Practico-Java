package com.bancopichincha.infraestructure.mappers;

import com.bancopichincha.domain.entities.Cuenta;
import com.bancopichincha.domain.entities.Movimiento;
import com.bancopichincha.infraestructure.model.CuentaModel;
import com.bancopichincha.infraestructure.model.MovimientoModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CuentaMapper {
    @Mapping(source="id", target="cuentaId")
    @Mapping(source="tipo", target="tipo")
    @Mapping(source="saldoInicial", target="saldoInicial")
    @Mapping(source="estado", target="estado")
    Cuenta toEntity(CuentaModel model);
    List<Cuenta> toEntityList(List<CuentaModel> listModels);
    @InheritInverseConfiguration
    CuentaModel toModel(Cuenta entity);
}
