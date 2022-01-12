package com.taylan.endereco.model.geocoding.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
public class LocationDto {

    private Double lat;

    private Double lng;

}
