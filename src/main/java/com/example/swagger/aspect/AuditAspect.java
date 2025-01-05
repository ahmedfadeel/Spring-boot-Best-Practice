package com.example.swagger.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {
    @Before("execution(* com.example.swagger..services.*.save*(..))")
  //  @Before("execution(* com.example.swagger.service.*.*(..)) ")
    public void audit (JoinPoint joinPoint) {
       // System.out.println("in memthod "+joinPoint.getSignature().getName());

    }






}
