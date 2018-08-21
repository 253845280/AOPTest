package com.example.aop;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;



@EnableAspectJAutoProxy
@ComponentScan({"com.example.aop.test","com.example.aop.annotation","com.example.aop.interceptor"})
@Component
public class FirstAOP {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(FirstAOP.class);
        FirstAOP firstAOP= (FirstAOP) annotationConfigApplicationContext.getBean("firstAOP");
        firstAOP.pringTest();
    }


    public void pringTest(){
        System.out.println("我是方法");
    }
}
