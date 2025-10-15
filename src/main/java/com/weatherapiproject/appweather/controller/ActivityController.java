package com.weatherapiproject.appweather.controller;

import com.weatherapiproject.appweather.model.ActivityDTO;
import com.weatherapiproject.appweather.service.ActivityService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/find_activity")
public class ActivityController {

    @Autowired
    ActivityService activityService;


    @GetMapping("/input{cityName}")
    public ActivityDTO findActivity(@RequestParam String cityName){

        return activityService.findActivity(cityName);
    }
}
