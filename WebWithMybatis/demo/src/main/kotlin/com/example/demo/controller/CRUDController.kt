package com.example.demo.controller

import com.example.demo.entity.User
import com.example.demo.service.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/")
class CRUDController {
    @Autowired
    lateinit var service: Service

    @PostMapping("save")
    fun save(@RequestBody user: User) = service.save(user)

    @GetMapping("delete")
    fun delete(@RequestParam id: String) = service.delete(id)

    @GetMapping("select")
    fun select(@RequestParam id: String) = service.select(id)

    @GetMapping("selectAll")
    fun selectAll() = service.selectAll()

}