package com.example.demo

import org.jasypt.encryption.StringEncryptor
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class EncryptAndDecryptTests {
    @Autowired
    lateinit var encryptor: StringEncryptor

    @Value("\${spring.mail.username}")
    lateinit var username:String
    @Value("\${spring.mail.password}")
    lateinit var password:String

    @Test
    fun encrypt() = println(encryptor.encrypt(username) + "\n" + encryptor.encrypt(password))

    @Test
    fun decrypt() = println(username + "\n" + password)
}