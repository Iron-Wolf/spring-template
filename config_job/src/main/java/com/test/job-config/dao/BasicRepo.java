package com.test.job-config.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.test.job-config.configuration.JobConfig;

@Slf4j
@RequiredArgsConstructor
@Repository
public class BasicRepo {

    private final JobConfig jobConfig;
    private final JdbcTemplate jdbcTemplate;

    public void getTest() {
        log.info("repo: {}", jobConfig.getMetadata().getFilename());
        final String sql = """
                SELECT id from schema.table
                """;

        jdbcTemplate.query(sql, mapper);
    }

    private final RowMapper<Object> mapper = (rs, rowNum) -> {
        System.out.println("row mapper : " + rs.getString(1));
        return null;
    };
}
