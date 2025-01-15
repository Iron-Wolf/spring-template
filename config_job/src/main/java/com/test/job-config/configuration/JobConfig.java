package com.test.job-config.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class JobConfig {

    @JsonProperty
    private Metadata metadata;

    @JsonProperty
    private Database database;

}