package com.taylan.endereco.service;

import com.taylan.endereco.model.entity.Endereco;
import com.taylan.endereco.model.geocoding.dto.LocalidadeDto;
import com.taylan.endereco.model.geocoding.dto.ResultDto;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GeocodingApiService {

    private final String BASE_URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";

    private final String BASE_KEY = "&key=AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw";

    private String BASE_ENDERECO;

    public Endereco ajustarLongitudeELatitude(Endereco endereco){
        formatarEndereco(endereco);
        RestTemplate restTemplate = new RestTemplate();
        final String url = BASE_URL + BASE_ENDERECO + BASE_KEY;
        final ResponseEntity<LocalidadeDto> response = restTemplate.exchange(url, HttpMethod.GET, null, LocalidadeDto.class);
        LocalidadeDto localidade = response.getBody();
        Double longitude = localidade.getResults().get(0).getGeometry().getLocation().getLng();
        Double latitude = localidade.getResults().get(0).getGeometry().getLocation().getLat();
        endereco.setLatitude(latitude.toString());
        endereco.setLongitude(longitude.toString());
        return endereco;
    }

    private void formatarEndereco(Endereco endereco){
        BASE_ENDERECO = endereco.getRua() + ","
                + endereco.getNumero()
                + "," + endereco.getBairro()
                + "," + endereco.getCidade()
                + "," + endereco.getEstado()
                + "," + endereco.getCep()
                + "," + endereco.getPais();
    }
}
