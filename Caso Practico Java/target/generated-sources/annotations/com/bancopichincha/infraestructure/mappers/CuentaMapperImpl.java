package com.bancopichincha.infraestructure.mappers;

import com.bancopichincha.domain.entities.Cuenta;
import com.bancopichincha.infraestructure.model.CuentaModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-26T17:43:14-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class CuentaMapperImpl implements CuentaMapper {

    @Override
    public Cuenta toEntity(CuentaModel model) {
        if ( model == null ) {
            return null;
        }

        Cuenta cuenta = new Cuenta();

        cuenta.setCuentaId( model.getId() );
        cuenta.setNumero( model.getNumero() );
        cuenta.setTipo( model.getTipo() );
        if ( model.getSaldoInicial() != null ) {
            cuenta.setSaldoInicial( Float.parseFloat( model.getSaldoInicial() ) );
        }
        cuenta.setEstado( model.getEstado() );

        return cuenta;
    }

    @Override
    public List<Cuenta> toEntityList(List<CuentaModel> listModels) {
        if ( listModels == null ) {
            return null;
        }

        List<Cuenta> list = new ArrayList<Cuenta>( listModels.size() );
        for ( CuentaModel cuentaModel : listModels ) {
            list.add( toEntity( cuentaModel ) );
        }

        return list;
    }

    @Override
    public CuentaModel toModel(Cuenta entity) {
        if ( entity == null ) {
            return null;
        }

        CuentaModel cuentaModel = new CuentaModel();

        cuentaModel.setId( entity.getCuentaId() );
        cuentaModel.setNumero( entity.getNumero() );
        cuentaModel.setTipo( entity.getTipo() );
        cuentaModel.setSaldoInicial( String.valueOf( entity.getSaldoInicial() ) );
        cuentaModel.setEstado( entity.getEstado() );

        return cuentaModel;
    }
}
