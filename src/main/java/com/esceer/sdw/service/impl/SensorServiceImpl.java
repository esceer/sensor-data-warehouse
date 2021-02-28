package com.esceer.sdw.service.impl;

import com.esceer.sdw.model.Sensor;
import com.esceer.sdw.repository.SensorRepository;
import com.esceer.sdw.service.SensorService;
import com.esceer.sdw.service.identifier.IdFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SensorServiceImpl implements SensorService {

    private final SensorRepository repository;
    private final IdFactory idFactory;

    @Override
    public List<Sensor> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Sensor> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Sensor> getByName(String name) {
        return repository.findByName(name);
    }


    @Override
    public Sensor create(String name, Object state) {
        if (repository.existsByName(name)) {
            throw new IllegalArgumentException("Sensor '{}' already exists");
        } else {
            var sensor = new Sensor(idFactory.generateId(), name, state, ZonedDateTime.now(Clock.systemUTC()));
            return repository.insert(sensor);
        }
    }

    @Override
    public Sensor updateState(String id, Object newState) {
        var sensor = getById(id).orElseThrow();
        sensor.setState(newState);
        sensor.setTimestamp(ZonedDateTime.now(Clock.systemUTC()));
        return repository.save(sensor);
    }

    @Override
    public Optional<Sensor> delete(String id) {
        var sensor = getById(id);
        sensor.ifPresent(repository::delete);
        return sensor;
    }
}
