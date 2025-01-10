package com.example.swagger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {


    private final   AopService aopService;

    public Runner ( AopService aopService ) {
        this.aopService=aopService;
    }


    @Override
    public void run(String... args) throws Exception {
        aopService.testOne();
        aopService.testTwo();


    }
}
