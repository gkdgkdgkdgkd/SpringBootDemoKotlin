package com.example.demo

import com.example.demo.entity.User
import com.example.demo.service.UserService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest {
    @Autowired
    lateinit var service: UserService

    @Test
    fun select() {
        println(service.select(1))
        println(service.select(1))
    }

    @Test
    fun selectAll() {
        println(service.selectAll())
        println(service.selectAll())
    }

    @Test
    fun delete() {
        println(service.delete(1))
        println(service.delete(1))
    }

    @Test
    fun save() {
        val user = User(1, "name1")
        println(service.save(user))
        println(service.select(user.id))
        user.name = "name2"
        println(service.save(user))
        println(service.select(user.id))
    }
}
