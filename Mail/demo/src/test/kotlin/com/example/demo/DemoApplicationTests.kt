package com.example.demo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.nio.file.Path

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    lateinit var service: MailService

    @Test
    fun contextLoads() {
        service.sendSimpleMail("xxxxx@xx.com", "这是主题", "这是内容")
        javaClass.classLoader.getResource("pic/1.jpg")?.toURI()?.let {
            service.sendAttachmentMail("xxxxx@xx.com", "这是主题", "这是内容", Path.of(it))
        }
    }

}
