package com.example.demo

import com.example.demo.entity.User
import com.example.demo.service.MyBatisPlusIService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MyBatisPlusIServiceTest {
    @Autowired
    lateinit var myBatisPlusIService: MyBatisPlusIService

    @Test
    fun save() {
        myBatisPlusIService.save(User("1", "2", "3"))
    }

    @Test
    fun delete() {
        myBatisPlusIService.delete("3")
    }

    @Test
    fun select() {
        println(myBatisPlusIService.select("1"))
    }

    @Test
    fun selectAll() {
        println(myBatisPlusIService.selectAll())
    }
}

