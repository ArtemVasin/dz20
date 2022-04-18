package com.artemvasin.spring.boot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExampleAspect {
    @Before("@annotation(com.artemvasin.spring.boot.annotation.LogMethod)")
    public void logMethod(JoinPoint point) {
        String metod = point.getSignature().getName();
        Object[] args = point.getArgs();

        System.out.println("metod " + metod);
        System.out.println("parametr " + args);
    }

    @Around("@annotation(com.artemvasin.spring.boot.annotation.WorkTime)")
    public void workTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        String metod = joinPoint.getSignature().getName();
        System.out.println(" Metod " + metod);
        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
    }
}




















//34543