package com.taylan.endereco.validator;

import com.taylan.endereco.model.dto.EnderecoDto;

public class EnderecoValidator {

    public void validar(EnderecoDto enderecoDto){
        if(enderecoDto == null){
            throw new RuntimeException("Endereco nao informado");
        }
        if (enderecoDto.getRua() == null ) {
            throw new RuntimeException("Rua nao informada");
        }
        if (enderecoDto.getNumero() == null ) {
            throw new RuntimeException("Numero nao informado");
        }
        if (enderecoDto.getBairro() == null ) {
            throw new RuntimeException("Bairro nao informado");
        }
        if (enderecoDto.getCidade() == null ) {
            throw new RuntimeException("Cidade nao informada");
        }
        if (enderecoDto.getEstado() == null ) {
            throw new RuntimeException("Estado nao informado");
        }
        if (enderecoDto.getPais() == null ) {
            throw new RuntimeException("Pais nao informado");
        }
        if (enderecoDto.getCep() == null ) {
            throw new RuntimeException("Cep nao informado");
        }
    }
}
