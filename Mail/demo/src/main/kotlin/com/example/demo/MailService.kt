package com.example.demo

import java.nio.file.Path

interface MailService {
    fun sendSimpleMail(to:String, subject:String, content:String)
    fun sendAttachmentMail(to: String, subject: String, content:String, file: Path)
}