package com.example.demo

import org.jasypt.encryption.StringEncryptor
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.Resource

@SpringBootTest
class BaseEncryptTest {
    @Resource(name = "lazyJasyptStringEncryptor")
    lateinit var encryptor: StringEncryptor

    @Value("\${plain}")
    lateinit var plain: String

    @Value("\${cipher}")
    lateinit var cipher: String

    @Test
    fun encrypt() = println(encryptor.encrypt(plain))

    @Test
    fun decrypt() = println(cipher)

}
