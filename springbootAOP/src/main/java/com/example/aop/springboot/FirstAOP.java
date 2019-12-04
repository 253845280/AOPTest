package com.example.aop.springboot;

import com.example.aop.springboot.annotation.IAroundTest;
import com.example.aop.springboot.test.TestClass;
import com.example.aop.springboot.vail.ParamCheck;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;


@EnableAspectJAutoProxy
@ComponentScan({"com.example.aop.springboot.test","com.example.aop.springboot.interceptor"})
@Component
public class FirstAOP {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(FirstAOP.class);
        FirstAOP firstAOP= (FirstAOP) annotationConfigApplicationContext.getBean("firstAOP");
        //firstAOP.pringTest("测试","20");
        TestClass<String> t = new TestClass<>();
        t.setAdd(1);
        t.setTime(new Date());
        t.setStr("str");
        firstAOP.pringTest(t);
    }


    //@IBeforTest
    //@IAfterTest
//    @IAroundTest(Name = "#Name",Age = "#{age}")
    @IAroundTest
    public void pringTest(@ParamCheck(Length = 10,max = "123name",min = "22name")String name,@ParamCheck(Length = 20,max = "123age",min = "22age") String age){
        System.out.println("我是方法");
    }


    @IAroundTest
    public void pringTest(TestClass<String> t){
        System.out.println("我是方法543");
    }



}
