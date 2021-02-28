package com.esceer.sdw.model;

import lombok.Value;

import java.time.ZonedDateTime;

@Value
public class SensorDto {

    String id;
    String name;
    Object state;
    ZonedDateTime timestamp;
}
