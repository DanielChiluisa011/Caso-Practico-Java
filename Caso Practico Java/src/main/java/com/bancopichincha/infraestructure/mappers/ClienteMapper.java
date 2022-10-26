package com.bancopichincha.infraestructure.mappers;

import com.bancopichincha.domain.entities.Cliente;
import com.bancopichincha.domain.entities.Persona;
import com.bancopichincha.infraestructure.model.ClienteModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;
public class ClienteMapper {
    public ClienteMapper(){

    }
    public static Cliente toEntity(ClienteModel model){
        Cliente _cliente = new Cliente();
        _cliente.setClienteId(model.getId());
        _cliente.setEstado(model.getEstado());
        _cliente.setContrasena(model.getContrasena());
        _cliente.setNombre(model.getNombre());
        _cliente.setDireccion(model.getDireccion());
        _cliente.setIdentificacion(model.getIdentificacion());
        _cliente.setTelefono(model.getTelefono());
        _cliente.setEdad(model.getEdad());
        _cliente.setGenero(model.getGenero());
        return _cliente;
    }
    public static ClienteModel toModel(Cliente entity){
        ClienteModel model = new ClienteModel();
        model.setId(entity.getClienteId());
        model.setEstado(entity.getEstado());
        model.setContrasena(entity.getContrasena());
        model.setNombre(entity.getNombre());
        model.setDireccion(entity.getDireccion());
        model.setIdentificacion(entity.getIdentificacion());
        model.setTelefono(entity.getTelefono());
        model.setEdad(entity.getEdad());
        model.setGenero(entity.getGenero());
        return model;
    }
    /*@Mapping(source="id", target="clienteId")
    @Mapping(source="nombre", target="nombre")
    @Mapping(source="genero", target="genero")
    @Mapping(source="edad", target="edad")
    @Mapping(source="identificacion", target="identificacion")
    @Mapping(source="direccion", target="direccion")
    @Mapping(source="telefono", target="telefono")
    @Mapping(source="contrasena", target="contrasena")
    @Mapping(source="estado", target="estado")
    */
    //List<Cliente> toEntityList(List<ClienteModel> listModels);
    //@InheritInverseConfiguration
   // ClienteModel toModel(Cliente entity);
}
