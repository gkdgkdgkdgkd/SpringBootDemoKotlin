package com.example.demo

import com.example.demo.entity.User
import com.example.demo.service.Service
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    lateinit var service: Service

    @Test
    fun contextLoads() {
    }

    @Test
    fun save() = println(service.save(User("1","222","333")))

    @Test
    fun delete() = println(service.delete("3"))

    @Test
    fun select() = println(service.select("1"))

    @Test
    fun selectAll() = println(service.selectAll())

}
