package com.esceer.sdw.model;

import java.util.Objects;

public class SensorDto {

    private final String id;
    private final String name;
    private final Object state;

    public SensorDto(String id, String name, Object state) {
        this.id = id;
        this.name = name;
        this.state = state;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SensorDto sensorDto = (SensorDto) o;
        return Objects.equals(id, sensorDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SensorDto{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", state=" + state +
            '}';
    }
}
