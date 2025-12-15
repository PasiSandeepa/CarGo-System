package edu.icet.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NamingConventions;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ModelMapper getMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setSourceNamingConvention(NamingConventions.NONE) // JSON fields snake_case නම්
                .setDestinationNamingConvention(NamingConventions.JAVABEANS_MUTATOR)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper;
    }
}
