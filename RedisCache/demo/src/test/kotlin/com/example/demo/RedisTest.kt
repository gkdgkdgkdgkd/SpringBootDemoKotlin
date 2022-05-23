package com.example.demo

import com.example.demo.entity.User
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.StringRedisTemplate

@SpringBootTest
class RedisTest {
    @Autowired
    lateinit var stringRedisTemplate: StringRedisTemplate

    @Autowired
    lateinit var redisTemplate: RedisTemplate<String, User>

    @Test
    fun redisTemplateTest() {
        val KEY = "key"
        stringRedisTemplate.opsForValue().set(KEY, "value")
        println("$KEY -> ${stringRedisTemplate.opsForValue().get(KEY)}")

        val USER_KEY = "user_key"
        redisTemplate.opsForValue().set(USER_KEY, User(1, "name"))
        println("$USER_KEY -> ${redisTemplate.opsForValue().get(USER_KEY)}")
    }
}