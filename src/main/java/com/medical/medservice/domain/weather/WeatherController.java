package com.medical.medservice.domain.weather;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/clima")
public class WeatherController {


        @GetMapping("{cidade}")
        public WeatherResultDTO consultaCep (@PathVariable String cep){
            RestTemplate template = new RestTemplate();
            ResponseEntity<WeatherResultDTO> response = template.getForEntity(
                    String.format("http://api.weatherapi.com/v1/forecast.json?key=2062d21d116845be8c4165431250311&q=Niteroi&days=1&aqi=no&alerts=no",cep), WeatherResultDTO.class);
            return response.getBody();


    }
}
