package com.example.demo.failfast.controller

import com.example.demo.failfast.entity.User
import com.example.demo.failfast.validator.FailFastValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class FailFastController {
    @Autowired
    private lateinit var validator: FailFastValidator

    @PostMapping("/failfast")
    fun test(@RequestBody user: User): String = validator.validate(user).let {
        if(it.isEmpty()) "valid" else it.stream().findFirst().get().message
    }
}