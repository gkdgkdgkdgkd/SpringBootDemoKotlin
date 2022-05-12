package com.example.demo.custom.controller

import com.example.demo.custom.entity.User
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class CustomController {
    @PostMapping("/custom")
    fun test(@RequestBody @Valid user: User, result: BindingResult) =
        if (!result.hasErrors()) "valid" else StringBuilder().apply {
            result.allErrors.forEach { e ->
                append(e.defaultMessage).append('\n')
            }
        }.toString()
}