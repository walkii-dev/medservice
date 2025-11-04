package com.medical.medservice.infra.cep;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.medical.medservice.domain.weather.WeatherResultDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CepResultDTO(
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf,
        WeatherResultDTO clima
) { }
