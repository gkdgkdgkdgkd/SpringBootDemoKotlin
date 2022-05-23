package com.example.demo.user.controller;

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
 * @since 2022-05-23
 */
@RestController
class UserController {
    @Autowired
    lateinit var userService: UserServiceImpl

    @GetMapping("/test")
    fun test() = userService.getById(1).toString()
}
