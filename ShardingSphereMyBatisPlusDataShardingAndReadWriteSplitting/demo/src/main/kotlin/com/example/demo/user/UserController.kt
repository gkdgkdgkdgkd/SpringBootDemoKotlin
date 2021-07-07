package com.example.demo.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/user")
class UserController {
    @Autowired
    lateinit var userService: UserServiceImpl

    companion object{
        val random = Random()
    }

    @GetMapping("/insert")
    fun insert() = userService.save(User("name", random.nextInt(80)+20,"test@test.com"))

    @GetMapping("/select")
    fun select() = userService.list()
}