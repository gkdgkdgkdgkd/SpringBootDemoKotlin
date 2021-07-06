package com.example.demo.test.controller

import com.example.demo.test.entity.User
import com.example.demo.test.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test/user")
class UserController {
    @Autowired
    lateinit var userService: UserService

    @GetMapping("/write")
    fun write() = userService.save(User(3,"123",3))

    @GetMapping("/read")
    fun read(): User? = userService.getById(3)
}