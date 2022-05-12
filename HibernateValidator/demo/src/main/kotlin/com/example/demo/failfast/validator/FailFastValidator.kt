package com.example.demo.failfast.validator

import com.example.demo.failfast.entity.User
import org.hibernate.validator.HibernateValidator
import org.springframework.context.annotation.Configuration
import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator

@Configuration
class FailFastValidator {
    private final val validator: Validator = Validation
        .byProvider(HibernateValidator::class.java)
        .configure()
        .failFast(true)
        .buildValidatorFactory()
        .validator

    fun validate(user: User): Set<ConstraintViolation<User>> = validator.validate(user)
}