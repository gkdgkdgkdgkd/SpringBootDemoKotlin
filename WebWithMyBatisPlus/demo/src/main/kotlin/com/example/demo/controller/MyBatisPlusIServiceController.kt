package com.example.demo.controller

import com.example.demo.entity.User
import com.example.demo.service.MyBatisPlusIService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/iservice")
class MyBatisPlusIServiceController
{
    @Autowired
    lateinit var myBatisPlusIService: MyBatisPlusIService

    @GetMapping("select")
    fun select1(@RequestParam id:String): User? = myBatisPlusIService.select(id)

    @GetMapping("select/{id}")
    fun select2(@PathVariable("id") id:String): User? = myBatisPlusIService.select(id)

    @GetMapping("selectAll")
    fun selectAll(): List<User> = myBatisPlusIService.selectAll()

    @GetMapping("delete")
    fun delete1(@RequestParam id:String) = myBatisPlusIService.delete(id)

    @GetMapping("delete/{id}")
    fun delete2(@PathVariable("id") id:String) = myBatisPlusIService.delete(id)

    @PostMapping("save")
    fun save(@RequestBody user: User) = myBatisPlusIService.save(user)

}