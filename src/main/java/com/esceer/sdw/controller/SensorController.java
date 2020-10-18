package com.esceer.sdw.controller;

import static com.esceer.sdw.controller.converters.SensorDtoConverter.convert;

import com.esceer.sdw.controller.converters.SensorDtoConverter;
import com.esceer.sdw.model.SensorDto;
import com.esceer.sdw.service.SensorService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService service;

    public SensorController(SensorService service) {
        this.service = service;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<SensorDto>> getAllSensors() {
        var sensorDtoList = service.getAll().stream()
            .map(SensorDtoConverter::convert)
            .collect(Collectors.toList());
        return ResponseEntity.ok(sensorDtoList);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SensorDto> getSensor(@PathVariable("id") String id) {
        var sensor = service.getSensorById(id);
        return ResponseEntity.ok(convert(sensor));
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SensorDto> getSensorByName(@PathVariable("name") String name) {
        var sensor = service.getSensorByName(name);
        return ResponseEntity.ok(convert(sensor));
    }

    @PutMapping("/{id}/state/{state}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SensorDto> updateSensor(@PathVariable("id") String id, @PathVariable("state") Object newState) {
        var sensor = service.updateSensorState(id, newState);
        return ResponseEntity.ok(convert(sensor));
    }

    @PostMapping("/{name}/state/{state}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SensorDto> createSensor(@PathVariable("name") String name, @PathVariable("state") Object state) {
        var sensor = service.createSensor(name, state);
        return new ResponseEntity<>(convert(sensor), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SensorDto> deleteSensor(@PathVariable("id") String id) {
        var sensor = service.deleteSensor(id);
        return ResponseEntity.ok(convert(sensor));
    }
}
