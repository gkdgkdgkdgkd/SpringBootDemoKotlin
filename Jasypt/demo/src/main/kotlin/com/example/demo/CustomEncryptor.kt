package com.example.demo

import org.jasypt.encryption.StringEncryptor
import org.springframework.stereotype.Component

@Component
class CustomEncryptor : StringEncryptor {
    override fun encrypt(message: String) = message + "111"

    override fun decrypt(encryptedMessage: String) = encryptedMessage.substring(0, encryptedMessage.indexOf("111"))
}