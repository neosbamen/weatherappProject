package com.weatherapiproject.appweather.model;

import lombok.Data;

@Data
public class LocationDTO {

    private String name;
    private String region;
    private String country;
    private double lat;
    private double lon;
    private String tz_id;
    private long localtime_epoch;
    private String localtime;
}
