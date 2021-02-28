package com.esceer.sdw.service.impl;

import com.esceer.sdw.service.SensorService;
import com.esceer.sdw.service.SensorUpdateEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SensorUpdateEventServiceImpl implements SensorUpdateEventService {

    private final SensorService sensorService;

    public void handleSensorUpdateEvent(String sensorName, Object sensorValue) {
        sensorService.getByName(sensorName).ifPresentOrElse(
                sensor -> sensorService.updateState(sensor.getId(), sensorValue),
                () -> sensorService.create(sensorName, sensorValue)
        );
    }
}
