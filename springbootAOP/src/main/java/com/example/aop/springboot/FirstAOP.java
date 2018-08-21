package com.example.aop.springboot;

import com.example.aop.springboot.annotation.IAfterTest;
import com.example.aop.springboot.annotation.IAroundTest;
import com.example.aop.springboot.annotation.IBeforTest;
import org.aspectj.lang.annotation.After;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import javax.naming.Name;


@EnableAspectJAutoProxy
@ComponentScan({"com.example.aop.springboot.test","com.example.aop.springboot.interceptor"})
@Component
public class FirstAOP {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(FirstAOP.class);
        FirstAOP firstAOP= (FirstAOP) annotationConfigApplicationContext.getBean("firstAOP");
        firstAOP.pringTest("测试","20");
    }


    //@IBeforTest
    //@IAfterTest
//    @IAroundTest(Name = "#Name",Age = "#{age}")
    @IAroundTest
    public void pringTest(String name,String age){
        System.out.println("我是方法");
    }
}
