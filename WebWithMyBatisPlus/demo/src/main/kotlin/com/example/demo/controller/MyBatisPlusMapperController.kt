package com.example.demo.controller

import com.example.demo.entity.User
import com.example.demo.service.MyBatisPlusMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/mapper")
class MyBatisPlusMapperController {
    @Autowired
    private lateinit var myBatisPlusMapper: MyBatisPlusMapper

    @GetMapping("select/id")
    fun select1(@RequestParam id:Long): User? = myBatisPlusMapper.select(id)

    @GetMapping("select/id/{id}")
    fun select2(@PathVariable("id") id:Long): User? = myBatisPlusMapper.select(id)

    @GetMapping("select/all")
    fun selectAll(): List<User>? = myBatisPlusMapper.selectAll()

    @GetMapping("delete")
    fun delete1(@RequestParam id:Long) = myBatisPlusMapper.delete(id)

    @GetMapping("delete/{id}")
    fun delete2(@PathVariable id:Long) = myBatisPlusMapper.delete(id)

    @PostMapping("save")
    fun save(@RequestBody user: User) = myBatisPlusMapper.save(user)
}