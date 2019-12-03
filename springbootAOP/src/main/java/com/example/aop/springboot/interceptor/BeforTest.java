package com.example.aop.springboot.interceptor;

import com.example.aop.springboot.annotation.IAroundTest;
import com.example.aop.springboot.annotation.IBeforTest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforTest {
    @Pointcut("execution(* com.example.aop.springboot..*.*(..)) && @annotation(com.example.aop.springboot.annotation.IBeforTest)")
    public void point() {
    }

    @After("point()")
    public void pointFirst(){
        System.out.println("我是后置增强");
    }

    @Pointcut(value = "execution(* com.example.aop.springboot..*.*(..)) && @annotation(com.example.aop.springboot.annotation.IAfterTest)&& args(name,age)" , argNames = "name,age")
    public void after(String name ,String age) {
    }

    @Before(value = "after(name,age)" ,argNames = "name,age")
    public void afterFirst(String name ,String age){
        System.out.println(" Before " + name  + age);
        System.out.println("我是前置增强");
    }


    @Pointcut(value="execution(* com.example.aop.springboot..*.*(..)) && @annotation(com.example.aop.springboot.annotation.IAroundTest)&& args(name,age)",argNames = "name,age")
    public void around(String name ,String age) {
    }

    @Around(value = "around(name,age)",argNames = "joinPoint,name,age")
    public void aroundFirst(ProceedingJoinPoint joinPoint,String name,String age) throws Throwable {
        System.out.println("我是环绕开始");
        //获取参数
        System.out.println(" " + name  + age);
         for ( int i = 0 ;joinPoint.getArgs().length >i;i++){
             System.out.println( joinPoint.getArgs()[i]);
             joinPoint.getArgs()[i].getClass();
         }
         //执行方法
        joinPoint.proceed();
        System.out.println("我是环绕结束");
    }
}
