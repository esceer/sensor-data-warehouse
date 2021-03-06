package com.esceer.sdw.configuration;

import com.esceer.sdw.mqtt.SensorMqttListener;
import com.esceer.sdw.service.identifier.IdFactory;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class MqttConfiguration {

    @Value("${mqtt.client-id}")
    private String clientId;

    @Value("${mqtt.uri}")
    private String uri;

    @Value("${mqtt.topic}")
    private String topic;

    @Autowired
    private IdFactory idFactory;

    @Bean(destroyMethod = "disconnect")
    public IMqttClient mqttClient(MqttConnectOptions options, SensorMqttListener listener) throws MqttException {
        var mqttClient = new MqttClient(uri, String.format("%s-%s", clientId, idFactory.generateId()), new MemoryPersistence());
        mqttClient.setTimeToWait(10000);

        mqttClient.connect(options);
        log.info("Client '" + clientId + "' connected to MQTT broker.");

        mqttClient.subscribe(topic, listener);
        log.info("Listener setup on MQTT topic '" + topic + "'");

        return mqttClient;
    }

    @Bean
    public MqttConnectOptions mqttConnectOptions() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1_1);
        return options;
    }
}
