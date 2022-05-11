package com.example.demo.controller

import com.example.demo.entity.User
import com.example.demo.service.MyBatisPlusIService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/iservice/")
class MyBatisPlusIServiceController {
    @Autowired
    private lateinit var myBatisPlusIService: MyBatisPlusIService

    @GetMapping("select/id")
    fun select1(@RequestParam id:Long): User? = myBatisPlusIService.select(id)

    @GetMapping("select/id/{id}")
    fun select2(@PathVariable("id") id:Long): User? = myBatisPlusIService.select(id)

    @GetMapping("select/all")
    fun selectAll(): List<User>? = myBatisPlusIService.selectAll()

    @GetMapping("delete")
    fun delete1(@RequestParam id:Long) = myBatisPlusIService.delete(id)

    @GetMapping("delete/{id}")
    fun delete2(@PathVariable id:Long) = myBatisPlusIService.delete(id)

    @PostMapping("save")
    fun save(@RequestBody user:User) = myBatisPlusIService.save(user)
}