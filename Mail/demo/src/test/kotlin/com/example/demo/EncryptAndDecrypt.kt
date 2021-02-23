package com.example.demo

import org.jasypt.encryption.StringEncryptor
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class EncryptAndDecrypt {
    @Autowired
    lateinit var encryptor: StringEncryptor

    companion object {
        var username = ""
        var password = ""
    }

    @Value("\${spring.mail.username}")
    fun setUsername(value: String) {
        username = value
    }

    @Value("\${spring.mail.password}")
    fun setPassword(value: String) {
        password = value
    }

    @Test
    fun getEncrypted() = println(encryptor.encrypt(username) + "\n" + encryptor.encrypt(password))

    @Test
    fun getDecrypted() = println(username + "\n" + password)

}