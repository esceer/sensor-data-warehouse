package com.esceer.sdw.repository;

import com.esceer.sdw.model.Sensor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorRepository extends MongoRepository<Sensor, String> {

    Optional<Sensor> findByName(String name);

    boolean existsByName(String name);
}
