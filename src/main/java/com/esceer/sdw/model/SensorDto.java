package com.esceer.sdw.model;

import java.time.ZonedDateTime;
import java.util.Objects;

public class SensorDto {

    private final String id;
    private final String name;
    private final Object state;
    private final ZonedDateTime timestamp;

    public SensorDto(String id, String name, Object state, ZonedDateTime timestamp) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Object getState() {
        return state;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SensorDto sensorDto = (SensorDto) o;
        return Objects.equals(id, sensorDto.id) &&
            Objects.equals(name, sensorDto.name) &&
            Objects.equals(state, sensorDto.state) &&
            Objects.equals(timestamp, sensorDto.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SensorDto{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", state=" + state +
            ", timestamp=" + timestamp +
            '}';
    }
}
