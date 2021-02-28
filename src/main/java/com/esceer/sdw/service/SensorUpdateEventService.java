package com.esceer.sdw.service;

public interface SensorUpdateEventService {

    void handleSensorUpdateEvent(String sensorName, Object sensorValue);
}
