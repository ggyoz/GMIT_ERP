package com.gmit.erp.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

@Transactional
@Slf4j
public class TestJpaRestControllerTest {

    @Value("${testId}")
    private String testId;
    @Value("${testName}")
    private String testName;

    @Autowired
    MockMvc mvc;

    @Test
    void getMember() throws Exception {

        log.info("##### Properties 테스트 #####");
        log.info("test id : " + testId);
        log.info("test Name : " + testName);

    }
}