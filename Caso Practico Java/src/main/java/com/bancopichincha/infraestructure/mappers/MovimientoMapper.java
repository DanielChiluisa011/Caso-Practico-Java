package com.bancopichincha.infraestructure.mappers;

import com.bancopichincha.domain.entities.Cliente;
import com.bancopichincha.domain.entities.Movimiento;
import com.bancopichincha.infraestructure.model.ClienteModel;
import com.bancopichincha.infraestructure.model.MovimientoModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovimientoMapper {
    @Mapping(source="id", target="movimientoId")
    @Mapping(source="fecha", target="fecha")
    @Mapping(source="tipo", target="tipo")
    @Mapping(source="valor", target="valor")
    @Mapping(source="saldo", target="saldo")
    Movimiento toEntity(MovimientoModel model);
    List<Movimiento> toEntityList(List<MovimientoModel> listModels);
    @InheritInverseConfiguration
    MovimientoModel toModel(Movimiento entity);
}
