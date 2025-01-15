package com.test.job-config.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JobException
        extends Exception {

    public JobException(final int exitCode, final String message) {

        super(message);
        log.error(message, this);
        System.exit(exitCode);
    }

    public JobException(final int exitCode, final String message, final Exception e) {

        super(message, e);
        log.error(message, this);
        System.exit(exitCode);
    }
}
