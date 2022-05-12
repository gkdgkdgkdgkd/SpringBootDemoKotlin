package com.example.demo.aop.validator

import com.example.demo.aop.annotation.MyEmail
import com.example.demo.aop.annotation.MyPhone
import com.example.demo.aop.entity.User
import com.example.demo.aop.exception.EmailException
import com.example.demo.aop.exception.PhoneException
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component
import java.util.TreeMap

@Aspect
@Component
class UserValidator {
    @Pointcut("@annotation(com.example.demo.aop.annotation.UserValidate)")
    fun userValidate() {
    }

    @Before("userValidate()")
    fun validate(point: JoinPoint) {
        val user = point.args[0] as User
        val treeMap = TreeMap<Int, Annotation>()
        val allFields = HashMap<Int, Any>()
        user.javaClass.declaredFields.forEach { field ->
            field.isAccessible = true
            field.annotations.forEach { annotation ->
                when (annotation) {
                    is MyEmail -> {
                        treeMap[annotation.order] = annotation
                        allFields[annotation.order] = field.get(user)
                    }
                    is MyPhone -> {
                        treeMap[annotation.order] = annotation
                        allFields[annotation.order] = field.get(user)
                    }
                }
            }
        }

        treeMap.forEach { entry ->
            when (entry.value) {
                is MyEmail -> validateEmail(allFields[entry.key] as String)
                is MyPhone -> validatePhone(allFields[entry.key] as String)
            }
        }
    }

    fun validateEmail(email: String) {
        val errorMessage = if (email.isBlank()) "邮箱为空" else
            if (!email.contains("@")) "邮箱格式错误" else ""
        if (errorMessage.isNotEmpty()) {
            throw EmailException(errorMessage)
        }
    }

    fun validatePhone(phone: String) {
        val errorMessage = if (phone.isBlank()) "电话为空" else
            if (!phone.startsWith("+86")) "请使用+86开头的手机号" else ""
        if (errorMessage.isNotEmpty()) {
            throw PhoneException(errorMessage)
        }
    }
}