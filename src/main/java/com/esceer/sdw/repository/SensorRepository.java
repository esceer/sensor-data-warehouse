package com.esceer.sdw.repository;

import com.esceer.sdw.model.Sensor;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends MongoRepository<Sensor, String> {

    Optional<Sensor> findByName(String name);
}
