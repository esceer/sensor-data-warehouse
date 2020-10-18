package com.esceer.sdw.service;

import com.esceer.sdw.model.Sensor;
import com.esceer.sdw.repository.SensorRepository;
import com.esceer.sdw.service.identifier.IdFactory;
import java.time.Clock;
import java.time.ZonedDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SensorServiceImpl implements SensorService {

    private final SensorRepository repository;
    private final IdFactory idFactory;

    public SensorServiceImpl(SensorRepository repository, IdFactory idFactory) {
        this.repository = repository;
        this.idFactory = idFactory;
    }

    @Override
    public List<Sensor> getAll() {
        return repository.findAll();
    }

    @Override
    public Sensor getSensorById(String id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Sensor getSensorByName(String name) {
        return repository.findByName(name).orElseThrow();
    }

    @Override
    public Sensor createSensor(String name, Object state) {
        if (repository.findByName(name).isPresent()) {
            throw new IllegalArgumentException("Sensor '{}' already exists");
        } else {
            var sensor = new Sensor(idFactory.generateId(), name, state, ZonedDateTime.now(Clock.systemUTC()));
            return repository.insert(sensor);
        }
    }

    @Override
    public Sensor updateSensorState(String id, Object newState) {
        var sensor = getSensorById(id);
        sensor.setState(newState);
        sensor.setTimestamp(ZonedDateTime.now(Clock.systemUTC()));
        return repository.save(sensor);
    }

    @Override
    public Sensor deleteSensor(String id) {
        var sensor = getSensorById(id);
        repository.delete(sensor);
        return sensor;
    }
}
