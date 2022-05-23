package com.example.demo

import com.baomidou.mybatisplus.generator.FastAutoGenerator
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine

class Generator

fun main(args: Array<String>) {
    FastAutoGenerator.create("jdbc:mysql://localhost:3306/test", "root", "123456")
        .globalConfig { builder ->
            builder.author("author").outputDir(System.getProperty("user.dir") + "/src/main/kotlin").enableKotlin()
                .build()
        }.packageConfig { builder ->
            builder.parent("com.example.demo").moduleName("user").build()
        }.strategyConfig { builder ->
            builder.addInclude("user").build()
        }.templateEngine(FreemarkerTemplateEngine()).execute()
}