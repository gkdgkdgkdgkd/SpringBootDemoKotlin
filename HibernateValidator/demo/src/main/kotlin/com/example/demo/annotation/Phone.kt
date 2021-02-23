package com.example.demo.annotation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
@MustBeDocumented
@Constraint(validatedBy = [PhoneValidator::class])
annotation class Phone(val message:String = "电话不能为空而且需要合法", val groups: Array<KClass<*>> = [], val payload:Array<KClass<*>> = [])