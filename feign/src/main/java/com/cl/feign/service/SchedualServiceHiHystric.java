package com.cl.feign.service;


import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SchedualService{

    @Override
    public String sayHiFromService1() {
        return "sorry,I have a problem!";
    }
}
