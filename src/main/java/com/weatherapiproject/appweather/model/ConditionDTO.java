package com.weatherapiproject.appweather.model;

import lombok.Data;

@Data
public class ConditionDTO {

    private String text;
    private String icon;
    private long code;
}
