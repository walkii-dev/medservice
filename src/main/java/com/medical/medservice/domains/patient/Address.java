package com.medical.medservice.domains.patient;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

}
