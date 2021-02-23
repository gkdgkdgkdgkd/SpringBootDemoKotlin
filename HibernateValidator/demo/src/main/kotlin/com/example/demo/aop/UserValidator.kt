package com.example.demo.aop

import org.aopalliance.intercept.Joinpoint
import org.aspectj.lang.annotation.*
import org.springframework.stereotype.Component

//@Aspect
//@Component
//@Open
//class UserValidator
//{
//    @Pointcut("@annotation(com.example.demo.aop.UserValidate)")
////    @Pointcut("execution(public * com.example.demo.controller.TestController.*.*(..))")
//    fun userValidate(){}
//
//    @Before("userValidate() && args(joinPoint)")
////    @AfterReturning(value = "userValidate()",argNames = "joinPoint")
////    @Around("@annotation(com.example.demo.aop.UserValidate) && args(joinPoint)")
//    fun validate(joinPoint: Joinpoint):Any
//    {
//        println("111")
//        return ""
//    }
//}