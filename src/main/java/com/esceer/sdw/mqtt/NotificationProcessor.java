package com.esceer.sdw.mqtt;

import com.esceer.sdw.service.SensorUpdateEventService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.regex.Pattern;

@Component
public class NotificationProcessor {

    private final String dataPackSeparator;
    private final Pattern keyValuePattern;
    private final SensorUpdateEventService sensorUpdateEventService;

    public NotificationProcessor(@Value("${mqtt.notification.separator.data-pack}") String dataPackSeparator,
                                 @Value("${mqtt.notification.separator.key-value}") String keyValueSeparator,
                                 SensorUpdateEventService sensorUpdateEventService) {
        this.dataPackSeparator = dataPackSeparator;
        this.keyValuePattern = Pattern.compile("^([^" + keyValueSeparator + "]+)" + keyValueSeparator + "(.+)$");
        this.sensorUpdateEventService = sensorUpdateEventService;
    }

    public void processNotification(String notification) {
        Arrays.stream(notification.split(dataPackSeparator)).forEach(keyValueUpdate -> {
            var matcher = keyValuePattern.matcher(keyValueUpdate);
            if (matcher.matches()) {
                var key = matcher.group(1);
                var value = matcher.group(2);
                sensorUpdateEventService.handleSensorUpdateEvent(key, value);
            }
        });
    }
}
