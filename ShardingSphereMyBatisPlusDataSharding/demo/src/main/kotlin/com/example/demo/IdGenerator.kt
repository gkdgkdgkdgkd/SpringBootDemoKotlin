package com.example.demo

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator
import com.github.yitter.contract.IdGeneratorOptions
import com.github.yitter.idgen.YitIdHelper
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class IdGenerator:IdentifierGenerator {
    val options = IdGeneratorOptions(1)

    @PostConstruct
    fun init(){
        YitIdHelper.setIdGenerator(options)
    }

    override fun nextId(entity: Any?):Long?{
        return YitIdHelper.nextId()
    }
}