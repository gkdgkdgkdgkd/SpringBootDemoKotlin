package com.example.demo

import cn.hutool.crypto.SecureUtil
import org.jasypt.encryption.StringEncryptor
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import java.util.*
import javax.annotation.Resource

@SpringBootTest
class DemoApplicationTests {

    @Autowired
//    @Resource(name = "MyEncryptor")
    lateinit var encryptor:StringEncryptor

    @Value("\${test}")
    lateinit var value:String

    @Test
    fun contextLoads() {
        println(encryptor.encrypt(value))
    }

    @Test
    fun decrypt()
    {
        println(value)
    }

    @Test
    fun getPublicKeyAndPrivateKey()
    {
        val pair = SecureUtil.generateKeyPair("RSA")
        println(Base64.getEncoder().encodeToString(pair.public.encoded))
        println(Base64.getEncoder().encodeToString(pair.private.encoded))
    }
}
