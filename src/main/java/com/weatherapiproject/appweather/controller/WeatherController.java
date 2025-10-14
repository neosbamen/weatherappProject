package com.weatherapiproject.appweather.controller;

import com.weatherapiproject.appweather.model.WeatherDTO;
import com.weatherapiproject.appweather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather_check")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/current{cityName}")
    public WeatherDTO checkWeather(@RequestParam String cityName){

        return weatherService.checkWeather(cityName);

    }
}
