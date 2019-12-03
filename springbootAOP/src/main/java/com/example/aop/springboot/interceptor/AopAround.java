package com.example.aop.springboot.interceptor;

import com.example.aop.springboot.vail.ParamCheck;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;



@Aspect
@Component
public class AopAround {

    @Around(value = "around1()")
    public void aroundFirst(ProceedingJoinPoint joinPoint)  {
        System.out.println("我是环绕开始11");

        Signature s = joinPoint.getSignature();
        MethodSignature ms = (MethodSignature)s;
        Method m = ms.getMethod();
        for ( int i = 0 ;joinPoint.getArgs().length >i;i++){
            ParamCheck p = findParamAnnotation(m,i);
            if(p!=null) {
                System.out.println(p.Length());
                System.out.println(p.max());
                System.out.println(p.min());
                System.out.println(p.defaultValue());
            }
        }
        //获取参数
        /*for ( int i = 0 ;joinPoint.getArgs().length >i;i++){
            //System.out.println( joinPoint.getArgs()[i]);
            Class<?> c = joinPoint.getArgs()[i].getClass();
            if(c.isAnnotationPresent(ParamCheck.class)){
                c.getAnnotations();
            }
        }*/
        //执行方法
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("我是环绕结束11");
    }

    private ParamCheck findParamAnnotation(Method providerMethod, int parameterIndex) {
        final Object[] annotations = providerMethod.getParameterAnnotations()[parameterIndex];
        ParamCheck param = null;
        for (Object annotation : annotations) {
            if (annotation instanceof ParamCheck) {
                param = ParamCheck.class.cast(annotation);
                break;
            }
        }
        return param;
    }


    @Pointcut(value="@annotation(com.example.aop.springboot.annotation.IAroundTest)")
    public void around1() {
    }
}
