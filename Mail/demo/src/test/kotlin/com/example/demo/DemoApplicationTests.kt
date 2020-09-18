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
        service.sendSimpleMail("xxx@xxx.com", "这是主题", "这是内容")
        service.sendAttachmentMail("xxx@xxx.com", "这是主题", "这是内容", Path.of(javaClass.classLoader.getResource("pic/1.jpg")?.toURI()))
        service.sendAttachmentMail("xxx@xxx.com", "这是主题", "这是内容", Path.of("/","home","xxx","Desktop","1.jpg"))
    }

}
