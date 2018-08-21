package com.example.aop.interceptor;

import com.example.aop.annotation.IAfterTest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Aspect
@Component
public class BeforTest {
    @Pointcut("execution(* com.example.aop..*.*(..))")
    public void point() {
    }

    @Before("point()")
    public void pointFirst(){
        System.out.println("我是增强");
    }
}
