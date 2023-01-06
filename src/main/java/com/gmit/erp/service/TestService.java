package com.gmit.erp.service;

import com.gmit.erp.mapper.TestMapper;
import com.gmit.erp.vo.TestVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    public TestMapper mapper;

    public List<TestVo> selectTest(){

        logger.trace("Trace level 테스트");
        logger.debug("Debug level 테스트");
        logger.info("Info level 테스트");
        logger.warn("Warn level 테스트");
        logger.error("Error level 테스트");

        return mapper.selectTest();
    }
}
