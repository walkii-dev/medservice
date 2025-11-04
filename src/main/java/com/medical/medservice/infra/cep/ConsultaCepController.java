package com.medical.medservice.infra.cep;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consulta")
public class ConsultaCepController {

    @GetMapping("{cep}")
    public CepResultDTO consultaCep (@PathVariable String cep){
        RestTemplate template = new RestTemplate();
        ResponseEntity<CepResultDTO> response = template.getForEntity(
                String.format("https://viacep.com.br/ws/%s/json/",cep), CepResultDTO.class);
        return response.getBody();
    }

}
