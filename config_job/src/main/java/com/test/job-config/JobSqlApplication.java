package com.test.job-config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;

import com.test.job-config.service.SqlReader;

@SpringBootApplication
@RequiredArgsConstructor
public class JobSqlApplication
        implements CommandLineRunner {

    private final SqlReader sqlReader;

    public static void main(String[] args) {

        SpringApplication.run(JobSqlApplication.class, args);
    }

    @Override
    public void run(String... strings)
            throws Exception {
        // exec de la requête SQL
        sqlReader.reader();
    }

}
