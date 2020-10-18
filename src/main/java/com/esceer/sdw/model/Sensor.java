package com.esceer.sdw.model;

import java.util.Objects;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.MongoId;

public class Sensor {

    @MongoId
    private String id;

    @Indexed(unique = true)
    private String name;
    private Object state;

    public Sensor() {
    }

    public Sensor(String id, String name, Object state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sensor sensor = (Sensor) o;
        return Objects.equals(id, sensor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Sensor{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", state=" + state +
            '}';
    }
}
