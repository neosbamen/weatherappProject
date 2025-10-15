package com.weatherapiproject.appweather.service;

import com.weatherapiproject.appweather.model.ActivityTypeEnum;
import com.weatherapiproject.appweather.model.WeatherDTO;
import org.springframework.stereotype.Service;

@Service
public class MatchingActivity {

    public ActivityTypeEnum matchingActivity(WeatherDTO weatherDTO){


        String weatherDescription = weatherDTO.getCurrent().getCondition().getText();

        return switch (weatherDescription) {
            case "Sunny", "Clear" -> ActivityTypeEnum.recreational;
            case "Partly cloudy"  -> ActivityTypeEnum.social;
            case "Light rain", "Light rain shower", "Moderate rain", "Patchy rain nearby" , "Moderate or heavy rain with thunder"-> ActivityTypeEnum.education;
            case "Mist", "Haze", "Fog" -> ActivityTypeEnum.relaxation;
            case "Overcast" -> ActivityTypeEnum.busywork;
            default -> throw new IllegalStateException("Unexpected value: " + weatherDescription);

        };
    }
}
