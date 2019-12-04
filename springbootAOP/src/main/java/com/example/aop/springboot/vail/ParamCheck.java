package com.example.aop.springboot.vail;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamCheck {

    int Length() default 9999;
    String max()  default "";
    String min() default "";
    String defaultValue() default "";


}
