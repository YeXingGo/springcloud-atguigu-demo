package com.atguigu.springcloud.common.aop;

import com.atguigu.springcloud.common.annotation.SystemLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author: Light
 * @ClassName LogAop
 * @description:
 * @create: 2020-09-22 16:24
 **/
@Aspect
@Component
public class LogAop {
 /*   @Pointcut(value = "@annotation(com.atguigu.springcloud.common.annotation.SystemLog)")
    public void pointCut() {

    }*/

    @Pointcut(value = "execution(public * com.atguigu.springcloud.controller.PaymentController.* ())")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        Class clazz = signature.getDeclaringType();
        ArrayList<Class> classList = new ArrayList<>();
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            classList.add(arg.getClass());
        }
        try {
            Method method = clazz.getDeclaredMethod(signature.getName(), classList.toArray(new Class[0]));
            System.out.println(method.getName());
            SystemLog annotation = method.getAnnotation(SystemLog.class);
            System.out.println(annotation.message());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println(signature.getName());
        System.out.println(signature.getDeclaringType());
        System.out.println(signature.getDeclaringTypeName());
        System.out.println(signature.getModifiers());
        System.out.println(joinPoint);


        String kind = joinPoint.getKind();
        System.out.println(kind);
        Object target = joinPoint.getTarget();
        System.out.println(target);
        Object aThis = joinPoint.getThis();
        System.out.println(aThis);
        System.err.println("aThis == target "+ (aThis == target));
        System.err.println("aThis == target  class "+ (aThis.getClass() == target.getClass()));
        System.out.println("================");
    }
}
