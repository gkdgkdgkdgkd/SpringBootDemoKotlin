package com.example.demo

import org.jasypt.encryption.StringEncryptor
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import java.security.KeyPairGenerator
import java.util.Base64
import javax.annotation.Resource

@SpringBootTest
class AsymmetricalEncryptTest {
    @Resource(name = "lazyJasyptStringEncryptor")
    lateinit var encryptor: StringEncryptor

    @Value("\${plain}")
    lateinit var plain: String

    @Value("\${cipher}")
    lateinit var cipher: String

    @Test
    fun generatePublicKeyAndPrivateKey() = with(KeyPairGenerator.getInstance("RSA")) {
        initialize(2048)
        val keyPair = genKeyPair()
        println(Base64.getEncoder().encodeToString(keyPair.private.encoded))
        println(Base64.getEncoder().encodeToString(keyPair.public.encoded))
    }

    @Test
    fun encrypt() = println(encryptor.encrypt(plain))

    @Test
    fun decrypt() = println(cipher)
}