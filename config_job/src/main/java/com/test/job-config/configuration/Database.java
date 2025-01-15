package com.test.job-config.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Database {

    @JsonProperty
    private String datasource;

}
