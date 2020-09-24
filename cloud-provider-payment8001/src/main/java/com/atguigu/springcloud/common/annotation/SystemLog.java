package com.atguigu.springcloud.common.annotation;

import java.lang.annotation.*;

/**
 * @author Light
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemLog {

    String message () default  "";
}
