package com.example.swagger.service;


import com.example.swagger.annotation.CustomAnnotation;
import org.springframework.stereotype.Service;

@Service
public class AopService {

    @CustomAnnotation
    public void testOne(){

    }
    @CustomAnnotation
    public void testTwo(){  }


}
