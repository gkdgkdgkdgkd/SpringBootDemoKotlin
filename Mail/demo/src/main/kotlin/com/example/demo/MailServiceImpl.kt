package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.FileSystemResource
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import java.nio.file.Path
import javax.mail.internet.MimeMessage

@Service
class MailServiceImpl:MailService {
    @Autowired
    lateinit var sender:JavaMailSender

    companion object{
        var from = ""
    }

    @Value("\${spring.mail.username}")
    fun setFrom(username:String)
    {
        from = username
    }


    override fun sendSimpleMail(to: String, subject: String, content: String) {
        val message = SimpleMailMessage()
        message.setFrom(from)
        message.setTo(to)
        message.setSubject(subject)
        message.setText(content)
        sender.send(message)
    }

    override fun sendAttachmentMail(to: String, subject: String,content: String, file: Path) {
        val message:MimeMessage = sender.createMimeMessage()
        val helper = MimeMessageHelper(message,true)
        helper.setFrom(from)
        helper.setTo(to)
        helper.setSubject(subject)
        helper.setText(content)
        helper.addAttachment(file.fileName.toString(),FileSystemResource(file))
        sender.send(message)
    }
}