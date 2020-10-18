package com.esceer.sdw.service;

import com.esceer.sdw.model.Sensor;
import java.util.List;

public interface SensorService {

    List<Sensor> getAll();

    Sensor getSensorById(String id);

    Sensor getSensorByName(String name);

    Sensor createSensor(String name, Object state);

    Sensor updateSensorState(String id, Object newState);

    Sensor deleteSensor(String id);
}
