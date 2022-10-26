package com.bancopichincha.infraestructure.mappers;

import com.bancopichincha.domain.entities.Movimiento;
import com.bancopichincha.infraestructure.model.MovimientoModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-26T16:06:51-0500",
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
        if ( model.getTipo() != null ) {
            movimiento.setTipo( new SimpleDateFormat().format( model.getTipo() ) );
        }
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
        try {
            if ( entity.getTipo() != null ) {
                movimientoModel.setTipo( new SimpleDateFormat().parse( entity.getTipo() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        movimientoModel.setValor( entity.getValor() );
        movimientoModel.setSaldo( entity.getSaldo() );

        return movimientoModel;
    }
}
