package com.example.demo.failfast

import com.example.demo.entity.User
import org.hibernate.validator.HibernateValidator
import org.springframework.context.annotation.Configuration
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

    fun validate(user:User) = validator.validate(user)
}