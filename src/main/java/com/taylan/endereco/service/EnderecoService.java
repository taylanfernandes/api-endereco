package com.taylan.endereco.service;

import com.taylan.endereco.mapperConverter.EnderecoMapperConverter;
import com.taylan.endereco.model.dto.EnderecoDto;
import com.taylan.endereco.model.entity.Endereco;
import com.taylan.endereco.repository.EnderecoRepository;
import com.taylan.endereco.validator.EnderecoValidator;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EnderecoService {

    private EnderecoValidator enderecoValidator;

    private GeocodingApiService geocodingApiService = new GeocodingApiService();

    @Autowired
    private EnderecoRepository enderecoRepository;

    public void adicionarEndereco(EnderecoDto enderecoDto){
        enderecoValidator = new EnderecoValidator();
        enderecoValidator.validar(enderecoDto);
        Endereco endereco = Mappers.getMapper(EnderecoMapperConverter.class).dtoToEntity(enderecoDto);
        enderecoRepository.save(endereco);

        if(endereco.getLongitude() == null || endereco.getLatitude() == null){
            endereco = geocodingApiService.ajustarLongitudeELatitude(endereco);
        }
    }

    public void removerEndereco(Integer idEndereco){
        final Endereco endereco = enderecoRepository.findById(idEndereco).orElse(null);
        if(endereco != null){
            enderecoRepository.delete(endereco);
        }
            enderecoRepository.deleteAll();
    }

    public EnderecoDto consultarEndereco(Integer idEndereco){
        return Mappers.getMapper(EnderecoMapperConverter.class).entityToDto(enderecoRepository.findById(idEndereco).orElse(null));
    }

    public void editarEndereco(EnderecoDto enderecoDto, Integer idEndereco){
        final Endereco endereco = enderecoRepository.findById(idEndereco).orElse(null);
        if(endereco != null) {

            if (enderecoDto.getRua() != null && enderecoDto.getRua() != "") {
                endereco.setRua(enderecoDto.getRua());
            }
            if (enderecoDto.getNumero() != null && enderecoDto.getNumero() != "") {
                endereco.setNumero(enderecoDto.getNumero());
            }
            if (enderecoDto.getComplemento() != null && enderecoDto.getComplemento() != "") {
                endereco.setComplemento(enderecoDto.getComplemento());
            }
            if (enderecoDto.getBairro() != null && enderecoDto.getBairro() != "") {
                endereco.setBairro(enderecoDto.getBairro());
            }
            if (enderecoDto.getCidade() != null && enderecoDto.getCidade() != "") {
                endereco.setCidade(enderecoDto.getCidade());
            }
            if (enderecoDto.getEstado() != null && enderecoDto.getEstado() != "") {
                endereco.setEstado(enderecoDto.getEstado());
            }
            if (enderecoDto.getPais() != null && enderecoDto.getPais() != "") {
                endereco.setPais(enderecoDto.getPais());
            }
            if (enderecoDto.getCep() != null && enderecoDto.getCep() != "") {
                endereco.setCep(enderecoDto.getCep());
            }
            if (enderecoDto.getLatitude() != null && enderecoDto.getLatitude() != "") {
                endereco.setLatitude(enderecoDto.getLatitude());
            }
            if (enderecoDto.getLongitude() != null && enderecoDto.getLongitude() != "") {
                endereco.setLongitude(enderecoDto.getLongitude());
            }
            enderecoRepository.save(endereco);
        }
    }

}
