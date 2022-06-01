package com.example.demo.user.controller;

import com.example.demo.user.entity.User
import com.example.demo.user.service.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2022-06-01
 */
@RestController
@RequestMapping("/user")
class UserController{
    @Autowired
    lateinit var userService: IUserService

    @GetMapping("/insert")
    fun insert() = userService.save(User().apply {
        age = (1..100).random()
        name = "name"
    })

    @GetMapping("/select")
    fun select(): List<User>? = userService.list()
}
