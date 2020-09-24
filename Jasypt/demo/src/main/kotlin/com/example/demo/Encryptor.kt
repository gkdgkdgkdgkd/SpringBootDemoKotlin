package com.example.demo

import org.jasypt.encryption.StringEncryptor
import org.springframework.stereotype.Component

//@Component("MyEncryptor")
class Encryptor:StringEncryptor {
    override fun encrypt(message: String?): String {
        return message+"111"
    }

    override fun decrypt(encryptedMessage: String?): String? {
        return encryptedMessage?.substring(0, encryptedMessage.indexOf("111"));
    }
}