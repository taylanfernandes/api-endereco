package com.taylan.endereco.mapperConverter;

import com.taylan.endereco.model.dto.EnderecoDto;
import com.taylan.endereco.model.entity.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface EnderecoMapperConverter {

    // Converter ENTITY -> DTO
    EnderecoDto entityToDto(Endereco endereco);

    // Converter DTO -> ENTITY
    Endereco dtoToEntity(EnderecoDto enderecoDto);

}
