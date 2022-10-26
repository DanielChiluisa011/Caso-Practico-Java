package com.bancopichincha.infraestructure.mappers;

import com.bancopichincha.domain.entities.Movimiento;
import com.bancopichincha.infraestructure.model.MovimientoModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-26T17:20:31-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class MovimientoMapperImpl implements MovimientoMapper {

    @Override
    public Movimiento toEntity(MovimientoModel model) {
        if ( model == null ) {
            return null;
        }

        Movimiento movimiento = new Movimiento();

        movimiento.setMovimientoId( model.getId() );
        movimiento.setFecha( model.getFecha() );
        movimiento.setTipo( model.getTipo() );
        movimiento.setValor( model.getValor() );
        movimiento.setSaldo( model.getSaldo() );

        return movimiento;
    }

    @Override
    public List<Movimiento> toEntityList(List<MovimientoModel> listModels) {
        if ( listModels == null ) {
            return null;
        }

        List<Movimiento> list = new ArrayList<Movimiento>( listModels.size() );
        for ( MovimientoModel movimientoModel : listModels ) {
            list.add( toEntity( movimientoModel ) );
        }

        return list;
    }

    @Override
    public MovimientoModel toModel(Movimiento entity) {
        if ( entity == null ) {
            return null;
        }

        MovimientoModel movimientoModel = new MovimientoModel();

        movimientoModel.setId( entity.getMovimientoId() );
        movimientoModel.setFecha( entity.getFecha() );
        movimientoModel.setTipo( entity.getTipo() );
        movimientoModel.setValor( entity.getValor() );
        movimientoModel.setSaldo( entity.getSaldo() );

        return movimientoModel;
    }
}
