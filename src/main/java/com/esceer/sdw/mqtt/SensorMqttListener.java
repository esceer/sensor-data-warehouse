package com.esceer.sdw.mqtt;

import lombok.RequiredArgsConstructor;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;

import static java.nio.charset.StandardCharsets.UTF_8;

@Component
@RequiredArgsConstructor
public class SensorMqttListener implements IMqttMessageListener {

    private final NotificationProcessor notificationProcessor;

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) {
        var sensorUpdateNotification = new String(mqttMessage.getPayload(), UTF_8);
        notificationProcessor.processNotification(topic, sensorUpdateNotification);
    }
}

