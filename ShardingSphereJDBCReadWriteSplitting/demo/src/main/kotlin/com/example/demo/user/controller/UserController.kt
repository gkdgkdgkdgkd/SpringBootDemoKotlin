package com.example.demo.user.controller;

import com.example.demo.user.entity.User
import com.example.demo.user.service.impl.UserServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2022-05-27
 */
@RestController
@RequestMapping("/user")
class UserController {
    @Autowired
    lateinit var userService: UserServiceImpl

    @GetMapping("/select")
    fun select(): User? = userService.getById(1)

    @GetMapping("/insert")
    fun insert() = userService.saveOrUpdate(User(3, "name3"))
}
