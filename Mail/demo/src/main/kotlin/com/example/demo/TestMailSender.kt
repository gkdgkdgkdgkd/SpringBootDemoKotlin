package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.FileSystemResource
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import java.nio.file.Path

@Service
class TestMailSender : MailService {
    @Autowired
    lateinit var sender: JavaMailSender

    companion object {
        var from = ""
    }

    @Value("\${spring.mail.username}")
    fun setFrom(username: String) {
        from = username
    }


    override fun sendSimpleMail(to: String, subject: String, content: String) =
        sender.send(SimpleMailMessage().apply {
            setFrom(TestMailSender.from)
            setTo(to)
            setSubject(subject)
            setText(content)
        })

    override fun sendAttachmentMail(to: String, subject: String, content: String, file: Path) =
        sender.send(sender.createMimeMessage().apply {
            MimeMessageHelper(this, true).apply {
                setFrom(TestMailSender.from)
                setTo(to)
                setSubject(subject)
                setText(content)
                addAttachment(file.fileName.toString(), FileSystemResource(file))
            }
        })
}