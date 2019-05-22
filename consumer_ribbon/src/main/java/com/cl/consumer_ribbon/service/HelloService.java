package com.cl.consumer_ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;
    public String hiService(){
        //这里ip位置需要写服务提供者的application name
        return restTemplate.getForObject("http://service1/hi", String.class);
    }
}
