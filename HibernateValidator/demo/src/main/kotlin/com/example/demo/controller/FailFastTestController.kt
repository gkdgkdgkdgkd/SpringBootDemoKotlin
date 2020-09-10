package com.example.demo.controller

import com.example.demo.entity.User
import com.example.demo.failfast.FailFastValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.ConstraintViolation
import javax.validation.Valid

@RestController
@CrossOrigin("http://localhost:3000")
class FailFastTestController {
    @Autowired
    lateinit var validator:FailFastValidator

    @PostMapping("/failfast/test")
    fun test(@RequestBody @Valid user: User):String
    {
        val message:Set<ConstraintViolation<User>> = validator.validate(user)
        message.forEach { t-> println(t.message) }
        return "test"
    }
}