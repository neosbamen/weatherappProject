package com.weatherapiproject.appweather.service;

import com.weatherapiproject.appweather.model.WeatherDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WeatherService {

    @Value("${base.url.weather.api}")
    private String baseUrl;
    @Value("${apikey.weather.api}")
    private String apiKey;


    private final RestTemplate restTemplate;


    public WeatherDTO checkWeather(String cityName){

        String urlFinal=baseUrl+apiKey+"&q="+cityName;

        return restTemplate.getForObject(urlFinal,WeatherDTO.class);
    }



}
