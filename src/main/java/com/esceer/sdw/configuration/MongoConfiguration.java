package com.esceer.sdw.configuration;

import com.esceer.sdw.repository.converters.DateToZonedDateTimeConverter;
import com.esceer.sdw.repository.converters.ZonedDateTimeToDateConverter;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

@Configuration
public class MongoConfiguration {

    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(List.of(
            new ZonedDateTimeToDateConverter(),
            new DateToZonedDateTimeConverter()
        ));
    }
}
