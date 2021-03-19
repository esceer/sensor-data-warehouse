package com.esceer.sdw.mqtt;

import com.esceer.sdw.service.SensorUpdateEventService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class NotificationProcessor {

    private final Pattern topicPattern;
    private final SensorUpdateEventService sensorUpdateEventService;

    public NotificationProcessor(@Value("${mqtt.notification.regex-matcher.sensor-name}") String sensorNamePattern,
                                 SensorUpdateEventService sensorUpdateEventService) {
        this.topicPattern = Pattern.compile(sensorNamePattern);
        this.sensorUpdateEventService = sensorUpdateEventService;
    }

    public void processNotification(String topic, String sensorValue) {
        var matcher = topicPattern.matcher(topic);
        if (matcher.matches()) {
            var sensorName = matcher.group(1);
            sensorUpdateEventService.handleSensorUpdateEvent(sensorName, sensorValue);
        }
    }
}
