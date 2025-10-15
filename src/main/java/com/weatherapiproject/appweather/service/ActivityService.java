package com.weatherapiproject.appweather.service;

import com.weatherapiproject.appweather.model.ActivityDTO;
import com.weatherapiproject.appweather.model.ActivityTypeEnum;
import com.weatherapiproject.appweather.model.WeatherDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final RestTemplate restTemplate;
    @Autowired
    private final MatchingActivity matchingActivity;
    @Autowired
    WeatherService weatherService;


    public ActivityDTO findActivity(String city) {

        WeatherDTO weatherDTO = weatherService.checkWeather(city);


        ActivityTypeEnum activity = matchingActivity.matchingActivity(weatherDTO);
        //System.out.println(activity);

        ActivityDTO[] activities = restTemplate.getForObject("https://bored-api.appbrewery.com/filter?type=" + activity.toString(), ActivityDTO[].class);
        assert activities != null;
        return selectActivity(activities);
    }



    public static ActivityDTO selectActivity (ActivityDTO[] activityDTOS){

        Random random = new Random();
        int optionActivity=random.nextInt(0,activityDTOS.length-1);

        return activityDTOS[optionActivity];
    }

}
