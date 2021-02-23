package com.example.demo

import com.example.demo.entity.User
import com.example.demo.service.Service
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private lateinit var service: Service

    @Test
    fun select() {
        service.select(1)
        service.select(1)
    }

    @Test
    fun selectAll(){
        service.selectAll()
        service.selectAll()
    }

    @Test
    fun delete(){
        service.delete(1)
    }

    @Test
    fun save(){
        val user = User(1,"name1")
        service.save(user)
        service.select(user.id)
        user.name = "name2"
        service.save(user)
        service.select(user.id)
    }
}
