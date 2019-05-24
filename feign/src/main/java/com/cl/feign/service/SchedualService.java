package com.cl.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service1", fallback = SchedualServiceHiHystric.class)
public interface SchedualService {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromService1();

}