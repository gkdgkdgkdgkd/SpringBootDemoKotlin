package com.example.demo.controller

import com.example.demo.entity.User
import com.example.demo.failfast.FailFastValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("http://localhost:3000")
class TestController {
    @PostMapping("/test")
    fun test(@RequestBody user: User):String
    {
//        val errors = result.allErrors
//        for (error in errors) {
//            if(error.defaultMessage == null)
//                return "true"
//            return error.defaultMessage!!
//        }
        return "true"
    }
}