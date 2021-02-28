package com.esceer.sdw.mqtt;

import com.esceer.sdw.service.SensorUpdateEventService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.regex.Pattern;

@Component
public class NotificationProcessor {

    private final String innerMessageBorderSeparator;
    private final Pattern keyValuePattern;
    private final SensorUpdateEventService sensorUpdateEventService;

    public NotificationProcessor(@Value("${mqtt.notification.separator.inner-message-border}") String innerMessageBorderSeparator,
                                 @Value("${mqtt.notification.separator.key-value}") String keyValueSeparator,
                                 SensorUpdateEventService sensorUpdateEventService) {
        this.innerMessageBorderSeparator = innerMessageBorderSeparator;
        this.keyValuePattern = Pattern.compile("^([^" + keyValueSeparator + "]+)" + keyValueSeparator + "(.+)$");
        this.sensorUpdateEventService = sensorUpdateEventService;
    }

    public void processNotification(String notification) {
        Arrays.stream(notification.split(innerMessageBorderSeparator)).forEach(keyValueUpdate -> {
            var matcher = keyValuePattern.matcher(keyValueUpdate);
            if (matcher.matches()) {
                var key = matcher.group(1);
                var value = matcher.group(2);
                sensorUpdateEventService.handleSensorUpdateEvent(key, value);
            }
        });
    }
}
