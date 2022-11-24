package com.gmit.erp.controller;

import com.gmit.erp.vo.TestVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class thymeleafController {

    @RequestMapping(value="/thymeleafTest")
    public String thymeleafTest(Model model) {

        TestVo testModel = new TestVo("goddaehee", "갓대희");
        model.addAttribute("testModel", testModel);

        return "thymeleaf/thymeleafTest";

    }
}
