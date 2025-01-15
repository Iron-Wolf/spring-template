package com.test.job-config.configuration;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.test.job-config.exception.ConfigException;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class DataSourceLoader {

    private final JobConfig jobConfig;
    @Value("${spring.application.name}")
    private String appname;

    @Bean
    public DataSource getDataSource()
            throws ConfigException {

        final String url = String.format("%s&ApplicationName=%s",
                                         jobConfig.getDatabase().getDatasource(),
                                         appname);
        log.info("Url de la BDD : {}", url);
        DataSource dataSource = DataSourceBuilder
                .create()
                .url(url)
                .username("postgres")
                .build();
        try (final Connection ignored = dataSource.getConnection()) {
            log.info("Accès BDD OK");
        } catch (SQLException e) {
            throw new ConfigException("La BDD ne semble pas accessible", e);
        }

        return dataSource;
    }

}