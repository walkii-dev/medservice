package com.medical.medservice.infra.cep;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CepResultDTO(
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf
) { }
