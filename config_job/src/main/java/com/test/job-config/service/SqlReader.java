package com.test.job-config.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.test.job-config.dao.BasicRepo;

@Service
@RequiredArgsConstructor
@Slf4j
public class SqlReader {

    private final BasicRepo basicRepo;

    public void reader() {

        basicRepo.getTest();
    }
}
