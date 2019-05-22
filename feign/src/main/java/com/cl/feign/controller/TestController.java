package com.cl.feign.controller;

import com.cl.feign.service.SchedualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private SchedualService schedualService;

    @RequestMapping("hi")
    public String getHi() {
        return schedualService.sayHiFromService1();
    }
}
