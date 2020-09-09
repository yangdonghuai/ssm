package com.xtkj.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AspMsg {

    @Before("execution(* com.xtkj.service.impl.*.*(..))")
    public void before(){
        System.out.println("前置通知-------------------------");
    }

    @After("execution(* com.xtkj.service.impl.*.*(..))")
    public void after(){
        System.out.println("后置通知-------------------------");
    }

    @Around("execution(* com.xtkj.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        System.out.println("方法执行前++++++++");
        Object proceed = point.proceed();
        System.out.println("方法执行后++++++++");
        return proceed;
    }

    @AfterThrowing(value = "execution(* com.xtkj.service.impl.*.*(..))",throwing = "e")
    public void exceptions(Exception e){
        log.info(e.getMessage(),e);
    }

}
