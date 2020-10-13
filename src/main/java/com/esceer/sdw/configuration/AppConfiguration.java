package com.esceer.sdw.configuration;

import com.esceer.sdw.service.identifier.IdFactory;
import com.esceer.sdw.service.identifier.IdGeneratorMode;
import com.esceer.sdw.service.identifier.ShortIdFactoryImpl;
import com.esceer.sdw.service.identifier.UuidFactoryImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public IdFactory idFactory(@Value("${sdw.id-generator-mode}") IdGeneratorMode mode) {
        switch (mode) {
            case SHORT:
                return new ShortIdFactoryImpl();
            case UUID:
                return new UuidFactoryImpl();
            default:
                throw new IllegalArgumentException("Illegal value for id-generator-mode property!");
        }
    }
}
