package com.esceer.sdw.service;

import com.esceer.sdw.model.Sensor;

import java.util.List;
import java.util.Optional;

public interface SensorService {

    List<Sensor> getAll();

    Optional<Sensor> getById(String id);

    Optional<Sensor> getByName(String name);

    Sensor create(String name, Object state);

    Sensor updateState(String id, Object newState);

    Optional<Sensor> delete(String id);
}
