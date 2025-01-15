package com.test.job-config.configuration;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import com.test.job-config.exception.ConfigException;

@Configuration
public class JobConfigLoader {

    @Value("${job.config-file}")
    private String configFile;

    @Bean
    public JobConfig getJobConfig()
            throws ConfigException {

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(configFile)) {
            if (inputStream == null) {
                throw new ConfigException("Config file not found: " + configFile);
            }
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            return objectMapper.readValue(inputStream, JobConfig.class);
        } catch (IOException e) {
            throw new ConfigException("Failed to load config file: " + configFile, e);
        }
    }

}