package com.test.job-config.exception;

public class ConfigException
        extends JobException {

    private static final int EXIT_CODE = 1;

    public ConfigException(final String message) {

        super(EXIT_CODE, message);
    }

    public ConfigException(final String message, final Exception e) {

        super(EXIT_CODE, message, e);
    }

}
