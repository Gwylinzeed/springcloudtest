package com.cl.consumer_ribbon.controller;

import com.cl.consumer_ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/getHi")
    public String hi(){
        return helloService.hiService();
    }

}
