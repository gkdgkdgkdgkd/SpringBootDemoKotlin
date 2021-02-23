package com.example.demo.annotation

import java.util.regex.Pattern
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class PhoneValidator:ConstraintValidator<Phone,String>{
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value != null) {
            if(value.length != 11)
                return false
        }
        return Pattern.matches("^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$",value)
    }
}