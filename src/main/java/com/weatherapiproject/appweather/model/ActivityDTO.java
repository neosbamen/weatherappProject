package com.weatherapiproject.appweather.model;

import lombok.Data;

@Data
public class ActivityDTO {

    private String activity;
    private double availability;
    private String type;
    private int participants;
    private double price;
    private String accessibility;
    private String duration;
    private boolean kidFriendly;
    private String link;
    private String key;
}
