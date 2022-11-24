package com.gmit.erp.controller;

import com.gmit.erp.service.TestService;
import com.gmit.erp.vo.TestVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class jstlController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /*@RequestMapping(value="/test")
    public ModelAndView test() throws Exception {
        ModelAndView mav = new ModelAndView("test");
        mav.addObject("name", "HJW");

        List<String> testList = new ArrayList<String>();
        testList.add("A");
        testList.add("B");
        testList.add("C");

        mav.addObject("list", testList);

        return mav;

    }*/

    @Autowired
    TestService testService;

    @RequestMapping(value = "/test")
    public ModelAndView test() throws Exception{
        ModelAndView mav = new ModelAndView("test");

        List<TestVo> testList = testService.selectTest();
        mav.addObject("list", testList);

        logger.trace("Trace level 테스트");
        logger.debug("Debug level 테스트");
        logger.info("Info level 테스트");
        logger.warn("Warn level 테스트");
        logger.error("Error level 테스트");

        return mav;
    }


}
