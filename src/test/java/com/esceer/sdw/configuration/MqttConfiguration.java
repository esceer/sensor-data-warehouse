package com.esceer.sdw.configuration;

import com.esceer.sdw.mqtt.SensorMqttListener;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class MqttConfiguration {

    @Bean
    public IMqttClient mqttClient(MqttConnectOptions options, SensorMqttListener listener) {
        return mock(IMqttClient.class);
    }

    @Bean
    public MqttConnectOptions mqttConnectOptions() {
        return mock(MqttConnectOptions.class);
    }
}
