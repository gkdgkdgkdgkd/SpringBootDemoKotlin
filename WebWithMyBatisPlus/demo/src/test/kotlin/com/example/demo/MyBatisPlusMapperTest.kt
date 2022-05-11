package com.example.demo

import com.example.demo.entity.User
import com.example.demo.service.MyBatisPlusMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MyBatisPlusMapperTest {
    @Autowired
    private lateinit var myBatisPlusMapper: MyBatisPlusMapper

    @Test
    fun save() {
        myBatisPlusMapper.save(User(3, "mapper-username-3", "mapper-password-3"))
    }

    @Test
    fun delete() {
        myBatisPlusMapper.delete(4)
    }

    @Test
    fun select() {
        println(myBatisPlusMapper.select(1))
    }

    @Test
    fun selectAll() {
        println(myBatisPlusMapper.selectAll())
    }
}