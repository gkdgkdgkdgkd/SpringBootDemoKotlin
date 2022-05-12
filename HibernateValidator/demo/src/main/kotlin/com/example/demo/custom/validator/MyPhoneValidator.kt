package com.example.demo.custom.validator

import com.example.demo.custom.annotation.MyPhone
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class MyPhoneValidator : ConstraintValidator<MyPhone, String> {
    override fun isValid(value: String, context: ConstraintValidatorContext) =
        value.startsWith("+86")
}