package com.example.swagger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private  AopService aopService;




    @Override
    public void run(String... args) throws Exception {
        aopService.testOne();
        aopService.testTwo();


    }
}
