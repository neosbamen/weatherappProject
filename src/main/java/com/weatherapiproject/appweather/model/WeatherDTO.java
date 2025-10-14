package com.weatherapiproject.appweather.model;

import lombok.Data;

@Data
public class WeatherDTO {

    private LocationDTO location;
    private  CurrentDTO current;

}
