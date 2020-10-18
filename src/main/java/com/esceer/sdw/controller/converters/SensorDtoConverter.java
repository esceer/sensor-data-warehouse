package com.esceer.sdw.controller.converters;

import com.esceer.sdw.model.Sensor;
import com.esceer.sdw.model.SensorDto;

public final class SensorDtoConverter {

    public static SensorDto convert(Sensor sensor) {
        return new SensorDto(sensor.getId(), sensor.getName(), sensor.getState(), sensor.getTimestamp());
    }

    private SensorDtoConverter() {
        throw new UnsupportedOperationException();
    }
}
