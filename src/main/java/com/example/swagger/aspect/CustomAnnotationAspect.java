package com.example.swagger.aspect;

import com.example.swagger.annotation.CustomAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAnnotationAspect {

    @Before("@annotation(annotation)")
    public void before(JoinPoint joinPoint , CustomAnnotation annotation) {
        System.out.println(joinPoint.getSignature().getDeclaringTypeName() +
                "." + joinPoint.getSignature().getName());

    }





}
