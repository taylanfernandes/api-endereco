package com.taylan.endereco.model.dto;

import lombok.*;

@Getter
@Setter
public class EnderecoDto {

    private Integer id;

    private String rua;

    private String numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String estado;

    private String pais;

    private String cep;

    private String latitude;

    private String longitude;
}
