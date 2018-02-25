package com.javaadvanced.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by Wentao Qian on 11/17/2017.
 */
@Aspect
public class MethodTimingProfile {
//    @Pointcut("@annotation(com.javaadvanced.util.Timer) && execution(* *.*(..))")
//    public void myPointCut() {}
//
//    @Around("myPointCut()")
    @Around("execution(* *(..)) && @annotation(Timer)")
    public Object logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        final long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        final long executionTime = System.currentTimeMillis() - start;
        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }

//    @Pointcut("execution(* *.*(..))")
//    void anyMethodCall() {
//    }

//    @Before("anyMethodCall()")
//    public void beforeMethod() {
//        System.out.println("Aspect Before Method");
//    }

}
